package modules.files;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modules.objects.Product;
import modules.tools.GlobalFileTools;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class SelectAndBuyProduct {

    GlobalFileTools globalFileTools = new GlobalFileTools();

    //update count of product in card of current customer
    public void updateProductToCard(String username, String productName, String productCount, String productPrice) throws FileNotFoundException {
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
                int priceBefore = Integer.parseInt(counter[i+3]);
                int newPrice = Integer.parseInt(productPrice);
                String result1 = Integer.toString(priceBefore+newPrice);
                counter[i+3] = result1;
                flag = true;
            }
        }

        if (!flag) {
            addProductToCard(username, productName, productCount, productPrice);
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
    public void addProductToCard(String username, String productName, String productCount, String productPrice) throws FileNotFoundException {
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
            Library.writeBytes(username + "\n" + productName + "\n" + productCount + "\n" + productPrice);
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }


    public ObservableList<Product> tableData(String username) {
        //get count of lines in current file
        int lineCount = globalFileTools.fileLengthCounter("D:\\project final\\src\\files\\data\\cardInformation.txt");

        //set all data of a current file in array
        String[] counter = globalFileTools.fileAllRead("D:\\project final\\src\\files\\data\\cardInformation.txt");

        ArrayList<Product> arrayList = new ArrayList<>();
        for (int i = 0; i <lineCount; i++) {
            if (counter[i].equals(username)) {
                Product product = new Product(counter[i+1], counter[i+2], counter[i+3], "123");
                arrayList.add(product);
            }
        }
        ObservableList<Product> order = FXCollections.observableArrayList(arrayList);
        return order;
    }
}
