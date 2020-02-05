package com;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Main;

public class Monstre extends GraphicObject {
    public static final double WIDTH = 50;
    public Monstre() {
        Image image=null;
        try {
            image = new Image(new FileInputStream("photosJeu/monster.png"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        corps=new ImageView(image) ;
        ((ImageView)corps).setX(0);
        ((ImageView)corps).setY(0);

        //doit appartenir zone
        double x=generateRandomEnemyX();
        double y=0;
        corps.setTranslateX(x);
        corps.setTranslateY(y);
    }
    private double generateRandomEnemyX() {
        Random r = new Random();
        return (550 - WIDTH) * r.nextDouble();
    }
    public void Move_Monstres()
    {
        corps.setTranslateY(corps.getTranslateY()+0.9);

    }
}