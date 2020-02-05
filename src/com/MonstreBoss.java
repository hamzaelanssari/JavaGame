package com;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class MonstreBoss extends GraphicObject {
    public static final double WIDTH = 50;
    public static final double MOVE_SHIFT = 1;
    private boolean test=true;
    public MonstreBoss() {
        Image image=null;
        try {
            image = new Image(new FileInputStream("photosJeu/MonsterBoss.png"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        corps=new ImageView(image) ;
        ((ImageView)corps).setX(0);
        ((ImageView)corps).setY(0);

        //doit appartenir zone
        double x=284;
        double y=0;
        corps.setTranslateX(x);
        corps.setTranslateY(y);
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
    public void Move_Monstres()
    {
       if(test==true){
           moveRight();
           if (corps.getTranslateX()+WIDTH>540){
               test=false;
           }
       }
       else {
           moveLeft();
           if (corps.getTranslateX()+WIDTH<60){
               test=true;
           }
       }


    }
}