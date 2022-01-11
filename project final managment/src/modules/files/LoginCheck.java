package modules.files;

import modules.tools.GlobalFileTools;

public class LoginCheck {

    //variables which are used
    public GlobalFileTools globalFileTools = new GlobalFileTools();

    //this method check it username and password and toggle is correct or not
    public boolean loginCheck(String username, String password, String toggle) {
        int index = 0, lineCount = 0;
        boolean state = false; //set state

        //count lines of files in userInformation file
        lineCount = globalFileTools.fileLengthCounter("D:\\project final\\project final managment\\src\\files\\data\\managementAndAdminLogin.txt");

        //add username and password in array
        int correctIndex = 0;
        String[] counter = globalFileTools.fileAllRead("D:\\project final\\project final managment\\src\\files\\data\\managementAndAdminLogin.txt");

        /* find correct index which one is equals with data
          j = j+2 because odd lines are username and even lines are passwords */
        for (int j = 0; j < lineCount-1; j = j+3) {
            if (username.equals(counter[j]) && password.equals(counter[j+1]) && toggle.equals(counter[j+2])) {
                state = true;
            }
        }
        //send state and show this data is true or not
        return state;
    }
}
