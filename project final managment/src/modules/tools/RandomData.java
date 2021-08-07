package modules.tools;

public class RandomData {

    public String createCode(String productName) {
        String result = "";
        int decimal = 0;
        for (int i = 0; i < 4; i++) {
            decimal = (int) productName.charAt(i);
            result += Integer.toString(decimal);
        }
        return result;
    }
}
