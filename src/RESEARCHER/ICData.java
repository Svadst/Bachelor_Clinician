
package RESEARCHER;


public class ICData {
    private int unitID;
    private double ee;
    private double rq;
    private double vo2;
    private double ventModeSet;

    public ICData(int unitID, double ee, double rq, double vo2, double ventModeSet) {
        this.unitID = unitID;
        this.ee = ee;
        this.rq = rq;
        this.vo2 = vo2;
        this.ventModeSet = ventModeSet;
       
    }

    
    public int setUnitID(int Int) {
        return unitID;
    }

    public double setEE(double Double) {
        return ee;
    }

    public double setRQ(double Double) {
        return rq;
    }

    public double setVO2(double Double) {
        return vo2;
    }

    public double setVentModeSet(double Double) {
        return ventModeSet;
    }

    public int getUnitID() {
        return unitID;
    }

    public double getEE() {
        return ee;
    }

    public double getRQ() {
        return rq;
    }

    public double getVO2() {
        return vo2;
    }

    public double getVentModeSet() {
        return ventModeSet;
    }
    
    
     // override the toString() method  return a string representation of the object's data.   
@Override
public String toString() {
    return "ICData{" +
            "unitID=" + unitID +
            ", EE=" + ee +
            ", RQ=" + rq +
            ", VO2=" + vo2 +
            ", ventModeSet=" + ventModeSet +
            '}';
}
}
