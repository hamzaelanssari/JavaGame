package sample;

import com.*;

import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.*;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Shoot enemies");
        SceneManager sceneManager=new SceneManager(primaryStage);
        sceneManager.goToMenuScene(sceneManager);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
