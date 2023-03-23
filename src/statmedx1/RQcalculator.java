/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package statmedx1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import statmedx1.Filter;

/**
 *
 * @author signekristiansen
 */
public class RQcalculator {
public void createNewColumn() {
    // Create a new Filter object to establish a database connection
    Filter filter = new Filter();

    try (Connection connection = filter.getConnection()) {
        // Create a new column named RQ in the database
        String sql = "ALTER TABLE tableName ADD COLUMN RQ FLOAT";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        }

        // Divide the VCO2 column with the VO2 column and insert the result into the RQ column
        sql = "UPDATE TABLE16 SET RQ = VCO2 / VO2";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
    
    
}
