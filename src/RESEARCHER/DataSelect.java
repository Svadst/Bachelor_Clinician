package RESEARCHER;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import DatabaseHandler.DatabaseConnection;
import java.util.Arrays;
import java.util.Collections;
import RESEARCHER.Patient;

public class DataSelect {
    private Connection conn;

  public Map<String, List<Object>> fetchData(List<String> aetiologies) {
    Map<String, List<Object>> resultMap = new HashMap<>();

    try {
        // Connection to database from class DatabaseTEST
        Connection conn = DatabaseConnection.getInstance().getConnection();
        String aetiologyStr = String.join(",", Collections.nCopies(aetiologies.size(), "?"));
        String patientQuery = "SELECT * FROM PatientData WHERE aetiology IN (" + aetiologyStr + ")";
        PreparedStatement patientStmt = conn.prepareStatement(patientQuery);
        int i = 1;
        for (String aetiology : aetiologies) {
            patientStmt.setString(i++, aetiology);
        }
        // Execute the SQL query to select patient data
        ResultSet patientResult = patientStmt.executeQuery();
        // Loop through each patient in the result set
        while (patientResult.next()) {
            // Create a new Patient instance with the data from the current row in the result set
            Patient patient = new Patient(patientResult.getInt("UnitID"),
                              patientResult.getString("Gender"),
                              patientResult.getInt("age"),
                              patientResult.getInt("Weight"),
                              patientResult.getInt("Height"),
                              patientResult.getString("aetiology"));
            patient.setUnitID(patientResult.getInt("UnitID"));
            patient.setGender(patientResult.getString("Gender"));
            patient.setAge(patientResult.getInt("age"));
            patient.setWeight(patientResult.getInt("Weight"));
            patient.setHeight(patientResult.getInt("Height"));
            patient.setAetiology(patientResult.getString("aetiology"));
            // Create a new List to hold the Patient and ICData instances for this patient
            List<Object> resultList = new ArrayList<>();
            resultList.add(patient);
            // Create a SQL query to select IC data for the current patient
            String icdataQuery = "SELECT * FROM ICdata WHERE UnitID = ?";
            PreparedStatement icdataStmt = conn.prepareStatement(icdataQuery);
            // Set the value of the question mark in the SQL query to the current patient's ID
            icdataStmt.setInt(1, patient.getUnitID());
            // Execute the SQL query to select IC data
            ResultSet icdataResult = icdataStmt.executeQuery();
            while (icdataResult.next()) {
                // Create a new ICData instance with the data from the current row in the result set
                ICData icdata = new ICData(icdataResult.getInt("UnitID"),
                            icdataResult.getDouble("EE"),
                            icdataResult.getDouble("RQ"),
                            icdataResult.getDouble("VO2"),
                            icdataResult.getDouble("VentModeSet"));
                icdata.setUnitID(icdataResult.getInt("UnitID"));
                icdata.setEE(icdataResult.getDouble("EE"));
                icdata.setRQ(icdataResult.getDouble("RQ"));
                icdata.setVO2(icdataResult.getDouble("VO2"));
                icdata.setVentModeSet(icdataResult.getDouble("VentModeSet"));
                // Add the ICData instance to the resultList
                resultList.add(icdata);
            }
            // Add the resultList to the resultMap
            resultMap.put("patient " + patient.getUnitID(), resultList);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return resultMap;
}

}