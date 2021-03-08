package fr.iut.yellybird.components;

public class Pipes {

    private int width;
    private int height;
    private int yUp,yDown;
    private int x;
    private final double X_REDUCER=.015;
    private final double SPACING_X;
    private final int X_INIT;

    public Pipes(int screenHeight, int screenWidth){
        yDown = (int) Math.floor(Math.random() * (screenHeight/2) + .3 * screenHeight);
        yUp = (int) (yDown - screenHeight);
        SPACING_X = screenWidth*0.15;
        x=screenWidth;
        X_INIT=screenHeight;
        height = screenHeight;
        width = screenWidth;
    }

    public void moveX(){
        x -= X_REDUCER*width;
        if(x<=-SPACING_X){
            init();
        }
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

}
