package modules.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginCustomer {

    public boolean loginCheck(String username, String password) {
        int index = 0, lineCount = 0, correctIndex = 0;
        boolean state = false;

        try {
            //count lines of files in userInformation file
            Scanner scanner1 = new Scanner(new File("D:\\project final\\src\\files\\data\\usersInformation.txt"));
            while (scanner1.hasNextLine()) {
                lineCount++;
                scanner1.nextLine();
            }
            scanner1.close();

            //add username and password in array
            String[] counter = new String[lineCount];
            Scanner scanner2 = new Scanner(new File("D:\\project final\\src\\files\\data\\usersInformation.txt"));
            while (scanner2.hasNextLine()) {
                counter[index] = scanner2.nextLine();
                index++;
            }
            scanner2.close();

            //find correct index which one is equals with data
            for (int j = 0; j < lineCount; j++) {
                if (username.equals(counter[j]) && password.equals(counter[j+1])) {
                    correctIndex = j;
                }
            }
            //check data is correct or not
            if (username.equals(counter[correctIndex]) && password.equals(counter[correctIndex+1])){
                state = true;
            }

        }catch (FileNotFoundException error) {
            error.printStackTrace();
        }

        //send state and show this data is true or not
        return state;
    }
}
