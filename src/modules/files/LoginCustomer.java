package modules.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginCustomer {

    private  Scanner scanner1;
    private  Scanner scanner2;

    public boolean loginCheck(String username, String password) {
        int i = 0, count = 0;

        try {
            //count lines of files in userInformation file
            scanner1 = new Scanner(new File("D:\\project final\\src\\files\\data\\usersInformation.txt"));
            while (scanner1.hasNextLine()) {
                count++;
                scanner1.nextLine();
            }
            scanner1.close();

        }catch (FileNotFoundException error) {
            error.printStackTrace();
        }
    }
}
