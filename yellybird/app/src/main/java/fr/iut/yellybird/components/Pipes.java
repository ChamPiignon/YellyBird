package fr.iut.yellybird.components;

public class Pipes {

    public int width;
    public int height;
    private int yUp,yDown;
    private int x;
    public final double X_REDUCER=.015;
    public final double SPACING_X;
    public final int X_INIT;

    public Pipes(int screenHeight, int screenWidth){
        yDown = (int) Math.floor(Math.random() * (screenHeight/2) + .3 * screenHeight);
        yUp = (int) (yDown - screenHeight);
        SPACING_X = screenWidth*0.15;
        x=screenWidth;
        X_INIT=screenHeight;
        height = screenHeight;
        width = screenWidth;
    }

    public void init(){
        x = X_INIT;
        yDown = (int) Math.floor(Math.random() * (height/2) + .3 * height);
        yUp = (int) (yDown - height);
    }
    public int getyUp() {
        return yUp;
    }
    public int getyDown() {
        return yDown;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
}
