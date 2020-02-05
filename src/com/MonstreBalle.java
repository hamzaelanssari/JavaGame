package com;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MonstreBalle extends GraphicObject{
    public static final double MOVE_SHIFT = 5;
    public MonstreBalle(GraphicObject shooter) {
    corps=new Circle(6,0,4,Color.RED);
        corps.setTranslateX(shooter.getCorps().getTranslateX()+10);
        corps.setTranslateY(shooter.getCorps().getTranslateY()+30);
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
