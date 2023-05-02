/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinician;
import java.util.List;

/**
 *
 * @author sophiahaackvadstrup
 */
public class Patient_Cl{

    private int patientCardId;
    private String gender;
    private int age;
    private int weight;
    private int height;
    private String aetiology;
    private int measurementDuration;
    private List<ICData_Cl> icDataList_Cl;

    public Patient_Cl(int patientCardId, String gender, String aetiology, int age, int weight, int height, int measurementDuration) {
        this.patientCardId = patientCardId;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.aetiology = aetiology;
        this.measurementDuration = measurementDuration;
        this.icDataList_Cl = icDataList_Cl;
    }


    

 
    public void setPatientCardId(int patientCardId) {
    this.patientCardId = patientCardId;
}
public int getPatientCardId() {
    return patientCardId;
}
    
public void setGender(String gender) {
    this.gender = gender;
}

public void setAge(int age) {
    this.age = age;
}

public void setWeight(int weight) {
    this.weight = weight;
}

public void setHeight(int height) {
    this.height = height;
}

public void setAetiology(String string) {
    this.aetiology = aetiology;
}

public int getHeight() {
    return height;
}

public String getAetiology() {
    return aetiology;
}
public String getGender() {
    return gender;
}

public int getAge() {
    return age;
}

public int getWeight() {
    return weight;
}

public int getMeasurementDuration() {
    return measurementDuration;
}


  public List<ICData_Cl> getIcDataList_Cl() {
        return icDataList_Cl;
    }

    public void setMeasurementDuration(int measurementDuration) {
        this.measurementDuration = measurementDuration;
    }

    public void setIcDataList_Cl(List<ICData_Cl> icDataList_Cl) {
        this.icDataList_Cl = icDataList_Cl;
    }
  
    
   // override the toString() method return a string representation of the object's data.   
@Override
public String toString() {
    return "Patient{" +
            "patientCardId=" + patientCardId +
            ", age=" + age +
            ", gender='" + gender + '\'' +
            ", weight='" + weight + '\'' +
            ", height='" + height + '\'' +
            ", aetiology='" + aetiology + '\'' +
            ", MeasurementDuration='" + measurementDuration + '\'' +
            '}';
}
    
 //metode til HB
 public static int calculateHBE(int age, String gender, int weight, int height){

 //Calculate harris benedict equation + show
   int hbe;
            if(gender.equals("male")) {
                hbe = (int) (66.5 + (13.8 * weight) + (5.0 * height) - (6.8 * age));
            } else {
                hbe = (int) (655.1 + (9.6 * weight) + (1.8 * height) - (4.7 * age)) ;
            }
        return hbe;
}


public static double calculateDeviationPercentage(int hbe, double averageEE) {
       double deviation = (averageEE - hbe) / hbe * 100.0;
        return deviation;
    }

    double getEE() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}

  


    

 
