package controllers.bankingPortal;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class BankingPortal {

    @FXML
    private Text amountText;

    @FXML
    private Text refundText;

    @FXML
    private TextField cardNumberTextField1;

    @FXML
    private TextField cardNumberTextField2;

    @FXML
    private TextField cardNumberTextField3;

    @FXML
    private TextField cardNumberTextField4;

    @FXML
    private TextField CVV2TextFIeld;

    @FXML
    private TextField captchaRandomTextField;

    @FXML
    private TextField captchaTextField;

    @FXML
    private TextField cvvTextField;

    @FXML
    private JFXButton recuqestSMSOTPButton;

    @FXML
    private TextField emailTextField;

    @FXML
    private JFXButton proceedButton;

    @FXML
    private JFXButton cancelButton;

    @FXML
    void cancelAction(ActionEvent event) {

    }

    @FXML
    void proceedAction(ActionEvent event) {

    }

    @FXML
    void requestSMSOTPAction(ActionEvent event) {

    }

}
