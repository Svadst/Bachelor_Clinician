/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinician;

/**
 *
 * @author sophiahaackvadstrup
 */
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import Clinician.Filter_Cl;
import Clinician.ICData_Cl;

public class PatientComparator {
    private static final double MIN_RQ = 0.7;
    private static final double MAX_RQ = 1.0;
    private static final int AGE_INTERVAL = 5;
    private static final int HEIGHT_INTERVAL = 10;
    private static final int WEIGHT_INTERVAL = 10;

    public static List<ICData_Cl> comparePatientWithGroup(PatientData_Cl patient, List<PatientData_Cl> patientGroup) {
        List<ICData_Cl> filteredEE = new ArrayList<>();

        // Filter the patient group's EE values based on RQ
        Map<String, List<Object>> selectedData = new HashMap<>();
        for (PatientData_Cl groupPatient : patientGroup) {
            selectedData.put(groupPatient.getPatientCardId(), groupPatient.getICData());
        }
        filteredEE = Filter_Cl.filterEEWithRQ(selectedData);

        // Compare the patient with the filtered patient group based on specified criteria
        for (ICData_Cl icdata : filteredEE) {
            if (patient.getAetiology().equals(icdata.getAetiology()) &&
                    patient.getGender().equals(icdata.getGender()) &&
                    Math.abs(patient.getAge() - icdata.getAge()) <= AGE_INTERVAL &&
                    Math.abs(patient.getHeight() - icdata.getHeight()) <= HEIGHT_INTERVAL &&
                    Math.abs(patient.getWeight() - icdata.getWeight()) <= WEIGHT_INTERVAL) {
                filteredEE.add(icdata);
            }
        }

        return filteredEE;
    }

    public static List<PatientData_Cl> retrievePatientsWithCriteria(String aetiology, String gender, int minAge, int maxAge, int minHeight, int maxHeight, int minWeight, int maxWeight) {
        List<PatientData_Cl> patients = new ArrayList<>();

        try {
            // Establish a database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");

            // Create the SQL statement
            String sql = "SELECT * FROM PatientData WHERE Aetiology = ? AND Gender = ? " +
                        "AND Age BETWEEN ? AND ? AND Height BETWEEN ? AND ? AND Weight BETWEEN ? AND ?";

            // Prepare the statement
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aetiology);
            stmt.setString(2, gender);
            stmt.setInt(3, minAge);
            stmt.setInt(4, maxAge);
            stmt.setInt(5, minHeight);
            stmt.setInt(6, maxHeight);
            stmt.setInt(7, minWeight);
            stmt.setInt(8, maxWeight);

            // Execute the query
            ResultSet rs = stmt.executeQuery();

            // Process the results
            while (rs.next()) {
                String patientCardId = rs.getString("PatientCardId");
                int age = rs.getInt("Age");
                int height = rs.getInt("Height");
                int weight = rs.getInt("Weight");
                String aetiology = rs.getString("Aetiology");
                String gender = rs.getString("Gender");

                // Create a new PatientData_Cl object
                PatientData_Cl patient = new PatientData_Cl(patientCardId, age, height, weight, aetiology, gender);

                // Add the patient to the list
                patients.add(patient);
            }

            // Close the resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patients;
    }
}

