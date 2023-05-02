/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinician;

import DatabaseHandler.DatabaseConnection;
import java.util.List;
import java.util.Map;
import Clinician.Filter_Cl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author sophiahaackvadstrup
 */
public class ICData_Cl {

    private int patientCardId;
    private double EE;
    private double RQ;
    private int day;
    private List<ICData_Cl> icDataList_Cl;
 


    public ICData_Cl(int patientCardId, double EE, int day, double RQ) {
        this.patientCardId = patientCardId;
        this.EE = EE;
        this.RQ = RQ;
        this.day = day;
        this.icDataList_Cl = new ArrayList<>();
        this.icDataList_Cl.add(this);

        
       
    }

    public int setPatientCardId(int Int) {
        return patientCardId;
    }

    public double setEE(double Double) {
        return EE;
    }

    
    public int setday(double Int) {
        return day;
    }

    public void setRQ(double Double) {
        this.RQ = RQ;
    }


    public int getPatientCardId( int Int) {
        return patientCardId;
    }

    public double getEE() {
        return EE;
    }

    public int getday() {
        return day;
    }


    public double getRQ() {
        return RQ;
    }

    public void setIcDataList_Cl(List<ICData_Cl> icDataList_Cl) {
        this.icDataList_Cl = icDataList_Cl;
    }
    

    
     // override the toString() method return a string representation of the object's data.   
@Override
public String toString() {
    return "ICData_Cl{" +
            "patientCardId=" + patientCardId +
            ", EE=" + EE +
            ", day=" + day +
            ", RQ=" + RQ +
            '}';
}

public static double calculateCoefficientOfVariation(List<ICData_Cl> icDataList) {
        List<Double> eeValues = new ArrayList<>();

        for (ICData_Cl icData : icDataList) {
            eeValues.add(icData.getEE());
        }

        double mean = calculateMean(eeValues);
        double variance = calculateVariance(eeValues, mean);
        double standardDeviation = Math.sqrt(variance);

        // Calculate the coefficient of variation
        double coefficientOfVariation = (standardDeviation / mean) * 100;

        return coefficientOfVariation;
    }
       public static double calculateMean(List<Double> values) {
        double sum = 0.0;

        for (double value : values) {
            sum += value;
        }

        return sum / values.size();
    }

    public static double calculateVariance(List<Double> values, double mean) {
        double sumOfSquaredDifferences = 0.0;

        for (double value : values) {
            double difference = value - mean;
            sumOfSquaredDifferences += difference * difference;
        }

        return sumOfSquaredDifferences / values.size();
    }
}



    
