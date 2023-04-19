
package Research;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class VisualiseData {
    private List<Patient> patients;

    public VisualiseData(List<Patient> patients) {
        this.patients = patients;
    }

    public void plotEEIntervals() {
        for (Patient patient : patients) {
            List<EEInterval> intervals = patient.getEEIntervals();
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (EEInterval interval : intervals) {
                dataset.addValue(interval.getMeanEE(), "EE", interval.getName());
            }
            JFreeChart chart = ChartFactory.createBarChart(
                patient.getUnitID() + " - " + patient.getSex() + " - " + patient.getAge() + " - " + patient.getWeight() + " - " + patient.getAetiology(),
                "Interval Name",
                "Mean EE",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
            );
            ChartFrame frame = new ChartFrame(patient.getUnitID(), chart);
            frame.pack();
            frame.setVisible(true);
        }
    }

    public void plotPatientData() {
        Map<String, DefaultCategoryDataset> datasets = new HashMap<>();
        for (Patient patient : patients) {
            if (!datasets.containsKey("Weight")) {
                datasets.put("Weight", new DefaultCategoryDataset());
            }
            datasets.get("Weight").addValue(patient.getWeight(), "Weight", patient.getUnitID());

            if (!datasets.containsKey("Age")) {
                datasets.put("Age", new DefaultCategoryDataset());
            }
            datasets.get("Age").addValue(patient.getAge(), "Age", patient.getUnitID());

            if (!datasets.containsKey("Sex")) {
                datasets.put("Sex", new DefaultCategoryDataset());
            }
            datasets.get("Sex").addValue(patient.getSex().equals("F") ? 1 : 0, "Female", patient.getUnitID());
            datasets.get("Sex").addValue(patient.getSex().equals("M") ? 1 : 0, "Male", patient.getUnitID());

            if (!datasets.containsKey("Aetiology")) {
                datasets.put("Aetiology", new DefaultCategoryDataset());
            }
            datasets.get("Aetiology").addValue(1, patient.getAetiology(), patient.getUnitID());
        }

        for (String category : datasets.keySet()) {
            JFreeChart chart = ChartFactory.createBarChart(
                category,
                "Unit ID",
                "",
                datasets.get(category),
                PlotOrientation.VERTICAL,
                false,
                true,
                false
            );
            ChartFrame frame = new ChartFrame(category, chart);
            frame.pack();
            frame.setVisible(true);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
