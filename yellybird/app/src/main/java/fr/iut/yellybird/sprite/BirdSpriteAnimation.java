package fr.iut.yellybird.sprite;

import android.graphics.Canvas;

import fr.iut.yellybird.game.GameView;

public class BirdSpriteAnimation extends SpriteAnimation{
    private int forceGravity;
    public boolean isOnTheFloor;
    private int floorHeigh;

    public BirdSpriteAnimation(GameView context, int ressourceId, int nbFrame, int width, int Height, int scale, int gravity) {
        super(context, ressourceId, nbFrame, width, Height, scale);
        this.forceGravity= gravity;
        this.isOnTheFloor=false;
        floorHeigh=getContext().getHeight()-getFrameHeight();
    }

    public BirdSpriteAnimation(GameView context, int ressourceId, int nbFrame, int width, int Height, int forceGravity) {
        super(context, ressourceId, nbFrame, width, Height);
        this.forceGravity= forceGravity;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        update();
    }

    private void update() {
        if (y >= getContext().getHeight()- floorHeigh - getFrameHeight() - forceGravity) {
            forceGravity = 0;
            isOnTheFloor=true;
        }
        y = y + forceGravity;
    }

    public void fly()
    {
        if(forceGravity != 0)
        {
            y = y - forceGravity*30;
            if(y>=getContext().getHeight())
            {
                int val=getContext().getHeight();
                y=val;
            }
        }
    }

    public void setFloorHeight(int height) {
        floorHeigh=height;
    }
}
