package modules.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SigninCustomer {

    public boolean checkSameUserOrNot(String username) {
        int index = 0, lineCount = 0;
        boolean state = false;

        try {
            //count lines of files in userInformation file
            Scanner scanner1 = new Scanner(new File("D:\\project final\\src\\files\\data\\usernameAndPassword.txt"));
            while (scanner1.hasNextLine()) {
                lineCount++;
                scanner1.nextLine();
            }
            scanner1.close();

            //add username and password in array
            String[] counter = new String[lineCount];
            int correctIndex = 0;
            Scanner scanner2 = new Scanner(new File("D:\\project final\\src\\files\\data\\usernameAndPassword.txt"));
            while (scanner2.hasNextLine()) {
                counter[index] = scanner2.nextLine();
                index++;
            }
            scanner2.close();

            //find correct index which one is equals with data
            //j = j+2 because odd lines are username and even lines are passwords
            for (int j = 0; j < lineCount-1; j = j+2) {
                if (username.equals(counter[j])) {
                    correctIndex = j;
                }
            }
            //check data is correct or not
            if (username.equals(counter[correctIndex]) ){
                state = true;
            }

        }catch (FileNotFoundException error) {
            error.printStackTrace();
        }

        //send state and show this data is true or not
        return state;
    }
}
