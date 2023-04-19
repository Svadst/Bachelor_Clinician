/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Research;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author signekristiansen
 */
public class VariableSelection {


public static void VariableSelecter(Map<String, List<Object>> data) {
    List<Double> eeBins16 = new ArrayList<>();
    List<Double> eeBins18 = new ArrayList<>();
    List<Double> eeBins20 = new ArrayList<>();

    for (Map.Entry<String, List<Object>> entry : data.entrySet()) {
        System.out.println("Unit ID: " + entry.getKey());
        List<Object> dataList = entry.getValue();
        Map<String, Object> unitData = (Map<String, Object>) dataList.get(0);
        System.out.println("Sex: " + unitData.get("Sex"));
        System.out.println("Aetiology: " + unitData.get("aetiology"));
        System.out.println("Height: " + unitData.get("Height"));
        System.out.println("Age: " + unitData.get("Age"));
        System.out.println("Weight: " + unitData.get("Weight"));

        for (int i = 1; i < dataList.size(); i++) {
            Object dataObject = dataList.get(i);
            if (dataObject instanceof Map) {
                Map<String, Object> dataMap = (Map<String, Object>) dataObject;
                if (dataMap.containsKey("VentModeSet")) {
                    Number ventModeSet = (Number) dataMap.get("VentModeSet");
                    if (ventModeSet.doubleValue() >= 16.0 && ventModeSet.doubleValue() < 18.0) {
                        eeBins16.add(((Number) dataMap.get("EE")).doubleValue());
                    } else if (ventModeSet.doubleValue() >= 18.0 && ventModeSet.doubleValue() < 20.0) {
                        eeBins18.add(((Number) dataMap.get("EE")).doubleValue());
                    } else if (ventModeSet.doubleValue() >= 20.0) {
                        eeBins20.add(((Number) dataMap.get("EE")).doubleValue());
                    }
                }
            }
        }

        // Print the eebins lists
        System.out.println("EE bin 1 (VentModeSet 16): " + eeBins16);
        System.out.println("EE bin 2 (VentModeSet 18): " + eeBins18);
        System.out.println("EE bin 3 (VentModeSet 20): " + eeBins20);
    }

  }

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}