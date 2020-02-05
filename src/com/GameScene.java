package com;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GameScene implements SceneInterface{
    BorderPane root;

    private GridPane container=new GridPane();
    VBox VboxRight=new VBox();

    int i=0;
    double buttom_size=520;
    double top_size=5;
    static int Score = 0;
    static int dead = 0;
    static int Level=1;
    static int lives=3;
    static int BossLives=3;
    // boolean  GameOver = false;
    private Player player=new Player();
    private List<MonstreBoss> monstresBoss=new ArrayList<>();
    private HashSet<Monstre> monstres = new HashSet<Monstre>();
    private List<Balle> balles = new ArrayList<>();
    private List<MonstreBalle>ballesMonstres = new ArrayList<>();

    Label GameName=new Label("Shoot enemies");
    Label score=new Label("Score");
    Label scorevalue=new Label("");
    Label kill=new Label("You kill");
    Label killvalue=new Label("");
    Label level=new Label("Level");
    Label levelvalue=new Label("");
    Label Lives=new Label("+");
    Label livesvalue=new Label("");
    Label controls=new Label("Controls");
    Label pause_start=new Label("Pause / Start : Space");
    Label shoot=new Label("Shoot : Button Q ");
    Label move_left=new Label("Move Left : Button Left");
    Label move_right=new Label("Move Right : Button Right");
    AnimationTimer animation = new 	AnimationTimer() {

        @Override
        public void handle(long now) {
            refeshContent();

        }
    };


    SceneManager sceneManager;

    public GameScene(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    Scene gameScene;
    @Override
    public Scene init(double width, double height){
        root=new BorderPane();
        CreatVboxRight();
        try {
            initGame();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        gameScene=new Scene(root,width,height);
        gameScene.setOnKeyPressed(event);
        animation.start();
        return gameScene;
    }
    private void initGame() throws FileNotFoundException {
        container.setStyle("-fx-background-color: black;"+"-fx-padding: 10;" + "-fx-border-style: solid dashed inside;"+"-fx-border-width: 10;"+"-fx-border-insets: 5;"+"-fx-border-radius: 5;"+ "-fx-border-color: blue;");
        container.setPrefWidth(600);
        container.setPrefHeight(600);
        container.getChildren().add(player.getCorps());
        root.setLeft(container);
        root.setRight(VboxRight);
    }
    private  void CreatGameName(){
        GameName.setTranslateX(50);
        GameName.setTranslateY(35);
        GameName.setStyle("-fx-font: normal bold 26px 'Arial';"+" -fx-text-fill: cyan;");
        VboxRight.getChildren().add(GameName);
    }
    private void CreatScoreLabel(){
        score.setStyle("-fx-font: normal  20px 'Arial';"+" -fx-text-fill: white;");
        score.setTranslateX(20);
        score.setTranslateY(110);
        scorevalue.setStyle("-fx-font: normal  16px 'Arial';"+" -fx-text-fill: white;"+"-fx-border-style: solid ;"+"-fx-border-width: 2;"+ "-fx-border-color: white;"+"-fx-padding: 10 80 10 80;");
        scorevalue.setTranslateY(75);
        scorevalue.setTranslateX(100);
        scorevalue.setText(String.valueOf(Score));
        VboxRight.getChildren().addAll(score,scorevalue);
    }
    private void CreatKillLabel(){

        kill.setStyle("-fx-font: normal  20px 'Arial';"+" -fx-text-fill: white;");
        kill.setTranslateX(20);
        kill.setTranslateY(150);
        killvalue.setStyle("-fx-font: normal  16px 'Arial';"+" -fx-text-fill: white;"+"-fx-border-style: solid ;"+"-fx-border-width: 2;"+ "-fx-border-color: white;"+"-fx-padding: 10 80 10 80;");
        killvalue.setTranslateY(115);
        killvalue.setTranslateX(100);
        killvalue.setText(String.valueOf(dead));
        VboxRight.getChildren().addAll(kill,killvalue);
    }
    private void CreatLevelLabel(){

        level.setStyle("-fx-font: normal  20px 'Arial';"+" -fx-text-fill: white;");
        level.setTranslateX(20);
        level.setTranslateY(190);
        levelvalue.setStyle("-fx-font: normal  16px 'Arial';"+" -fx-text-fill: white;"+"-fx-border-style: solid ;"+"-fx-border-width: 2;"+ "-fx-border-color: white;"+"-fx-padding: 10 80 10 80;");
        levelvalue.setTranslateY(155);
        levelvalue.setTranslateX(100);
        levelvalue.setText(String.valueOf(dead));
        VboxRight.getChildren().addAll(level,levelvalue);
    }
    private void CreatLivesLLabel(){
        Lives.setStyle("-fx-font: normal  20px 'Arial';"+" -fx-text-fill: cyan;");
        Lives.setTranslateY(160);
        Lives.setTranslateX(20);
        livesvalue.setStyle("-fx-font: normal  20px 'Arial';"+" -fx-text-fill: cyan;");
        livesvalue.setTranslateY(135);
        livesvalue.setTranslateX(40);
        livesvalue.setText(String.valueOf(lives));
        VboxRight.getChildren().addAll(Lives,livesvalue);
    }
    private void CreatControlsText(){
        controls.setStyle("-fx-font: normal  bold 20px  'Arial';"+" -fx-text-fill: white;");
        controls.setTranslateY(150);
        controls.setTranslateX(70);
        pause_start.setStyle("-fx-font: normal   16px  'Arial';"+" -fx-text-fill: white;");
        pause_start.setTranslateY(165);
        pause_start.setTranslateX(55);
        move_right.setStyle("-fx-font: normal   16px  'Arial';"+" -fx-text-fill: white;");
        move_right.setTranslateY(175);
        move_right.setTranslateX(55);
        move_left.setStyle("-fx-font: normal   16px  'Arial';"+" -fx-text-fill: white;");
        move_left.setTranslateY(185);
        move_left.setTranslateX(55);
        shoot.setStyle("-fx-font: normal   16px  'Arial';"+" -fx-text-fill: white;");
        shoot.setTranslateY(195);
        shoot.setTranslateX(55);
        VboxRight.getChildren().addAll(controls,pause_start,move_right,move_left,shoot);
    }
    private  void CreatVboxRight()
    {
        VboxRight.setPrefWidth(300);
        VboxRight.setPrefHeight(600);
        VboxRight.setStyle("-fx-background-color: black;");
        CreatGameName();
        CreatScoreLabel();
        CreatKillLabel();
        CreatLevelLabel();
        CreatLivesLLabel();
        CreatControlsText();

    }
    private void refeshContent() {

        for (Balle balle : balles) {
            balle.moveBalle("UP");
            if(balle.getCorps().getTranslateY()<=top_size){
                container.getChildren().remove(balle.getCorps());
                balle.setAlive(false);
            }
            for(Monstre monster:monstres) {
                if(balle.touch(monster)) {
                    container.getChildren().removeAll(balle.getCorps(),monster.getCorps());
                    balle.setAlive(false);
                    monster.setAlive(false);
                    Score=Score+10;
                    dead=dead+1;
                }
            }
            for (MonstreBoss monstreBoss:monstresBoss){
                if (balle.touch(monstreBoss)){
                    container.getChildren().remove(balle.getCorps());
                    balle.setAlive(false);
                    BossLives=BossLives-1;}
                if (BossLives==0){
                    container.getChildren().remove(monstreBoss.getCorps());
                    monstreBoss.setAlive(false);
                    Score=Score+100;
                    dead=dead+1;
                    BossLives=3;
                }
            }
        }
        if(dead==9 || dead==19 || dead==29){
            for(Monstre monster:monstres) {
                    container.getChildren().remove(monster.getCorps());
                    monster.setAlive(false);
                }
            if (monstresBoss.isEmpty()){
            MonstreBoss monstreBoss=new MonstreBoss();
            container.getChildren().add(monstreBoss.getCorps());
            monstresBoss.add(monstreBoss);}
        }
        for (MonstreBoss monstreBoss:monstresBoss){
            monstreBoss.Move_Monstres();
            if (Math.random()<0.05){
                    MonstreBalle balleMonstre=new MonstreBalle(monstreBoss);
                    ballesMonstres.add(balleMonstre);
                    container.getChildren().add(balleMonstre.getCorps());}
        }
        if (dead!=9 && dead!=19 && dead!=29){
        if(dead<10){
            Level=1;
            if(Math.random()<0.003) {
                Monstre m = new Monstre();
                container.getChildren().add(m.getCorps());
                monstres.add(m);
            }

        }
        if(dead<20 && dead>=10){
            Level=2;
            if(Math.random()<0.005) {
                Monstre m = new Monstre();
                container.getChildren().add(m.getCorps());
                monstres.add(m);
            }

        }
        if(dead<30 && dead>=20){
            Level=3;
            if(Math.random()<0.01) {
                Monstre m = new Monstre();
                container.getChildren().add(m.getCorps());
                monstres.add(m);
            }
        }}
        if(dead==30){
            sceneManager.goToGameWonScene(sceneManager);
        }
        scorevalue.setText(String.valueOf(Score));
        killvalue.setText(String.valueOf(dead));
        levelvalue.setText(String.valueOf(Level));
        for(Monstre m:monstres){
            if(Math.random()<0.005){
                MonstreBalle balleMonstre=new MonstreBalle(m);
                ballesMonstres.add(balleMonstre);
                container.getChildren().add(balleMonstre.getCorps());}
            m.Move_Monstres();
            if(m.touch(player) || m.getCorps().getTranslateY()>=buttom_size){
                lives=lives-1;
                container.getChildren().remove(m.getCorps());
                m.setAlive(false);

                //GameOver=true;
            }
        }

        for (MonstreBalle balle : ballesMonstres) {
            balle.moveBalle("DOWN");
            if(balle.getCorps().getTranslateY()>=buttom_size){
                container.getChildren().remove(balle.getCorps());
                balle.setAlive(false);
            }
            if(balle.touch(player)){
                lives=lives-1;
                container.getChildren().remove(balle.getCorps());
                balle.setAlive(false);
                //GameOver=true;
            }

        }
        if (lives==0){
            container.getChildren().remove(player.getCorps());
            player.setAlive(false);
            sceneManager.goToGameOverScene(sceneManager);}
        livesvalue.setText(String.valueOf(lives));
        monstres.removeIf(GraphicObject::isDead);
        balles.removeIf(GraphicObject::isDead);
        monstresBoss.removeIf(GraphicObject::isDead);
        ballesMonstres.removeIf(GraphicObject::isDead);


    }
    EventHandler<KeyEvent> event = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            player.handlePlayerKey(event.getCode());
            if(event.getCode()== KeyCode.Q){
                Balle balle=new Balle(player);
                container.getChildren().add(balle.getCorps());
                balles.add(balle);
            }
            if(event.getCode()==KeyCode.SPACE){
                if(i==0){
                    animation.stop();
                    i=1;}
                else{
                    animation.start();
                    i=0;
                }
            }



        }


    };
}
