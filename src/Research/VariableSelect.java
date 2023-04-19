package Research;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;



public class VariableSelect {
public static Map<String, List<List<Object>>> variableSelector(String hVariable, String hIntervals, Map<String, List<Object>> filterData) {
    Map<String, List<List<Object>>> result = new HashMap<>();
    List<Double> intervals = Arrays.stream(hIntervals.split(";"))
            .map(Double::parseDouble)
            .sorted()
            .collect(Collectors.toList());
    for (String patientId : filterData.keySet()) {
        List<List<Object>> patientIntervals = new ArrayList<>();
        List<Object> patientData = filterData.get(patientId);
        List<Double> ventModeSets = patientData.stream()
                .filter(d -> d instanceof Map)
                .map(d -> ((Map<String, Object>) d).get("VentModeSet"))
                .filter(Objects::nonNull)
                .map(Double.class::cast)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        for (Double ventModeSet : ventModeSets) {
            List<Object> intervalData = patientData.stream()
                    .filter(d -> d instanceof Map)
                    .filter(d -> Objects.equals(((Map<String, Object>) d).get("VentModeSet"), ventModeSet))
                    .collect(Collectors.toList());
            List<List<Object>> subIntervals = new ArrayList<>();
            for (int i = 0; i < intervals.size(); i++) {
                double lowerBound = intervals.get(i);
                double upperBound = i < intervals.size() - 1 ? intervals.get(i + 1) : Double.POSITIVE_INFINITY;
                List<Object> subIntervalData = intervalData.stream()
                        .filter(d -> Objects.equals(((Map<String, Object>) d).get(hVariable), ventModeSet))
                        .filter(d -> lowerBound <= (double) ((Map<String, Object>) d).get("EE") && (double) ((Map<String, Object>) d).get("EE") < upperBound)
                        .collect(Collectors.toList());
                subIntervals.add(subIntervalData);
            }
            patientIntervals.addAll(subIntervals);
        }
        result.put(patientId, patientIntervals);
    }
    return result;
}
}
    
  


    