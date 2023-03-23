/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package statmedx1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rikke
 */
public class DatabaseTEST {
    
private static DatabaseTEST instance = null;
private static Connection conn;

private DatabaseTEST(){
    String url = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_hst-22-st-5-5401?serverTimezone=UTC";
    String driver = "com.mysql.cj.jdbc.Driver";
    String userName = "hst_hst-22-st-5-5401"; 
    String password = "feeshoopasewoothoogi";
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url,userName, password);
                }

                    catch(ClassNotFoundException cnfErr)
                    {cnfErr.printStackTrace();
                    }
                    catch(SQLException err)
                    {err.printStackTrace();
                    }
}
    public static DatabaseTEST getInstance() {
        if(instance == null)
    return new DatabaseTEST();
        else
    return instance;
}

    public static Connection getConnection() {
     return conn;
}
}  



