package dians.hw.winespotter.pipeAndFilter;

import java.util.ArrayList;
import java.util.List;

public class WeekendHoursFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        String[] parts = input.split(",");
        List<String> partsInput = new ArrayList<>();

        for (String part : parts) {
            partsInput.add(part);
        }

        String workHours = parts[4];
        String[] workParts = workHours.split(";");

        extracted(workParts, partsInput);
        String result = "";
        for (String part : partsInput) {
            result += part + ",";
        }
        return result;
    }

    private static void extracted(String[] workParts, List<String> partsInput) {
        if (workParts[0].equals("Working hours")) {
            partsInput.set(4, "Week Hours");
            partsInput.add(5, "Weekend Hours");
        } else if (workParts.length > 1) {
            partsInput.add(5, workParts[1]);
            partsInput.set(4, workParts[0]);

        } else {
            if (workParts[0].contains("Sun")) {
                String temp = workParts[0];
                String[] tempParts = temp.split("\\s+");
                tempParts[0] = "Sat";

                String result = "";
                for (String part : tempParts) {
                    result += part + " ";
                }
                result = result.substring(0, result.length() - 1);
                partsInput.add(5, result);

                tempParts = temp.split("\\s+");
                tempParts[2] = "Fri";

                result = "";
                for (String part : tempParts) {
                    result += part + " ";
                }
                result = result.substring(0, result.length() - 1);
                partsInput.set(4, result);

            } else if (workParts[0].contains("Sat")) {
                String temp = workParts[0];
                String[] tempParts = temp.split("\\s+");
                tempParts[2] = "Fri";

                String result = "";
                for (String part : tempParts) {
                    result += part + " ";
                }
                result = result.substring(0, result.length() - 1);
                partsInput.set(4, result);

                result = temp.substring(6, temp.length());
                partsInput.add(5, result);

            } else {
                partsInput.add(5, "No weekend hours available");
            }

        }
    }
}

