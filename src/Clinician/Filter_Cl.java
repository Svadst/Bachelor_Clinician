/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinician;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import DatabaseHandler.DatabaseConnection;
import java.util.HashMap;
import statmedx1.Filter;


/**
 *
 * @author sophiahaackvadstrup
 */


public class Filter_Cl {
      public static List<ICData_Cl> filterEEWithRQ(Map<String, List<Object>> selectedData) {
        List<ICData_Cl> filteredEE = new ArrayList<>();
    
 
         // Create a new instance of the database connection class
   DatabaseConnection dbConn = DatabaseConnection.getInstance();

        for (Map.Entry<String, List<Object>> entry : selectedData.entrySet()) {
            List<Object> resultList = entry.getValue();
            for (Object result : resultList) {
                if (result instanceof ICData_Cl) {
                    ICData_Cl icdata = (ICData_Cl) result;
                    if (icdata.getRQ() >= 0.7 && icdata.getRQ() <= 1.0) {
                        filteredEE.add(icdata);
                    }
                }
            }
        }

        return filteredEE;
    }
    public static double calculateAverageEE(List<ICData_Cl> filteredEE) {
    double totalEE = 0.0;
    int totalDays = 0;

    for (ICData_Cl icdata : filteredEE) {
        if (icdata.getEE() > 0) {
            totalEE += icdata.getEE();
            totalDays++;
        }
    }
    return totalEE / totalDays;
}



      public static void main(String[] args) {
        // After calling the fetchData method
    }

}     

       






    




    

    

