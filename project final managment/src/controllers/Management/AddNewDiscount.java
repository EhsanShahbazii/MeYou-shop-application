package controllers.Management;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import modules.object.Discount;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;

public class AddNewDiscount {

    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();
    Discount discount = new Discount();

    public void initialize() {

    }


    @FXML
    private TableView<Discount> discountTable;

    @FXML
    private JFXTextField discountNameTextField;

    @FXML
    private JFXComboBox<?> discountAmountComboBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker discountEndDatePicker;

    @FXML
    private JFXButton addDiscountButton;

    @FXML
    private JFXButton exitButton;

    @FXML
    void addDiscountAction(ActionEvent event) {
        String value =discountEndDatePicker.getValue().toString();
        System.out.println(value);
    }

    @FXML
    void discountEndAction(ActionEvent event) {

    }

    @FXML
    void discountStartAction(ActionEvent event) {

    }

    @FXML
    void exitAction(ActionEvent event) {
        globalTools.closeCurrentPage(exitButton, "/pages/managment/addNewDiscountPage.fxml");
    }

}
