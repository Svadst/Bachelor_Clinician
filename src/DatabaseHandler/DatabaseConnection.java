/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseHandler;
import Clinician.ICData_Cl;
import Clinician.Patient_Cl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTextField;


public class DatabaseConnection {
    
private static DatabaseConnection instance = null;
private static Connection conn;

private DatabaseConnection(){
    String url = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_hst-23-st-6-6401?serverTimezone=UTC";
    String driver = "com.mysql.cj.jdbc.Driver";
    String userName = "hst_hst-23-st-6-6401"; 
    String password = "esohjaingohshaefeipe";
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url,userName, password);
                }

                    catch(ClassNotFoundException cnfErr)
                    {cnfErr.printStackTrace();
                    }
                    catch(SQLException err)
                    {err.printStackTrace();
                    }
}
    public static DatabaseConnection getInstance() {
        if(instance == null)
    return new DatabaseConnection();
        else
    return instance;
}

    public static Connection getConnection() {
     return conn;
}

  ///metode til at hente Data fra PatientData og ICdata til klinikeren
    //
   public static void main(String[] args) {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        // call methods from dbConnection to perform database operations
    }
public Map<String, List<Object>> fetchData(int patientCardId) {
    Map<String, List<Object>> resultMap = new HashMap<>();


    
    try {
        // Connection to database from class DatabaseTEST
        Connection conn = DatabaseConnection.getInstance().getConnection();

     String patientQuery = "SELECT * FROM PatientData_Cl WHERE PatientCardId = ?";
        PreparedStatement patientStmt = conn.prepareStatement(patientQuery);
        patientStmt.setInt(1, patientCardId);

        // Execute the SQL query to select patient data
        ResultSet patientResult = patientStmt.executeQuery();
        
        
        // Loop through each patient in the result set
        while (patientResult.next()) {
         // Create a new Patient instance with the data from the current row in the result set
           
    Patient_Cl patient = new Patient_Cl(patientResult.getInt("PatientCardId"),
                    patientResult.getString("Gender"),
                    patientResult.getString("Aetiology"),
                    patientResult.getInt("Age"),
                    patientResult.getInt("Weight"),
                    patientResult.getInt("Height"),
                    patientResult.getInt("MeasurementDuration"));
         
     
                // Create a new List to hold the Patient_Cl and ICData_Cl instances for this patient
                List<Object> resultList = new ArrayList<>();
                resultList.add(patient);
                // Create a SQL query to select IC data for the current patient
                String icdataQuery = "SELECT PatientCardId, EE, day, RQ FROM ICData_Cl WHERE PatientCardId = ?";
                PreparedStatement icdataStmt = conn.prepareStatement(icdataQuery);
                // Set the value of the question mark in the SQL query to the current patient's ID
                icdataStmt.setInt(1, patient.getPatientCardId());
                // Execute the SQL query to select IC data
                ResultSet icdataResult = icdataStmt.executeQuery();
                List<Double> eeValues = new ArrayList<>();
                
                while (icdataResult.next()) {
                    // Create a new ICData_Cl instance with the data from the current row in the result set
                    ICData_Cl icdata = new ICData_Cl(icdataResult.getInt("PatientCardId"),
                            icdataResult.getDouble("EE"),
                            icdataResult.getInt("day"),
                            icdataResult.getDouble("RQ"));
                icdata.setPatientCardId(icdataResult.getInt("PatientCardId"));
                icdata.setEE(icdataResult.getDouble("EE"));
                icdata.setRQ(icdataResult.getDouble("RQ"));
                icdata.setday(icdataResult.getInt("day"));
                    
                 // Add the ICData_Cl instance to the resultList
                 
                resultList.add(icdata);
                eeValues.add(icdata.getEE()); // Collect EE values for coefficient of variation calculation
                }
                // Add the resultList to the resultMap
                resultMap.put("patient " + patient.getPatientCardId(), resultList);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultMap;
    }

    public List<ICData_Cl> fetchICData(int PatientCardId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }




}

    


