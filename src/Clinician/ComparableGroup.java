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


public class ComparableGroup {
    private List<Patient_Cl> patientGroup;

    public ComparableGroup(List<Patient_Cl> patientGroup) {
        this.patientGroup = patientGroup;
    }

    public void compareWithPatient(Patient_Cl patient) {
        // Filter patient group based on aetiology, gender, age, height, and weight
        List<Patient_Cl> filteredGroup = filterPatientGroup(patient.getAetiology(), patient.getGender(), patient.getAge(), patient.getHeight(), patient.getWeight());

        // Filter EE values of the patient group using RQ filter
        List<ICData_Cl> filteredEE_Group = Filter_Cl.filterEEWithRQ((Map<String, List<Object>>) filteredGroup);

        // Calculate the average EE of the filtered patient group
        double averageEE = calculateAverageEE(filteredEE_Group);

        // Compare the patient's EE with the average EE of the patient group
        double deviationPercentage = calculateDeviationPercentage(patient.getEE(), averageEE);
    }

    private List<Patient_Cl> filterPatientGroup(String aetiology, String gender, int age, double height, double weight) {
        // Create a new list to store the filtered patients
        List<Patient_Cl> filteredGroup = new ArrayList<>();

        for (Patient_Cl patient : patientGroup) {
            // Check if the patient's aetiology, gender, age, height, and weight match the criteria
            if (patient.getAetiology().equals(aetiology) && patient.getGender().equals(gender)
                    && Math.abs(patient.getAge() - age) <= 10
                    && Math.abs(patient.getHeight() - height) <= 10
                    && Math.abs(patient.getWeight() - weight) <= 10) {
                filteredGroup.add(patient);
            }
        }

        return filteredGroup;
    }

    private double calculateAverageEE(List<ICData_Cl> filteredEE) {
        double totalEE = 0.0;
        int totalDays = 0;

        for (ICData_Cl icData : filteredEE) {
            totalEE += icData.getEE();
            totalDays++;
        }

        return totalEE / totalDays;
    }

    private double calculateDeviationPercentage(double patientEE, double averageEE) {
        return (averageEE - patientEE) / patientEE;
    }
}


