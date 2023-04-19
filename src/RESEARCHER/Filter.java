package RESEARCHER;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Filter {
    
    public static Map<String, List<Object>> filterData(Map<String, List<Object>> data, double rqLow, double rqHigh) {
    int excludedCount = 0;
    List<String> excludedUnits = new ArrayList<>();

    for (Map.Entry<String, List<Object>> entry : data.entrySet()) {
        List<Object> dataList = entry.getValue();

        for (int i = 0; i < dataList.size(); i++) {
            Object dataObject = dataList.get(i);

            if (dataObject instanceof Map) {
                Map<String, Object> dataMap = (Map<String, Object>) dataObject;
                if (dataMap.containsKey("RQ")) {
                    double RQ = (double) dataMap.get("RQ");
                    if (RQ < rqLow || RQ > rqHigh) {
                        excludedCount++;
                        excludedUnits.add(entry.getKey());
                        dataList.remove(i);
                        i--;
                    }
                }
            }
        }
    }

    System.out.println("Number of excluded data points: " + excludedCount/5); //divide with number of data unitId, EE, RQ, VO2, VentModeSet
    //System.out.println("Excluded units: " + excludedUnits);
    return data;
}


 
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
