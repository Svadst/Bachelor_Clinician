
package RESEARCHER;

import java.util.ArrayList;
import java.util.List;


public class Patient {
    private int unitID;
    private String gender;
    private int age;
    private int weight;
    private int height;
    private String aetiology;
    private List<ICData> icDataList;

    public Patient(int unitID, String gender, int age, int weight, String aetiology) {
        this.unitID = unitID;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.aetiology = aetiology;
        this.icDataList = new ArrayList<>();
    }

    public int setUnitID(int Int) {
        return unitID;
    }
    
      public int getUnitID() {
        return unitID;
    }

    public String setGender(String string) {
        return gender;
    }

    public int setAge(int Int) {
        return age;
    }

    public int setWeight(int Int) {
        return weight;
    }

    public int getHeight(int Int) {
        return height;
    }

    public String setAetiology(String string) {
        return aetiology;
    }

    public List<ICData> getICDataList() {
        return icDataList;
    }

    public void addICData(ICData icData) {
        icDataList.add(icData);
    }
    
 // override the toString() method return a string representation of the object's data.   
@Override
public String toString() {
    return "Patient{" +
            "UnitID=" + unitID +
            ", age=" + age +
            ", gender='" + gender + '\'' +
            ", weight='" + weight + '\'' +
            ", height='" + height + '\'' +
            ", aetiology='" + aetiology + '\'' +
            '}';
}


    
}