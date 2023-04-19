/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DatabaseHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import DatabaseHandler.DatabaseConnection;
  

/**
 *
 * @author signekristiansen
 */
public class DatabaseUpdater {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // Connect to the database
         
        Connection conn = DatabaseConnection.getInstance().getConnection();
            //Connection conn = DriverManager.getConnection("jdbc:mysql://db.course.hst.aau.dk:3306/hst_hst-22-st-5-5401?serverTimezone=UTC", "hst_hst-23-st-6-6401", "esohjaingohshaefeipe");
          // Update the table
            updateTable(conn);
            
//             Add a new column to the table
            addColumn(conn);
            
            // Close the connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static void updateTable(Connection conn) throws SQLException {
        // Update the table by replacing commas with dots in all columns
        String sql = "UPDATE ICdata SET FiO2Set = REPLACE(FiO2Set, ',', '.'), VtSet = REPLACE(VtSet, ',', '.'), IESet = REPLACE(IESet, ',', '.')";
        Statement stmt = conn.createStatement();
        int rowsUpdated = stmt.executeUpdate(sql);
        System.out.println("Rows updated: " + rowsUpdated);
    }
    
    private static void addColumn(Connection conn) throws SQLException {
        // Add a new column to the table
        String sqlAlterTable = "ALTER TABLE ICdata ADD RQ FLOAT";
        Statement stmtAlterTable = conn.createStatement();
        stmtAlterTable.execute(sqlAlterTable);
        
        // Calculate the values for the new column
        String sqlUpdate = "UPDATE ICdata SET RQ = CASE WHEN VO2 > 0 AND VCO2 >= 0 THEN VCO2 / VO2 ELSE NULL END";
        Statement stmtUpdate = conn.createStatement();
        int rowsUpdated = stmtUpdate.executeUpdate(sqlUpdate);
        System.out.println("Rows updated: " + rowsUpdated);
    }

}
