package fr.iut.yellybird.sprite;

import android.graphics.Canvas;

import fr.iut.yellybird.game.GameView;

/**
 * The type Bird sprite animation.
 */
public class BirdSpriteAnimation extends SpriteAnimation{
    private int forceGravity;
    /**
     * The Is on the floor.
     */
    public boolean isOnTheFloor;
    private int floorHeigh;

    /**
     * Instantiates a new Bird sprite animation.
     *
     * @param context     the context
     * @param ressourceId the ressource id
     * @param nbFrame     the nb frame
     * @param width       the width
     * @param Height      the height
     * @param scale       the scale
     * @param gravity     the gravity
     */
    public BirdSpriteAnimation(GameView context, int ressourceId, int nbFrame, int width, int Height, int scale, int gravity) {
        super(context, ressourceId, nbFrame, width, Height, scale);
        this.forceGravity= gravity;
        this.isOnTheFloor=false;
        floorHeigh=getContext().getHeight()-getFrameHeight();
    }

    /**
     * Instantiates a new Bird sprite animation.
     *
     * @param context      the context
     * @param ressourceId  the ressource id
     * @param nbFrame      the nb frame
     * @param width        the width
     * @param Height       the height
     * @param forceGravity the force gravity
     */
    public BirdSpriteAnimation(GameView context, int ressourceId, int nbFrame, int width, int Height, int forceGravity) {
        super(context, ressourceId, nbFrame, width, Height);
        this.forceGravity= forceGravity;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    /**
     * Move y.
     */
    public void moveY() {
        if (y >= getContext().getHeight()- floorHeigh - getFrameHeight() - forceGravity) {
            forceGravity = 0;
            isOnTheFloor=true;
        }
        y = y + forceGravity;
    }

    /**
     * Fly.
     */
    public void fly()
    {
        if(forceGravity != 0)
        {
            y -= forceGravity*floorHeigh*0.1;
            if(y<-getFrameHeight())
            {
                y=-getFrameHeight();
            }
        }
    }

    /**
     * Sets floor height.
     *
     * @param height the height
     */
    public void setFloorHeight(int height) {
        floorHeigh=height;
    }
}
