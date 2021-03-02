package fr.iut.yellybird.Sprite;

import android.graphics.Canvas;

import fr.iut.yellybird.Game.GameView;

public class BirdSpriteAnimation extends SpriteAnimation{
    private int forceGravity;
    public boolean isOnTheFloor;
    public BirdSpriteAnimation(GameView context, int ressourceId, int nbFrame, int width, int Height, int scale, int gravity) {
        super(context, ressourceId, nbFrame, width, Height, scale);
        this.forceGravity= gravity;
        this.isOnTheFloor=false;
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
        if (y >= getContext().getHeight() - getFrameHeight() - forceGravity) {
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

}
