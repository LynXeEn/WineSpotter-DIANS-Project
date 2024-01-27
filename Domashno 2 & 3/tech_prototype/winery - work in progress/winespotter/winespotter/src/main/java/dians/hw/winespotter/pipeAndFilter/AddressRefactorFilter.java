package dians.hw.winespotter.pipeAndFilter;

public class AddressRefactorFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        String[] parts = input.split(",");
        String address = parts[1];

        String[] addParts = address.split("\\s+");
        addingPartsForAdressFilter(addParts);
        String temp = "";
        for (String part : addParts) {
            temp += part + " ";
        }
        temp = temp.substring(0, temp.length() - 1);
        parts[1] = temp;

        String result = "";
        for (String part : parts) {
            result += part + ",";
        }


        return result;

    }

    private static void addingPartsForAdressFilter(String[] addParts) {
        if (addParts.length > 1) {
            if (!(addParts[0].startsWith("Avtopat"))) {
                if (!(addParts[0].startsWith("ul.") || addParts[0].startsWith("bul.") || addParts[0].startsWith("s."))) {
                    String temp = "ul.";
                    temp += addParts[0];
                    addParts[0] = temp;
                }

                if (Character.isDigit(addParts[addParts.length - 1].charAt(0))) {
                    String temp = "br.";
                    temp += addParts[addParts.length - 1];
                    addParts[addParts.length - 1] = temp;
                }
            }
        }
    }
}
