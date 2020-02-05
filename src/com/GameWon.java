package com;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import static javafx.scene.paint.Color.WHITE;

public class GameWon implements SceneInterface{
    SceneManager sceneManager;

    public GameWon(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    Scene GameWonScene;
        BorderPane root;
        @Override
        public Scene init(double width, double height) {
            root=new BorderPane();
            root.setStyle("-fx-background-color: black;");
            GameWonText();
            GameWonScene=new Scene(root,width,height);
            GameWonScene.setOnKeyPressed(event);
            return GameWonScene;
        }
        public void GameWonText(){
            Text gameWonText=new Text("Congratulations");
            gameWonText.setFill(WHITE);
            gameWonText.setStyle("-fx-font: normal bold 40px 'Arial';");
            gameWonText.setX(330);
            gameWonText.setY(300);
            root.getChildren().add( gameWonText);
        }
    EventHandler<KeyEvent> event = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            if(event.getCode()== KeyCode.ESCAPE){
                sceneManager.goToMenuScene(sceneManager);
            }
        }
    };
}
