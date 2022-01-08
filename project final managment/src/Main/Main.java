package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

public class Main extends Application {
    Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("../pages/login/LoginPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Me&You");
        primaryStage.setScene(scene);
        //add application icon
        File file = new File("D:\\project final\\src\\files\\image\\icon\\mainIcon.png");
        Image image = new Image(file.toURI().toString());
        primaryStage.getIcons().add(image);
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add("./pages/css/loginStyle.css");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
