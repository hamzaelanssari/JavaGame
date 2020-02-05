package com;



import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SceneManager {
    double window_width=900;
    double window_height=600;

    private Stage stage;
    private Timeline animation;

    public SceneManager(Stage stage) {
        this.stage = stage;
        animation=new Timeline();
        stage.show();
    }
    //go to Menu_Scene
    public void goToMenuScene(SceneManager sceneManager) {
        animation.stop();
        Menu menu = new Menu(sceneManager);
        Scene menuScene = menu.init(window_width,window_height);
        stage.setScene(menuScene);
    }
    public void goPlusInfoScene(SceneManager sceneManager){
        animation.stop();
        PlusInfo plusinfo =new PlusInfo(sceneManager);
        Scene plusinfoScene = null;
        plusinfoScene = plusinfo.init(window_width,window_height);
        stage.setScene(plusinfoScene);
    }
    public void goToGameScene(SceneManager sceneManager) {
       GameScene game= new GameScene(sceneManager);
       Scene gameScene = game.init(window_width,window_height);
       stage.setScene(gameScene);
   }
    public void goToGameOverScene(SceneManager sceneManager) {
        animation.stop();
        GameOver gameOver = new GameOver(sceneManager);
        Scene gameOverScene = gameOver.init(window_width, window_height);
        stage.setScene(gameOverScene);
    }

    public void goToGameWonScene(SceneManager sceneManager) {
        animation.stop();
        GameWon gameWon = new GameWon(sceneManager);
        Scene gameWonScene = gameWon.init(window_width, window_height);
        stage.setScene(gameWonScene);
    }


}
