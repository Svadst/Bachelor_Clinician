
package statmedx1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import statmedx1.DatabaseConnection;
import statmedx1.DatabaseTEST;

/**
 *
 * @author signekristiansen
 */
public class Filter {
    
    // Method to filter values from a database table
    public static List<String> EEfilter(String sqlQuery, int filterValue) {
        List<String> filteredValues = new ArrayList<>();
        List<String> nofilteredValues = new ArrayList<>();
        
        try {
            // Establish a connection to the database
            //Connection conn = DriverManager.getConnection("jdbc:mysql://db.course.hst.aau.dk:3306/hst_hst-22-st-5-5401?serverTimezone=UTC", "hst_hst-22-st-5-5401", "feeshoopasewoothoogi");
            Connection conn = DatabaseTEST.getInstance().getConnection(); 
           // Create a statement to execute a SQL query with a parameter
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            stmt.setInt(1, filterValue);
        
            // Execute the query and get the result set
            ResultSet rs = stmt.executeQuery();
             
            // Iterate through the result set and add values to the filteredValues list
            while (rs.next()) {
                String value = rs.getString("EE");
                filteredValues.add(value);
            }
            
            // Close the connection, statement, and result set
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return filteredValues;
    }

    Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }
