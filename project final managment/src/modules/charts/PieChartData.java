package modules.charts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import modules.tools.GlobalFileTools;

public class PieChartData {

    GlobalFileTools globalFileTools = new GlobalFileTools();

    //get product data for showing in table current customer format ObservableList
    public ObservableList<PieChart.Data> PieChartProductData() {
        int index = 0;

        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();

        //get count of lines in current file
        int lineCount = globalFileTools.fileLengthCounter("D:\\project final\\src\\files\\data\\ProductInformation.txt");

        //set all data of a current file in array
        String[] counter = globalFileTools.fileAllRead("D:\\project final\\src\\files\\data\\ProductInformation.txt");

        //create array list product data type
        String[] data = new String[lineCount];

        for (int i = 2; i <lineCount; i = i+5) {
            data[index] = counter[i-1];
            index++;
            data[index] = counter[i];
            index++;
        }

        //return format observableArrayList
        for (int i = 0; i < lineCount/2.5; i= i+2) {
            double price = Double.parseDouble(data[i+1]);
            int real = (int) Math.round(price);
            list.addAll(new PieChart.Data(data[i], real));
        }

        return list;
    }
}
