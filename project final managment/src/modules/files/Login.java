package modules.files;

import modules.tools.GlobalFileTools;

public class Login {

    public GlobalFileTools globalFileTools = new GlobalFileTools();

    public boolean loginCheck(String username, String password, String toggle) {
        int index = 0, lineCount = 0;
        boolean state = false;

        //count lines of files in userInformation file
        lineCount = globalFileTools.fileLengthCounter("D:\\project final\\project final managment\\src\\files\\data\\managementAndAdminLogin.txt");

        //add username and password in array
        int correctIndex = 0;
        String[] counter = globalFileTools.fileAllRead("D:\\project final\\project final managment\\src\\files\\data\\managementAndAdminLogin.txt");

        //find correct index which one is equals with data
        //j = j+2 because odd lines are username and even lines are passwords
        for (int j = 0; j < lineCount-1; j = j+3) {
            if (username.equals(counter[j]) && password.equals(counter[j+1]) && toggle.equals(counter[j+2])) {
                correctIndex = j;
            }
        }
        //check data is correct or not
        if (username.equals(counter[correctIndex]) && password.equals(counter[correctIndex+1]) && toggle.equals(counter[correctIndex])){
            state = true;
        }
        //send state and show this data is true or not
        return state;
    }
}
