package modules.files;

import modules.tools.GlobalFileTools;

import java.io.RandomAccessFile;

public class SigninAdmin {
    public GlobalFileTools globalFileTools = new GlobalFileTools();

    public boolean checkSameUserOrNot(String username) {
        int index = 0, lineCount = 0;
        boolean state = false;

        //count lines of files in userInformation file
        lineCount = globalFileTools.fileLengthCounter("D:\\project final\\project final managment\\src\\files\\data\\adminProfiles.txt");

        //add username and password in array
        int correctIndex = 0;
        String[] counter = globalFileTools.fileAllRead("D:\\project final\\project final managment\\src\\files\\data\\adminProfiles.txt");

        //find correct index which one is equals with data
        //j = j+2 because odd lines are username and even lines are passwords
        for (int j = 0; j < lineCount-1; j = j+2) {
            if (username.equals(counter[j])) {
                correctIndex = j;
            }
        }
        //check data is correct or not
        if (username.equals(counter[correctIndex])){
            state = true;
        }

        //send state and show this data is true or not
        return state;
    }

    //add new customer information in userInformation.txt file
    public void signinNewCustomer(String fullName, String username, String password, String email, String phoneNumber, String address) {
        try {
            RandomAccessFile Library = new RandomAccessFile("D:\\project final\\project final managment\\src\\files\\data\\adminProfiles.txt", "rw");
            Library.seek(Library.length());
            //template is this : fullName, username, password, email, phoneNumber, address
            Library.writeBytes(fullName + "\n" + username + "\n" + password + "\n" + email + "\n" + phoneNumber + "\n" + address + "\n");
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }
}
