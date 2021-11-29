package controllers.bankingPortal;

import com.jfoenix.controls.JFXButton;
import controllers.customer.MainPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import modules.files.SelectAndBuyProduct;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;
import modules.tools.RandomData;

import java.io.FileNotFoundException;

public class FinalPayment {

    //variables which are used
    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();
    RandomData randomData = new RandomData();
    SelectAndBuyProduct selectAndBuyProduct = new SelectAndBuyProduct();

    String username, captcha, captchaResult;

    public void initialize() {

        //get username and save it
        username = MainPage.usernames;

        //add limit for captcha text field
        globalTools.LimitedTextField(captchaTextField, 4);

        //set $ sign before cart amount field
        amountText.setText( "$ " + MainPage.cartAmount);

        //create captcha and set captcha
        captcha = randomData.captchaData(1, 98);
        captchaRandomTextField.setText(captcha);

        //solve captcha and save it
        captchaResult = randomData.captchaSolve(captcha);
    }

    @FXML
    private Text amountText;

    @FXML
    private TextField discountTextField;

    @FXML
    private TextField captchaRandomTextField;

    @FXML
    private TextField captchaTextField;

    @FXML
    private JFXButton proceedButton;

    @FXML
    private JFXButton cancelButton;

    @FXML
    private Button nextCaptchaButton;

    @FXML
    private ImageView captchaImageView;

    @FXML
    private JFXButton proceedButton1;

    //this method is get back to main page
    @FXML
    void cancelAction(ActionEvent event) {
        globalTools.closeCurrentPage(cancelButton);
    }

    //set new captcha and show it
    @FXML
    void nextCaptchaAction(ActionEvent event) {
        //create new captcha logic
        captcha = randomData.captchaData(1, 98);
        //set captcha in field
        captchaRandomTextField.setText(captcha);
        //solve captcha and save it
        captchaResult = randomData.captchaSolve(captcha);
    }

    //this method add some proceedAction
    @FXML
    void proceedAction(ActionEvent event) throws FileNotFoundException {

        //show error message if captcha is invalid
        if (!captchaTextField.getText().equals(captchaResult))
            globalTools.AlertShow("please enter captcha correct");
        else {
            //update wallet balance and add new balance
            globalFileTools.updateWalletBalance(username, "-" + MainPage.cartAmount);

            //update product count and set product
            globalFileTools.updateProductCount(selectAndBuyProduct.finalPayment(username));

            //show successful alert
            globalTools.AlertShowInformation("Payment is successful!");

            //add information into the history payment
            globalFileTools.addToHistoryPayment(selectAndBuyProduct.finalPayment(username));

            //close banking portal page and back to dashboard
            globalTools.closeCurrentPage(cancelButton);
        }
    }
}

