package controllers.Management;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class AddNewDiscount {

    @FXML
    private TableView<?> discountTable;

    @FXML
    private JFXTextField discountNameTextField;

    @FXML
    private JFXComboBox<?> discountAmountComboBox;

    @FXML
    private JFXDatePicker startDatePicker;

    @FXML
    private JFXDatePicker discountEndDatePicker;

    @FXML
    private JFXButton addDiscountButton;

    @FXML
    private JFXButton exitButton;

    @FXML
    void addDiscountAction(ActionEvent event) {

    }

    @FXML
    void discountEndAction(ActionEvent event) {

    }

    @FXML
    void discountStartAction(ActionEvent event) {

    }

    @FXML
    void exitAction(ActionEvent event) {

    }

}
