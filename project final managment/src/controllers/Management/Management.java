package controllers.Management;

import com.jfoenix.controls.JFXButton;
import controllers.Login.Login;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modules.charts.LineChartData;
import modules.charts.PieChartData;
import modules.tools.DigitalClock;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Management {

    //variables which are used
    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();
    LineChartData lineChartData = new LineChartData();
    PieChartData pieChartData = new PieChartData();

    public void initialize() {
        getDataFromFile();

        //creating the series
        XYChart.Series series = new XYChart.Series();
        series.setName("NapLog(x) = -10^7ln(x/10^7) + y'log(x^ie)");

        String[] data = lineChartData.lineChartProductData();
        long totalAssets = 0;

        for (int i = 0; i <data.length/2.5; i = i+2) {
            double price = Double.parseDouble(data[i]);
            int real = (int) Math.round(price);
            totalAssets += real*Long.parseLong(data[i+1]);
            series.getData().add(new XYChart.Data(Integer.toString(i+2009) + "/" + Integer.toString(i+1),Integer.parseInt(data[i+1])*real));
        }

        //adding series to the lineChart
        lineChart.getData().add(series);
        
        pieChart.setClockwise(false);
        pieChart.setData(pieChartData.PieChartProductData());

    }

    public void getDataFromFile() {
        //get current admin data from files
//        String[] userDataInformation = globalFileTools.returnSpecificUserInformation(Login.person.getUsername());
        String[] userDataInformation = {"Thomas Shelby", "m"};

        String customerFullName = userDataInformation[0]; //add adminFullName
        String customerUsername = userDataInformation[1]; //add customerUsername

        //get user profile image path
        String userProfileImagePath = globalFileTools.userImageProfilePath(customerUsername);

        //set data in own fields in personal information field
        fullNameTextField.setText(customerFullName);

        //get current date from DateTimeFormatter and LocalDateTime
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();

        DigitalClock digitalClock = new DigitalClock();
        digitalClock.LiveDateSwing(timeTextField);

        //set current date adn show it
        dateTextField.setText(dtf.format(now));

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

    @FXML
    void addNewAdminAction(ActionEvent event) throws IOException  {
        FXMLLoader fxmlLoader1 = new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("/pages/managment/addNewAdmin.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        scene1.setFill(Color.TRANSPARENT);
        Stage stage1 = new Stage();
        stage1.setTitle("add new admin");
        stage1.setScene(scene1);
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.setX(530);
        stage1.setY(120);
        stage1.show();
    }

    @FXML
    void addNewDiscountAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("/pages/managment/addNewDiscountPage.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        scene1.setFill(Color.TRANSPARENT);
        Stage stage1 = new Stage();
        stage1.setTitle("add new discount");
        stage1.setScene(scene1);
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.setX(530);
        stage1.setY(120);
        stage1.show();
    }

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

    @FXML
    void showAllAdminsAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("/pages/managment/showAllAdminPage.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        scene1.setFill(Color.TRANSPARENT);
        Stage stage1 = new Stage();
        stage1.setTitle("show all admins");
        stage1.setScene(scene1);
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.setX(530);
        stage1.setY(120);
        stage1.show();
    }

    @FXML
    void showAllCustomersAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("/pages/managment/showAllCustomerPage.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        scene1.setFill(Color.TRANSPARENT);
        Stage stage1 = new Stage();
        stage1.setTitle("show all customers");
        stage1.setScene(scene1);
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.setX(530);
        stage1.setY(120);
        stage1.show();
    }

    @FXML
    void showAllDocumentAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("/pages/managment/showAllDocumentPage.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        scene1.setFill(Color.TRANSPARENT);
        Stage stage1 = new Stage();
        stage1.setTitle("show all documents");
        stage1.setScene(scene1);
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.setX(530);
        stage1.setY(120);
        stage1.show();
    }

    @FXML
    void showAllProductAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("/pages/managment/showAllProductPage.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        scene1.setFill(Color.TRANSPARENT);
        Stage stage1 = new Stage();
        stage1.setTitle("show all product");
        stage1.setScene(scene1);
        stage1.initStyle(StageStyle.TRANSPARENT);
        stage1.setX(530);
        stage1.setY(120);
        stage1.show();
    }

    @FXML
    void logoutAction(ActionEvent event) throws IOException {
        globalTools.OpenNewPageXY(logoutButton, "/pages/login/LoginPage.fxml", "login", 650, 110);
    }
}
