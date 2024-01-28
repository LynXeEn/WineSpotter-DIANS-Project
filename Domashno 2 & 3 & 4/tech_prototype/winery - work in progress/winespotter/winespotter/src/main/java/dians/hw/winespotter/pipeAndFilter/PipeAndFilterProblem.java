package dians.hw.winespotter.pipeAndFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PipeAndFilterProblem {

    public static void main(String[] args) throws FileNotFoundException {
        ClassLoader loader = PipeAndFilterProblem.class.getClassLoader();
        Scanner scanner = new Scanner(new File(loader.getResource("final_winery.csv").getFile()));

        Pipe<String> groupedCoursesPipe = new Pipe<String>();
        AddressRefactorFilter addressRefactorFilter = new AddressRefactorFilter();
        WeekendHoursFilter weekendHoursFilter = new WeekendHoursFilter();
        GroupByCategoryFilter groupByCategoryFilter = new GroupByCategoryFilter();


        groupedCoursesPipe.addFilter(addressRefactorFilter);
        groupedCoursesPipe.addFilter(weekendHoursFilter);
        groupedCoursesPipe.addFilter(groupByCategoryFilter);

        Map<String, Integer> wineriesByCity = new HashMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String resPipe1 = groupedCoursesPipe.runFilters(line);

            String[] fields = resPipe1.split(",");
            extracted(wineriesByCity, fields);

            System.out.println(resPipe1);


        }
        System.out.println("");
        System.out.println("NUMBER OF WINERIES PER CITY:");
        for (Map.Entry<String, Integer> num : wineriesByCity.entrySet()) {
            System.out.println(num.getKey() + " -> " + num.getValue());
        }

    }

    private static void extracted(Map<String, Integer> wineriesByCity, String[] fields) {
        if (wineriesByCity.containsKey(fields[2])) {
            wineriesByCity.put(fields[2], wineriesByCity.get(fields[2]) + 1);
        } else {
            wineriesByCity.put(fields[2], 1);
        }
    }

}

