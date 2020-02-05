package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import sample.Main;

public class Player extends GraphicObject {
    public static final double MOVE_SHIFT = 10;
    public static final double WIDTH = 50;
    public static final double HEIGHT = 50;
    public Player() {
        Image image=null;
        try {
            image = new Image(new FileInputStream("photosJeu/player.png"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        corps=new ImageView(image) ;
        corps.setTranslateX(300);
        corps.setTranslateY(500);
        //  corps.setLayoutX(300);
        //corps.setLayoutY(550);
    }

    public void handlePlayerKey(KeyCode code) {
        switch (code) {
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
      /*      case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;*/
            default:
                // do nothing
        }
    }

    private void moveLeft() {
        if (corps.getTranslateX()>0) {
            corps.setTranslateX(corps.getTranslateX() - MOVE_SHIFT);
        }
    }

    private void moveRight() {
        if (corps.getTranslateX()+ WIDTH < 550) {
            corps.setTranslateX(corps.getTranslateX() + MOVE_SHIFT);
        }
    }

    private void moveUp() {
        if (corps.getTranslateY() > 0) {
            corps.setTranslateY(corps.getTranslateY() - MOVE_SHIFT);
        }
    }

    private void moveDown() {
        if (corps.getTranslateY() + HEIGHT < 550) {
            corps.setTranslateY(corps.getTranslateY() + MOVE_SHIFT);
        }
    }
}
