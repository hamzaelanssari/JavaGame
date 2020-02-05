package com;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import javax.xml.stream.events.StartElement;

import static javafx.scene.paint.Color.WHITE;


public class Menu implements  SceneInterface{
    SceneManager sceneManager;
    BorderPane root;
    Scene Menu;
    GridPane gridPane=new GridPane();
    public Menu(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @Override
    public Scene init(double width, double height) {
        root=new BorderPane();
        root.setStyle("-fx-background-color: black;");
        MenuText();
        Menu=new Scene(root,width,height);
        return Menu;
    }

    public void MenuText(){
        addStartGameButton();
        addPlusButton();
        root.setCenter(gridPane);
    }
    public void addStartGameButton(){
        Button StartButton=new Button("Start Game");
        StartButton.setStyle("    -fx-font: 20px Serif;"+"-fx-pref-height: 50;" + "    -fx-pref-width: 300;" + "    -fx-text-fill:white;" + "-fx-background-color: #004080;");
        StartButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                sceneManager.goToGameScene(sceneManager);
            }
        });
        StartButton.setTranslateY(200);StartButton.setTranslateX(300);
        gridPane.getChildren().add(StartButton);
    }
    public void addPlusButton(){
        Button Plus=new Button("Plus");;
       Plus.setStyle("    -fx-font: 20px Serif;"+"-fx-pref-height: 50;" + "    -fx-pref-width: 300;" + "    -fx-text-fill:white;" + "-fx-background-color: #004080;");
        Plus.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                sceneManager.goPlusInfoScene(sceneManager);
            }
        });
        Plus.setTranslateX(300);Plus.setTranslateY(280);
        gridPane.getChildren().add(Plus);

    }

}
