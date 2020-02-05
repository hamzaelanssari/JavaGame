package com;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import static javafx.scene.paint.Color.*;

public class GameOver implements SceneInterface {
    SceneManager sceneManager;
  /*  AnimationTimer animation = new 	AnimationTimer() {

        @Override
        public void handle(long now) {
            refeshContent();

        }
    };*/

    public GameOver(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }
    Scene GameOverScene;
    BorderPane root;
    GridPane gridPane=new GridPane();
  //  Label gameoverText=new Label("GAME OVER !!");

    @Override
    public Scene init(double width, double height) {
        root=new BorderPane();
        root.setStyle("-fx-background-color: black;");
        GameOverText();
        GameOverScene=new Scene(root,width,height);
        GameOverScene.setOnKeyPressed(event);
        return GameOverScene;
    }
    private void GameOverText(){
        Text gameOverText=new Text("GAME OVER !!");
      /*  Button GoToMenuButton=new Button("Back To Menu");
        GoToMenuButton.setStyle("    -fx-font: 20px Serif;"+"-fx-pref-height: 50;" + "    -fx-pref-width: 300;" + "    -fx-text-fill:white;" + "-fx-background-color: #004080;");
        */
        gameOverText.setFill(WHITE);
        gameOverText.setStyle("-fx-font: normal bold 40px 'Arial';");
        gameOverText.setTranslateX(330);gameOverText.setTranslateY(300);
      /*  gridPane.setTranslateX(330);
        gridPane.setTranslateY(300);
        gridPane.getChildren().addAll(gameOverText,GoToMenuButton);
        root.setCenter(gridPane);*/
      root.getChildren().add(gameOverText);
      //root.getChildren().add(GoToMenuButton);
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
