package dians.hw.winespotter.pipeAndFilter;

import java.util.*;

public class GroupByCategoryFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        Map<String, String> categoryGroups = new HashMap<String, String>();
        categoryGroups.put("wineries", "Wine production");
        categoryGroups.put("wine bars", "Wine production");
        categoryGroups.put("wine producers", "Wine production");
        categoryGroups.put("wine merchants - wholesale", "Wine production");

        categoryGroups.put("rakija manufacturers", "Alcoholic drinks - manufacturers");

        categoryGroups.put("hotels", "Rental");
        categoryGroups.put("apartments & rooms - hire (rental)", "Rental");

        categoryGroups.put("restaurants - wedding receptions & ceremonies (ballrooms & banquet facilities)", "Restaurants");
        categoryGroups.put("restaurants a - z", "Restaurants");

        categoryGroups.put("fruit - processing", "Product - manufacturing");
        categoryGroups.put("milk & dairy products", "Product - manufacturing");
        categoryGroups.put("feedmills", "Product - manufacturing");
        categoryGroups.put("grain growers", "Product - manufacturing");
        categoryGroups.put("grain & crop brokers", "Product - manufacturing");
        categoryGroups.put("flour", "Product - manufacturing");

        Set<String> res = new LinkedHashSet<>();
        String[] tmp = input.split(",");
        String[] fields = tmp[6].split(";");
        for (String field : fields) {
            extractedMapStringCategory(field, categoryGroups, res);
        }

        String result = "";
        for (String part : res) {
            result += part + ";";
        }
        result = result.substring(0, result.length() - 1);
        tmp[6] = result;

        result = "";
        for (String part : tmp) {
            result += part + ",";
        }

        return result;
    }

    private static void extractedMapStringCategory(String field, Map<String, String> categoryGroups, Set<String> res) {
        if (categoryGroups.containsKey(field)) {
            res.add(categoryGroups.get(field));
        } else {
            field = Character.toUpperCase(field.charAt(0)) + field.substring(1, field.length());
            res.add(field);
        }
    }
}
