package controllers.bankingPortal;

import com.jfoenix.controls.JFXButton;
import controllers.customer.MainPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import modules.tools.GlobalTools;
import modules.tools.RandomData;

public class BankingPortal {

    GlobalTools globalTools = new GlobalTools();
    RandomData randomData = new RandomData();

    public void initialize() {
        globalTools.moveToNextFieldByLimited(cardNumberTextField1, cardNumberTextField2, 4);
        globalTools.moveToNextFieldByLimited(cardNumberTextField2, cardNumberTextField3, 4);
        globalTools.moveToNextFieldByLimited(cardNumberTextField3, cardNumberTextField4, 4);
        globalTools.moveToNextFieldByLimited(cardNumberTextField4, CVV2TextFIeld, 4);

        globalTools.LimitedTextField(CVV2TextFIeld, 4);
        globalTools.LimitedTextField(captchaTextField, 4);
        globalTools.LimitedTextField(cvvTextField, 7);
        globalTools.LimitedTextField(emailTextField, 32);

        amountText.setText(MainPage.chargeAmount);
        refundText.setText(MainPage.refundMethod);
        captchaRandomTextField.setText(randomData.captchaData(1, 98));
    }

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
    private Button nextCaptchaButton;

    @FXML
    private ImageView captchaImageView;

    @FXML
    void nextCaptchaAction(ActionEvent event) {
        amountText.setText(MainPage.chargeAmount);
        refundText.setText(MainPage.refundMethod);
        captchaRandomTextField.setText(randomData.captchaData(1, 98));
    }

    @FXML
    void cancelAction(ActionEvent event) {
        globalTools.closeCurrentPage(cancelButton, "./pages/bankingPortal/bankingPortal.fxml");
    }

    @FXML
    void proceedAction(ActionEvent event) {

    }

    @FXML
    void requestSMSOTPAction(ActionEvent event) {

    }

}
