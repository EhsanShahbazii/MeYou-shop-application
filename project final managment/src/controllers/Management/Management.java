package controllers.Management;

import com.jfoenix.controls.JFXButton;
import controllers.Login.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import modules.charts.LineChartData;
import modules.charts.PieChartData;
import modules.tools.DigitalTime;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Management {

    //variables which are used
    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();
    LineChartData lineChartData = new LineChartData();
    PieChartData pieChartData = new PieChartData();
    DigitalTime digitalTime = new DigitalTime();

    public void initialize() {

        //get management data and set it in fields
        getDataFromFile();

        //creating the series
        XYChart.Series series = new XYChart.Series();
        //set name for series
        series.setName("NapLog(x) = -10^7ln(x/10^7) + y'log(x^ie)");

        //get data from files
        String[] data = lineChartData.lineChartProductData();
        long totalAssets = 0;

        //setting data into line chart
        for (int i = 0; i <data.length/2.5; i = i+2) {
            //convert to needed format
            double price = Double.parseDouble(data[i]);
            int real = (int) Math.round(price);
            totalAssets += real*Long.parseLong(data[i+1]);
            //add data into series
            series.getData().add(new XYChart.Data(Integer.toString(i+2009) + "/" + Integer.toString(i+1),Integer.parseInt(data[i+1])*real));
        }

        //adding series to the lineChart
        lineChart.getData().add(series);

        //add some attribute for inventory pie graph
        pieChart.setClockwise(false);
        pieChart.setData(pieChartData.PieChartProductData());

        //set live time and date data in fields
        digitalTime.LiveTimeDate(timeTextField, dateTextField);
    }

    /*get management fullName, username and some other data
     like user image path and set it in imageview*/
    public void getDataFromFile() {
        //get current management data from files
//      String[] userDataInformation = globalFileTools.returnSpecificUserInformation(Login.person.getUsername());
        String[] userDataInformation = {"Thomas Shelby", "m"};

        String managementFullName = userDataInformation[0]; //add adminFullName
        String managementUsername = userDataInformation[1]; //add customerUsername

        //get user profile image path
        String userProfileImagePath = globalFileTools.userImageProfilePath(managementUsername);

        //set data in own fields in personal information field
        fullNameTextField.setText(managementFullName);

        //set user profile image
        File files = new File(userProfileImagePath);
        Image image = new Image(files.toURI().toString());
        //set image format in imageview
        profileImageView.setImage(image);
    }

    @FXML
    private JFXButton logoutButton;

    @FXML
    private JFXButton showAllCustomersButton;

    @FXML
    private JFXButton showAllAdminsButton;

    @FXML
    private JFXButton showAllDocumentButton;

    @FXML
    private JFXButton addNewDiscountButton;

    @FXML
    private JFXButton addNewAdminButton;

    @FXML
    private JFXButton showAllProductButton;

    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private PieChart pieChart;

    @FXML
    private Button changeImageButton;

    @FXML
    private ImageView profileImageView;

    @FXML
    private Text fullNameTextField;

    @FXML
    private Text timeTextField;

    @FXML
    private Text dateTextField;

    //this method open a page and adding new admin in file
    @FXML
    void addNewAdminAction(ActionEvent event) throws IOException  {
        globalTools.openNewPageWithoutCloseCurrentPage("/pages/managment/addNewAdmin.fxml", "add new admin");
    }

    //this method open a page and adding new discount in file
    @FXML
    void addNewDiscountAction(ActionEvent event) throws IOException {
        globalTools.openNewPageWithoutCloseCurrentPage("/pages/managment/addNewDiscountPage.fxml", "add new discount");
    }

    //this method changing profile image
    @FXML
    void changeProfileImageAction(ActionEvent event) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser(); //create file chooser
        File file = fileChooser.showOpenDialog(null); //get file(pic) path

        if (file != null){
            String path;
            path = file.getAbsolutePath(); //take file path which is choose
            File files = new File(path); //convert path to file format
            //update new profile image path current customer
            globalFileTools.updateUserProfileImage(Login.person.getUsername(), path);
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please Select Picture"); //show Error alert
        }
    }

    //this method open a page and show all admin in file
    @FXML
    void showAllAdminsAction(ActionEvent event) throws IOException {
        globalTools.openNewPageWithoutCloseCurrentPage("/pages/managment/showAllAdminPage.fxml", "show all admins");
    }

    //this method open a page and show all customer in file
    @FXML
    void showAllCustomersAction(ActionEvent event) throws IOException {
        globalTools.openNewPageWithoutCloseCurrentPage("/pages/managment/showAllCustomerPage.fxml", "show all customers");
    }

    //this method open a page and show all document in file
    @FXML
    void showAllDocumentAction(ActionEvent event) throws IOException {
        globalTools.openNewPageWithoutCloseCurrentPage("/pages/managment/showAllDocumentPage.fxml", "show all documents");
    }

    //this method open a page and show all product in file
    @FXML
    void showAllProductAction(ActionEvent event) throws IOException {
        globalTools.openNewPageWithoutCloseCurrentPage("/pages/managment/showAllProductPage.fxml", "show all product");
    }

    //this method close current page and open login page
    @FXML
    void logoutAction(ActionEvent event) throws IOException {
        globalTools.OpenNewPageXY(logoutButton, "/pages/login/LoginPage.fxml", "login", 650, 110);
    }
}
