package Main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    Parent root;
    double xOffset=0,yOffset=0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("../pages/customer/LoginPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Me&You");
        primaryStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();

//        root.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                xOffset = mouseEvent.getSceneX();
//                yOffset = mouseEvent.getSceneY();
//
//            }
//        });
//        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                primaryStage.setX(mouseEvent.getSceneX() - xOffset);
//                primaryStage.setY(mouseEvent.getSceneY() - yOffset);
//            }
//        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
