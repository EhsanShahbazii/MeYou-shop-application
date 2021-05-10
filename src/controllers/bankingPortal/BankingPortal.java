package controllers.bankingPortal;

import com.jfoenix.controls.JFXButton;
import controllers.customer.MainPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import modules.tools.GlobalTools;
import modules.tools.RandomData;

import javax.script.ScriptException;
import javax.swing.*;
import java.io.File;

public class BankingPortal {

    GlobalTools globalTools = new GlobalTools();
    RandomData randomData = new RandomData();
    String cvv, captcha;
    String captchaResult;

    public void initialize() throws ScriptException {
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
        captcha = randomData.captchaData(1, 98);
        captchaRandomTextField.setText(captcha);
        captchaResult = randomData.captchaSolve(captcha);

        terminalText.setText(randomData.randomNumberCreator(1900000000, 1989999999));

        File file = new File("D:\\project final\\src\\files\\image\\gif\\spinner.gif");
        Image image = new Image(file.toURI().toString());
        connectingImageView.setImage(image);
    }

    @FXML
    public Text terminalText;

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
    private ImageView connectingImageView;

    @FXML
    void nextCaptchaAction(ActionEvent event) throws ScriptException {
        amountText.setText(MainPage.chargeAmount);
        refundText.setText(MainPage.refundMethod);
        captcha = randomData.captchaData(1, 98);
        captchaRandomTextField.setText(captcha);
        captchaResult = randomData.captchaSolve(captcha);
    }

    @FXML
    void cancelAction(ActionEvent event) {
        globalTools.closeCurrentPage(cancelButton, "./pages/bankingPortal/bankingPortal.fxml");
    }

    @FXML
    void proceedAction(ActionEvent event) {
        if (cardNumberTextField1.getText().isEmpty())
            globalTools.AlertShow("Please enter your card number");
        else if (cardNumberTextField2.getText().isEmpty())
            globalTools.AlertShow("Please enter your card number");
        else if (cardNumberTextField3.getText().isEmpty())
            globalTools.AlertShow("Please enter your card number");
        else if (cardNumberTextField4.getText().isEmpty())
            globalTools.AlertShow("Please enter your card number");
        else if (CVV2TextFIeld.getText().isEmpty())
            globalTools.AlertShow("Please enter your cvv2");
        else if (cvvTextField.getText().isEmpty())
            globalTools.AlertShow("Please enter your cvv");
        else if (captchaTextField.getText().isEmpty())
            globalTools.AlertShow("Please enter captcha");
        else if (captchaTextField.getText().equals(captchaResult))
            globalTools.AlertShow("please enter captcha correct");
    }

    @FXML
    void requestSMSOTPAction(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        cvv = randomData.randomNumberCreator(1234, 9876);
        alert.setHeaderText("Pay Pal");
        alert.setContentText("Your CVV is: " + cvv);
        alert.show();
    }

}
