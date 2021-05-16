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
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;
import modules.tools.RandomData;


import java.io.File;
import java.io.FileNotFoundException;

public class BankingPortal {

    //variables which are used
    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();
    RandomData randomData = new RandomData();

    //variables for captcha policy
    String cvv, captcha, amount, username;
    String captchaResult;

    public void initialize() {

        username = MainPage.usernames;

        //limit text field length by 4 characters
        globalTools.moveToNextFieldByLimited(cardNumberTextField1, cardNumberTextField2, 4);
        globalTools.moveToNextFieldByLimited(cardNumberTextField2, cardNumberTextField3, 4);
        globalTools.moveToNextFieldByLimited(cardNumberTextField3, cardNumberTextField4, 4);
        globalTools.moveToNextFieldByLimited(cardNumberTextField4, CVV2TextFIeld, 4);

        //limit text field length
        globalTools.LimitedTextField(CVV2TextFIeld, 4);
        globalTools.LimitedTextField(captchaTextField, 4);
        globalTools.LimitedTextField(cvvTextField, 7);
        globalTools.LimitedTextField(emailTextField, 32);

        //set amount and refund method in fields
        amountText.setText(MainPage.chargeAmount);
        refundText.setText(MainPage.refundMethod);

        //create captcha logic
        captcha = randomData.captchaData(1, 98);
        captchaRandomTextField.setText(captcha);

        //solve captcha and save it
        captchaResult = randomData.captchaSolve(captcha);

        //remove $ sign in amount text
        amount = globalTools.justDigits(MainPage.chargeAmount);

        //create terminal number by random methods
        terminalText.setText(randomData.randomNumberCreator(1900000000, 1989999999));

        //set gif in connected anchor pane
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
    private JFXButton requestSMSOTPButton;

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

    //create new captcha logic
    @FXML
    void nextCaptchaAction(ActionEvent event) {
        //create new captcha logic
        captcha = randomData.captchaData(1, 98);
        //set captcha in field
        captchaRandomTextField.setText(captcha);
        //solve captcha and save it
        captchaResult = randomData.captchaSolve(captcha);
    }

    //go back to dashboard
    @FXML
    void cancelAction(ActionEvent event) {
        globalTools.closeCurrentPage(cancelButton, "./pages/bankingPortal/bankingPortal.fxml");
    }

    //sent cvv to customer and show it
    @FXML
    void requestSMSOTPAction(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        //create cvv number
        cvv = randomData.randomNumberCreator(1234, 9876);
        alert.setHeaderText("Pay Pal");
        alert.setContentText("Your CVV is: " + cvv);
        alert.show();
        requqestSMSOTPButton.setDisable(true);
    }

    //pressed and finish payment
    @FXML
    void proceedAction(ActionEvent event) throws FileNotFoundException {

        //check fields if they are empty show error for customer
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
        else if (!captchaTextField.getText().equals(captchaResult))
            globalTools.AlertShow("please enter captcha correct");
        else {
            //update wallet balance and add new balance
            globalFileTools.updateWalletBalance(username, amount);

            //show successful alert
            globalTools.AlertShowInformation("Payment is successful!");

            //close banking portal page and back to dashboard
            globalTools.closeCurrentPage(cancelButton, "./pages/bankingPortal/bankingPortal.fxml");
        }
    }
}
