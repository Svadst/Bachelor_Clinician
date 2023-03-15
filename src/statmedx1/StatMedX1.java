/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package statmedx1;

import java.sql.Connection;
import java.util.List;
import statmedx1.DatabaseConnection;
import static statmedx1.Filter.EEfilter;




/**
 *
 * @author Rikke
 */
public class StatMedX1 {

    

    /**
     * @param args the command line arguments
     */
    //Connection conn = DatabaseConnection.getConnection();
  
       

        
    public static void main(String[] args) {
        List<String> filteredValues = EEfilter();
        System.out.println(filteredValues);
    
}
}
