/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinician;
import DatabaseHandler.DatabaseConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Clinician.Filter_Cl;
import java.util.ArrayList;
import java.util.List;
import Clinician.Visualise_Cl1;
import Clinician.Patient_Cl;



import java.util.List;

public class ComparableGroup {
    private List<Patient_Cl> similarPatients;

    public ComparableGroup(int patientCardId) {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        similarPatients = dbConnection.fetchSimilarPatients(patientCardId);
    }

    public List<Patient_Cl> getSimilarPatients() {
        return similarPatients;
    }

    public void calculateEEValuePerDay() {
        // Perform calculations for EE value per day for the similar group
        for (Patient_Cl patient : similarPatients) {
            // Get the ICData_Cl instances for the current patient
            List<ICData_Cl> icDataList = patient.getIcDataList_Cl();

            // Calculate EE value per day for the patient
            double totalEE = 0.0;
            int totalDays = 0;
            for (ICData_Cl icData : icDataList) {
                totalEE += icData.getEE();
                totalDays++;
            }

            double eeValuePerDay = totalEE / totalDays;
            System.out.println("Patient " + patient.getPatientCardId() + ": EE value per day = " + eeValuePerDay);
        }
    }

    public static void main(String[] args) {
        int patientCardId = 93; // Replace with the desired patientCardId

        ComparableGroup comparableGroup = new ComparableGroup(patientCardId);
        List<Patient_Cl> similarPatients = comparableGroup.getSimilarPatients();

        // Process the similarPatients list as needed
        for (Patient_Cl patient : similarPatients) {
            System.out.println(patient); // Print or perform operations on each similar patient
        }

        comparableGroup.calculateEEValuePerDay();
    }
}
