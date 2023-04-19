/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
    
private static DatabaseConnection instance = null;
private static Connection conn;

private DatabaseConnection(){
    String url = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_hst-23-st-6-6401?serverTimezone=UTC";
    String driver = "com.mysql.cj.jdbc.Driver";
    String userName = "hst_hst-23-st-6-6401"; 
    String password = "esohjaingohshaefeipe";
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
    public static DatabaseConnection getInstance() {
        if(instance == null)
    return new DatabaseConnection();
        else
    return instance;
}

    public static Connection getConnection() {
     return conn;
}
    
    
}  

