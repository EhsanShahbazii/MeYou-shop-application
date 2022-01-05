package modules.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
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

    //return current customer wallet balance
    public String returnWalletBalance(String username) {
        int usernameIndex = 0;
        String walletBalance = "0";
        try {
            Scanner scanner = new Scanner(new File("D:\\project final\\src\\files\\data\\userWalletBalance.txt"));
            while (scanner.hasNextLine()) {
                String user = scanner.nextLine();
                usernameIndex++;
                //try to found username and then return wallet balance current customer
                if (user.equals(username)) {
                    String[] files = fileAllRead("D:\\project final\\src\\files\\data\\userWalletBalance.txt");
                    walletBalance = files[usernameIndex];
                }
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        return walletBalance;
    }

    //return current user profile image path for set in image view in profile
    public String userImageProfilePath(String username) {
        int usernameIndex = 0;
        //this is default image path for show in image view
        String imagePath = "D:\\project final\\src\\files\\image\\profile image\\Man-16-icon.png";
        try {
            Scanner scanner = new Scanner(new File("D:\\project final\\src\\files\\data\\userProfileImage.txt"));
            while (scanner.hasNextLine()) {
                String user = scanner.nextLine();
                usernameIndex++;
                //try to found username and then return wallet balance current customer
                if (username.equals(user)) {
                    String[] files = fileAllRead("D:\\project final\\src\\files\\data\\userProfileImage.txt");
                    imagePath = files[usernameIndex];
                }
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        return imagePath;
    }

    //update image path in file with current information
    public void updateUserProfileImage(String username, String imagePath) throws FileNotFoundException {
        int lineCount = fileLengthCounter("D:\\project final\\src\\files\\data\\userProfileImage.txt");
        String[] counter = fileAllRead("D:\\project final\\src\\files\\data\\userProfileImage.txt");

        for (int i = 0; i <lineCount; i++) {
            if (counter[i].equals(username)) {
                counter[i+1] = imagePath;
                break;
            }
        }
        PrintWriter writer = new PrintWriter("D:\\project final\\src\\files\\data\\userProfileImage.txt");
        writer.print("");
        writer.close();

        try {
            RandomAccessFile Library = new RandomAccessFile("D:\\project final\\src\\files\\data\\userProfileImage.txt", "rw");
            Library.seek(Library.length());
            for (int i=0; i < lineCount; i++){
                Library.writeBytes(counter[i] + "\n");
            }
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }

    //set default image path for new customer when sign in
    public void addNewUserProfileImage(String username) throws FileNotFoundException {
        int lineCount = fileLengthCounter("D:\\project final\\src\\files\\data\\userProfileImage.txt");
        String[] counter;
        counter = fileAllRead("D:\\project final\\src\\files\\data\\userProfileImage.txt");

        PrintWriter writer = new PrintWriter("D:\\project final\\src\\files\\data\\userProfileImage.txt");
        writer.print("");
        writer.close();

        try {
            RandomAccessFile Library = new RandomAccessFile("D:\\project final\\src\\files\\data\\userProfileImage.txt", "rw");
            Library.seek(Library.length());
            for (int i=0; i < lineCount; i++){
                Library.writeBytes(counter[i] + "\n");
            }
            Library.writeBytes(username + "\n");
            Library.writeBytes("D:\\project final\\src\\files\\image\\profile image\\Man-16-icon.png"+ "\n");
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }
}
