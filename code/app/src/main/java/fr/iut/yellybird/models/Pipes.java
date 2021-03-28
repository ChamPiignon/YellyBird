package fr.iut.yellybird.models;

/**
 * The type Pipes.
 */
public class Pipes {

    /**
     * The Width.
     */
    public int width;
    /**
     * The Height.
     */
    public int height;
    private int yUp,yDown;
    private int x;
    /**
     * The X reducer.
     */
    public final double X_REDUCER=.015;
    /**
     * The Spacing x.
     */
    public final double SPACING_X;

    /**
     * Instantiates a new Pipes.
     *
     * @param screenHeight the screen height
     * @param screenWidth  the screen width
     */
    public Pipes(int screenHeight, int screenWidth){
        yDown = (int) Math.floor(Math.random() * (screenHeight/2) + .3 * screenHeight);
        yUp = (int) (yDown - screenHeight);
        SPACING_X = screenWidth*0.15;
        x=screenWidth;
        height = screenHeight;
        width = screenWidth;
    }

    /**
     * Init.
     */
    public void init(){
        x = width;
        yDown = (int) Math.floor(Math.random() * (height/2) + .3 * height);
        yUp = (int) (yDown - height);
    }

    /**
     * Gets up.
     *
     * @return the up
     */
    public int getyUp() {
        return yUp;
    }

    /**
     * Gets down.
     *
     * @return the down
     */
    public int getyDown() {
        return yDown;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int x) {
        this.x = x;
    }
}
