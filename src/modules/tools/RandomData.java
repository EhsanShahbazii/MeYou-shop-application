package modules.tools;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Arrays;

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

    public String captchaSolve(String string) {
        String[] st = string.split("\\+");
        int st1 = Integer.parseInt(st[0]);
        int st2 = Integer.parseInt(st[1]);
        int sts = st1+st2;
        return Integer.toString(sts);
    }

}
