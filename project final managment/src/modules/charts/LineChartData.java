package modules.charts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modules.object.Product;
import modules.tools.GlobalFileTools;

import java.util.ArrayList;

public class LineChartData {

    GlobalFileTools globalFileTools = new GlobalFileTools();

    //get product data for showing in table current customer format ObservableList
    public String[] lineChartProductData() {
        int index = 0;

        //get count of lines in current file
        int lineCount = globalFileTools.fileLengthCounter("D:\\project final\\src\\files\\data\\ProductInformation.txt");

        //set all data of a current file in array
        String[] counter = globalFileTools.fileAllRead("D:\\project final\\src\\files\\data\\ProductInformation.txt");

        //create array list product data type
        String[] data = new String[lineCount];

        for (int i = 3; i <lineCount; i = i+5) {
            data[index] = counter[i-1];
            index++;
            data[index] = counter[i];
            index++;
        }
        //return format observableArrayList
        return data;
    }
}
