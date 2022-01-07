package modules.files;

import modules.tools.GlobalFileTools;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class SelectAndBuyProduct {

    GlobalFileTools globalFileTools = new GlobalFileTools();

    //update count of product in card of current customer
    public void updateProductToCard(String username, String productName, String productCount) throws FileNotFoundException {
        boolean flag = false;
        //get count of lines in current file
        int lineCount = globalFileTools.fileLengthCounter("D:\\project final\\src\\files\\data\\cardInformation.txt");

        //set all data of a current file in array
        String[] counter = globalFileTools.fileAllRead("D:\\project final\\src\\files\\data\\cardInformation.txt");

        for (int i = 0; i <lineCount; i++) {
            if (counter[i].equals(username) && counter[i+1].equals(productName)) {
                int countBefore = Integer.parseInt(counter[i+2]);
                int newCount = Integer.parseInt(productCount);
                String result = Integer.toString(countBefore+newCount);
                counter[i+2] = result;
                flag = true;
            }
        }

        if (!flag) {
            addProductToCard(username, productName, productCount);
        }else {
            //clear current file but file is safe
            PrintWriter writer = new PrintWriter("D:\\project final\\src\\files\\data\\cardInformation.txt");
            //set all data with empty string
            writer.print("");
            writer.close();

            try {
                //write data in file by random access file
                RandomAccessFile Library = new RandomAccessFile("D:\\project final\\src\\files\\data\\cardInformation.txt", "rw");
                Library.seek(Library.length());
                for (int i=0; i < lineCount; i++){
                    //write data format (data) \n
                    Library.writeBytes(counter[i] + "\n");
                }
            }catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
    }

    //add new product in card of current customer
    public void addProductToCard(String username, String productName, String productCount) throws FileNotFoundException {
        //get count of lines in current file
        int lineCount = globalFileTools.fileLengthCounter("D:\\project final\\src\\files\\data\\cardInformation.txt");

        //set all data of a current file in array
        String[] counter = globalFileTools.fileAllRead("D:\\project final\\src\\files\\data\\cardInformation.txt");

        //clear current file but file is safe
        PrintWriter writer = new PrintWriter("D:\\project final\\src\\files\\data\\cardInformation.txt");
        //set all data with empty string
        writer.print("");
        writer.close();

        try {
            //write data in file by random access file
            RandomAccessFile Library = new RandomAccessFile("D:\\project final\\src\\files\\data\\cardInformation.txt", "rw");
            Library.seek(Library.length());
            for (int i=0; i < lineCount; i++){
                //write data format (data) \n
                Library.writeBytes(counter[i] + "\n");
            }
            Library.writeBytes(username + "\n" + productName + "\n" + productCount + "\n");
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }
}
