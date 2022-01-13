package controllers.bankingPortal;

import com.jfoenix.controls.JFXButton;
import controllers.customer.MainPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import modules.tools.GlobalFileTools;
import modules.tools.GlobalTools;
import modules.tools.RandomData;

public class FinalPayment {

    //variables which are used
    GlobalTools globalTools = new GlobalTools();
    GlobalFileTools globalFileTools = new GlobalFileTools();
    RandomData randomData = new RandomData();

    String username;

    public void initialize() {

        username = MainPage.usernames;

        globalTools.LimitedTextField(captchaTextField, 4);
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

    @FXML
    void cancelAction(ActionEvent event) {
        globalTools.closeCurrentPage(cancelButton, "./pages/bankingPortal/bankingPortal.fxml");
    }

    @FXML
    void nextCaptchaAction(ActionEvent event) {

    }

    @FXML
    void proceedAction(ActionEvent event) {

    }

}

