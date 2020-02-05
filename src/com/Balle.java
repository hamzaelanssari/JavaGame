package com;


import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class Balle extends GraphicObject {

    public static final double MOVE_SHIFT = 5;
    public Balle(GraphicObject shooter) {
        corps=new Circle(6,0,4,Color.BLUE);
        corps.setTranslateX(shooter.getCorps().getTranslateX()+2);
        corps.setTranslateY(shooter.getCorps().getTranslateY()-10);
    }
    public void moveBalle(String direction) {
        switch (direction) {
            case "UP":
                corps.setTranslateY(corps.getTranslateY() - MOVE_SHIFT);
                break;
            case "DOWN":
                corps.setTranslateY(corps.getTranslateY() + MOVE_SHIFT);
                break;
            case "LEFT":
                corps.setTranslateX(corps.getTranslateX() - MOVE_SHIFT);
                break;
            case "RIGHT":
                corps.setTranslateX(corps.getTranslateX() + MOVE_SHIFT);
                break;
            default:
                // do nothing
        }
    }


}