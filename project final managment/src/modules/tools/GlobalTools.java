package modules.tools;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class GlobalTools {

    //this method used for limited characters in textField
    public void LimitedTextField(TextField textField, int maxLength){

        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (textField.getText().length() > maxLength) {
                    String string = textField.getText().substring(0, maxLength);
                    textField.setText(string);
                }
            }
        });
    }
}
