package com;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import static javafx.scene.paint.Color.WHITE;

public class PlusInfo implements SceneInterface{
    SceneManager sceneManager;

    public PlusInfo(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }
    Scene PlusInfoScene;
    BorderPane root;
    GridPane gridPane=new GridPane();

    @Override
    public Scene init(double width, double height) {
        root=new BorderPane();
        root.setStyle("-fx-background-color: black;");
        AddAllElements();
        PlusInfoScene=new Scene(root,width,height);
        return PlusInfoScene;
    }
    private void AddAllElements(){
        addPlusinfo();
        addMenuButton();
        root.setCenter(gridPane);
    }
    private void addPlusinfo() {
        Text text =new Text( "The goal of this game 'shoot enemies' is to win all 3 levels .\n" +
                "You have three levels,each level is difficult to the previous.you win when you pass all 3 levels.\n" +
                "in each level you should to kill 9 monsters and the boss,the boss show after you kill 9 monsters\n" +
                "you get 10 points for every monster you kill,when you kill boss you get 100 points and you pass to next level.\n" +
                "you have 3 lives, when the ball touch you, you lose one live,you lose when you lose all your lives.\n" +
                "also the boss has 3 lives, so you should shoot boss three times to kill him and pass to next level.\n" +
                "when you win or lose press on button ('ESC') if you want to comeback to menu scene.");
        Text text1=new Text("HOW TO PLAY: \n" +
                "you can pause and start the game with Space Button.\n" +
                "Shoot : Button Q \n" +
                "Move Left : Button Left \n" +
                "Move Right : Button Right\n");
        text.setFill(WHITE);text.setTranslateX(100);text.setTranslateY(100);
        text.setStyle("-fx-font: normal bold 15px 'Arial';");
        text1.setFill(WHITE);text1.setTranslateX(100);text1.setTranslateY(250);
        text1.setStyle("-fx-font: normal bold 15px 'Arial';");
        gridPane.getChildren().addAll(text,text1);
    }

    private void addMenuButton() {
        Button MenuButton =new Button("Back");
        MenuButton.setStyle("    -fx-font: 20px Serif;"+"-fx-pref-height: 30;" + "    -fx-pref-width: 100;" + "    -fx-text-fill:white;" + "-fx-background-color: #004080;");

        MenuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneManager.goToMenuScene(sceneManager);
            }
        });
        MenuButton.setTranslateX(100);MenuButton.setTranslateY(350);
        gridPane.getChildren().add(MenuButton);
    }
}
