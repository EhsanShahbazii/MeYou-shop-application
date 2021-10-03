package modules.tools;

public class RandomData {

    //this method create product code from product name
    public String createCode(String productName) {
        String result = "";
        int decimal = 0;
        for (int i = 0; i < 5; i++) {
            decimal = (int) productName.charAt(i);
            result += Integer.toString(decimal);
        }
        return result;
    }
}
