package modules.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GlobalFileTools {

    //this method count number of lines in files
    public int fileLengthCounter(String path) {
        int lineCount = 0;
        try {
            //count lines of files in userInformation file
            Scanner scanner1 = new Scanner(new File(path));
            while (scanner1.hasNextLine()) {
                lineCount++;
                scanner1.nextLine();
            }
            scanner1.close();
        }catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return lineCount;
    }

    //this method get all data of any files in array list
    public String[] fileAllRead(String path) {
        int index = 0;
        //count lines of files in userInformation file
        int lineCount = fileLengthCounter(path);
        String[] counter = new String[lineCount];
        try {
            int correctIndex = 0;
            Scanner scanner2 = new Scanner(new File(path));
            while (scanner2.hasNextLine()) {
                counter[index] = scanner2.nextLine();
                index++;
            }
            scanner2.close();
        }catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return counter;
    }

    //return specific user information
    public String[] returnSpecificUserInformation(String username) {
        int usernameIndex = 0;
        //array length is 5 because we have 5 lines of data for each customer
        String[] data = new String[5];
        try {
            Scanner scanner = new Scanner(new File("D:\\project final\\src\\files\\data\\userInformation.txt"));
            while (scanner.hasNextLine()) {
                String user = scanner.nextLine();
                usernameIndex++;
                //try to found username and then return information of current customer
                if (username.equals(user)) {
                    String[] files = fileAllRead("D:\\project final\\src\\files\\data\\userInformation.txt");
                    data[0] = files[usernameIndex-2]; //return fullName
                    data[1] = files[usernameIndex-1]; //return username
                    data[2] = files[usernameIndex+1]; //return email
                    data[3] = files[usernameIndex+2]; //return phone number
                    data[4] = files[usernameIndex+3]; //return address
                }
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        return data;
    }
}
