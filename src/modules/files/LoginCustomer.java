package modules.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginCustomer {

    public boolean loginCheck(String username, String password) {
        int i = 0, count = 0;
        boolean state = false;

        try {
            //count lines of files in userInformation file
            Scanner scanner1 = new Scanner(new File("D:\\project final\\src\\files\\data\\usersInformation.txt"));
            while (scanner1.hasNextLine()) {
                count++;
                scanner1.nextLine();
            }
            scanner1.close();

            String[] counter = new String[count];
            int k = 0;
            Scanner scanner2 = new Scanner(new File("D:\\project final\\src\\files\\data\\usersInformation.txt"));
            while (scanner2.hasNextLine()) {
                counter[i] = scanner2.nextLine();
                i++;
            }
            scanner2.close();

            for (int j = 0; j < count; j++) {
                if (username.equals(counter[j]) && password.equals(counter[j+1])) {
                    k = j;
                }
            }

            if (username.equals(counter[k]) && password.equals(counter[k+1])){
                state = true;
            }else {
                state = false;
            }

        }catch (FileNotFoundException error) {
            error.printStackTrace();
        }

        return state;
    }
}
