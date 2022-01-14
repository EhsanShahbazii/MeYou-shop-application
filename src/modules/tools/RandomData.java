package modules.tools;

public class RandomData {

    //this method create random number
    public String randomNumberCreator(long min, long max) {
        long randomNumber = (long) Math.floor(Math.random()*(max-min+1)+min);
        return Long.toString(randomNumber);
    }

    //round number by digit
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    //this method create random number
    public String randomNumberCreatorRound(long min, long max, int digit) {
        double randomNumber = round((Math.random()*(max-min+1)+min), digit);
        return Double.toString(randomNumber);
    }

    //this method create captcha logic format (int1 + int2)
    public String captchaData(long min, long max) {
        String number1 = randomNumberCreator(min, max);
        String number2 = randomNumberCreator(min, max);
        return number1 + "+" + number2;
    }

    //this method solve captcha and post it
    public String captchaSolve(String string) {
        String[] st = string.split("\\+");
        int st1 = Integer.parseInt(st[0]);
        int st2 = Integer.parseInt(st[1]);
        int sts = st1+st2;
        return Integer.toString(sts);
    }

    //create codes for products
    public String createCode(String productName) {
        String result = "";
        int decimal = 0;
        for (int i = 0; i < 4; i++) {
            decimal = (int) productName.charAt(i);
            result += Integer.toString(decimal);
        }
        return result;
    }

    //
    public double[] create7RandomNumbers() {
        double[] array = new double[7];
        for (int i = 0; i < 7; i++) {
            array[i] = Double.parseDouble(randomNumberCreator(-5, 15));
        }
        return array;
    }

}
