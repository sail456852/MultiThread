package udemy.gui.fx.demo1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class MyJavaFx extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btOk = new Button("OK");
//        Scene scene =  new Scene();
        primaryStage.setTitle("MyJavaFx");
//        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
