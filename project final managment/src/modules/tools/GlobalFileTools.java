package modules.tools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modules.object.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class GlobalFileTools {

    RandomData randomData = new RandomData();

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
            //push all data in array
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
            Scanner scanner = new Scanner(new File("D:\\project final\\project final managment\\src\\files\\data\\adminProfiles.txt"));
            while (scanner.hasNextLine()) {
                String user = scanner.nextLine();
                usernameIndex++;
                //try to found username and then return information of current customer
                if (username.equals(user)) {
                    String[] files = fileAllRead("D:\\project final\\project final managment\\src\\files\\data\\adminProfiles.txt");
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

    //return current user profile image path for set in image view in profile
    public String userImageProfilePath(String username) {
        int usernameIndex = 0;

        //this is default image path for show in image view
        String imagePath = "D:\\project final\\src\\files\\image\\profile image\\Man-16-icon.png";
        try {
            Scanner scanner = new Scanner(new File("D:\\project final\\project final managment\\src\\files\\data\\userProfileImages.txt"));
            while (scanner.hasNextLine()) {
                String user = scanner.nextLine();
                usernameIndex++;
                //try to found username and then return wallet balance current customer
                if (username.equals(user)) {
                    String[] files = fileAllRead("D:\\project final\\project final managment\\src\\files\\data\\userProfileImages.txt");
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
        //get count of lines in current file
        int lineCount = fileLengthCounter("D:\\project final\\project final managment\\src\\files\\data\\userProfileImages.txt");

        //set all data of a current file in array
        String[] counter = fileAllRead("D:\\project final\\project final managment\\src\\files\\data\\userProfileImages.txt");

        for (int i = 0; i <lineCount; i++) {
            if (counter[i].equals(username)) {
                counter[i+1] = imagePath;
                break;
            }
        }
        //clear current file but file is safe
        PrintWriter writer = new PrintWriter("D:\\project final\\project final managment\\src\\files\\data\\userProfileImages.txt");
        //set all data with empty string
        writer.print("");
        writer.close();

        try {
            //write data in file by random access file
            RandomAccessFile Library = new RandomAccessFile("D:\\project final\\project final managment\\src\\files\\data\\userProfileImages.txt", "rw");
            Library.seek(Library.length());
            for (int i=0; i < lineCount; i++){
                //write data format (data) \n
                Library.writeBytes(counter[i] + "\n");
            }
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }

    //add new product information in ProductInformation.txt file
    public void addNewProduct(String productName, String productAuthor, String productPrice, String productCount, String productImage) {
        try {
            RandomAccessFile Library = new RandomAccessFile("D:\\project final\\src\\files\\data\\ProductInformation.txt", "rw");
            Library.seek(Library.length());
            //template is this : productName, productAuthor, productPrice, productCount, productImage
            Library.writeBytes(productName + "\n" + productAuthor + "\n" + productPrice + "\n" + productCount + "\n" + productImage + "\n");
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }

    public boolean checkProductAvailable(String productName) {
        boolean state = false;
        //get count of lines in current file
        int lineCount = fileLengthCounter("D:\\project final\\src\\files\\data\\ProductInformation.txt");

        //set all data of a current file in array
        String[] counter = fileAllRead("D:\\project final\\src\\files\\data\\ProductInformation.txt");

        for (int i = 0; i <lineCount; i++) {
            if (counter[i].equals(productName)) {
                state = true;
                break;
            }
        }
        return state;
    }

    public void removeProduct(String productName) throws FileNotFoundException {
        //get count of lines in current file
        int lineCount = fileLengthCounter("D:\\project final\\src\\files\\data\\ProductInformation.txt");

        //set all data of a current file in array
        String[] counter = fileAllRead("D:\\project final\\src\\files\\data\\ProductInformation.txt");

        //clear current file but file is safe
        PrintWriter writer = new PrintWriter("D:\\project final\\src\\files\\data\\ProductInformation.txt");
        //set all data with empty string
        writer.print("");
        writer.close();

        try {
            //write data in file by random access file
            RandomAccessFile Library = new RandomAccessFile("D:\\project final\\src\\files\\data\\ProductInformation.txt", "rw");
            Library.seek(Library.length());
            for (int i=0; i < lineCount; i++){
                if (productName.equals(counter[i])) {
                    i += 4;
                }else {
                    //write data format (data) \n
                    Library.writeBytes(counter[i] + "\n");
                }
            }
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }

    //get product data for showing in table current customer format ObservableList
    public ObservableList<Product> tableData() {
        //get count of lines in current file
        int lineCount = fileLengthCounter("D:\\project final\\src\\files\\data\\ProductInformation.txt");

        //set all data of a current file in array
        String[] counter = fileAllRead("D:\\project final\\src\\files\\data\\ProductInformation.txt");

        //create array list product data type
        ArrayList<Product> arrayList = new ArrayList<>();
        for (int i = 0; i <lineCount; i++) {
            if (counter[i].equals(username)) {
                //set this data in product  productName, productCount, productPrice, productCode
                Product product = new Product(counter[i+1], counter[i+2], counter[i+3], randomData.createCode(counter[i+1]));
                arrayList.add(product);
            }
        }
        //return format observableArrayList
        return FXCollections.observableArrayList(arrayList);
    }
}
