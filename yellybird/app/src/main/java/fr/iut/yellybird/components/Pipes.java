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
        yUp = (int) (yDown - screenHeight/1.1);
        SPACING_X = screenWidth*0.15;
        x=screenWidth;
        X_INIT=screenHeight;
        height = screenHeight;
        width = screenWidth;
    }

    public void moveX(){
        x -= X_REDUCER*width;
        if(x<=-SPACING_X){
            initX();
        }
    }
    public void initX(){
        x = X_INIT;
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
