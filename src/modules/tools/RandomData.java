package modules.tools;

public class RandomData {

    public String randomNumberCreator(long min, long max) {
        long randomNumber = (long) Math.floor(Math.random()*(max-min+1)+min);
        String result = Long.toString(randomNumber);
        return result;
    }

    public String captchaData(long min, long max) {
        String number1 = randomNumberCreator(min, max);
        String number2 = randomNumberCreator(min, max);
        String result = number1 + "+" + number2;
        return result;
    }
}
