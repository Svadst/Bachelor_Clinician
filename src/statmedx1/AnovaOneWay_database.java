/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package statmedx1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.commons.math3.distribution.FDistribution;
import statmedx1.DatabaseTEST;


/**
 *
 * @author sophiahaackvadstrup
 */
public class AnovaOneWay_database {
    public static void main(String[] args) throws SQLException {
            //Step 1: Connection to the database 
     
        
     // String url = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_hst-22-st-5-5401?serverTimezone=UTC";
      //  String user = "hst_hst-22-st-5-5401";
       // String password = "feeshoopasewoothoogi";
//Connection conn = DriverManager.getConnection(url, user, password
        try ( Connection conn = DatabaseTEST.getInstance().getConnection();
             Statement stmt = conn.createStatement()) {

            //Step 2: SQL  statement 
            String query = "SELECT EE, CEILING((@row_number:=@row_number+1)/10.0) AS sample_group FROM TABLE16, (SELECT @row_number:=0) r WHERE EE IS NOT NULL AND EE != 0 ORDER BY sample_group, EE ASC LIMIT 40";
            ResultSet rs = stmt.executeQuery(query);
            
            
            
            // Step 3: Store data in an ArrayList
            ArrayList<Double> dataList = new ArrayList<>();
            while (rs.next()) {
                dataList.add(rs.getDouble("EE"));
            }
            
            // Step 4: Calculate statistical measures
            int n = dataList.size();
            int k = 4; // Number of groups
            int dfBetween = k - 1;
            int dfWithin = n - k;
            double meanTotal = 0;
            double ssBetween = 0;
            double ssWithin = 0;
            
            // Divide data into groups and calculate means
            ArrayList<ArrayList<Double>> groups = new ArrayList<>();
            ArrayList<Double> groupMeans = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                ArrayList<Double> group = new ArrayList<>();
                for (int j = i*(n/k); j < (i+1)*(n/k); j++) {
                    group.add(dataList.get(j));
                    meanTotal += dataList.get(j);
                }
                groups.add(group);
                double mean = group.stream().mapToDouble(d -> d).average().orElse(0);
                groupMeans.add(mean);
            }
            meanTotal /= n;
           
            
            // Calculate sum of squares between groups
            for (double mean : groupMeans) {
                ssBetween += Math.pow(mean - meanTotal, 2) * (n/k);
            }
            
            // Calculate sum of squares within groups
            for (ArrayList<Double> group : groups) {
                double groupMean = groupMeans.get(groups.indexOf(group));
                for (double data : group) {
                    ssWithin += Math.pow(data - groupMean, 2);
                }
            }
            
            // Calculate standard deviation and standard error for each group
            ArrayList<Double> groupSds = new ArrayList<>();
            ArrayList<Double> groupSes = new ArrayList<>();
            for (ArrayList<Double> group : groups) {
                double sd = Math.sqrt(group.stream().mapToDouble(d -> Math.pow(d - groupMeans.get(groups.indexOf(group)), 2)).sum() / (group.size() - 1));
                double se = sd / Math.sqrt(group.size());
                groupSds.add(sd);
                groupSes.add(se);
            }
            
            // Calculate standard deviation and standard error for total 
             // Calculate standard deviation
     
    //    for (ArrayList<Double> group : groups) {     
     //   double sdTotal = Math.sqrt(group.stream().mapToDouble(d -> Math.pow(d - groupMeans.get(groups.indexOf(group)), 2)).sum() / (group.size() - 1));
      //  }
        // Calculate total standard error
       // double seTotal = sdTotal / Math.sqrt(n);
         
            
            
            // Calculate mean square between groups and within groups
            double msBetween = ssBetween / dfBetween;
            double msWithin = ssWithin / dfWithin;
            
           
        
            // Calculate F-value and significance level
           double fValue = msBetween / msWithin;
            FDistribution fDist = new FDistribution(dfBetween, dfWithin);
            double pValue = 1 - fDist.cumulativeProbability(fValue);
           

// Step 5: Output results
            System.out.println("One-Factor ANOVA Test Results:");
            System.out.println("=============================");
            System.out.println("Sample Size: " + n);
            System.out.println("Number of Groups: " + k);
            System.out.println("Degrees of Freedom (Between): " + dfBetween);
            System.out.println("Degrees of Freedom (Within): " + dfWithin);
            System.out.println("Mean (Total): " + meanTotal);
            System.out.println("Mean (Group 1): " + groupMeans.get(0));
            System.out.println("Mean (Group 2): " + groupMeans.get(1));
            System.out.println("Mean (Group 3): " + groupMeans.get(2));
            System.out.println("Mean (Group 4): " + groupMeans.get(3));
            System.out.println("Standard Deviation (Group 1): " + groupSds.get(0));
            System.out.println("Standard Deviation (Group 2): " + groupSds.get(1));
            System.out.println("Standard Deviation (Group 3): " + groupSds.get(2));
            System.out.println("Standard Deviation (Group 4): " + groupSds.get(3));
            System.out.println("Standard Error (Group 1): " + groupSes.get(0));
            System.out.println("Standard Error (Group 2): " + groupSes.get(1));
            System.out.println("Standard Error (Group 3): " + groupSes.get(2));
            System.out.println("Standard Error (Group 4): " + groupSes.get(3));
    //        System.out.println("Standard Deviation (Total): " + sdTotal);
      //      System.out.println("Standard Error (Total): " + seTotal);
            System.out.println("Sum of Squares (Between): " + ssBetween);
            System.out.println("Sum of Squares (Within): " + ssWithin);
            System.out.println("Mean Square (Between): " + msBetween);
            System.out.println("Mean Square (Within): " + msWithin);
            System.out.println("F-Value: " + fValue);
            System.out.println("Significance Level: " + pValue);
            
            // Step 6: Close database connection
            conn.close();
            
        } catch (SQLException ex) {
            System.out.println("Database connection error.");
           // ex.printStackTrace();
        }
    }
}





