package fr.iut.yellybird.sprite;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.SurfaceHolder;

import fr.iut.yellybird.game.GameView;

/**
 * The type Floor sprite.
 */
public class FloorSprite implements Sprite {
    private Bitmap floor;
    private RectF whereToDraw;
    private SurfaceHolder ourHolder;

    /**
     * Instantiates a new Floor sprite.
     *
     * @param context     the context
     * @param ressourceId the ressource id
     */
    public FloorSprite(GameView context, int ressourceId)
    {
        ourHolder=context.getHolder();
        floor = BitmapFactory.decodeResource(context.getResources(),ressourceId);
        whereToDraw=new RectF(0,context.getHeight()-floor.getHeight(),context.getWidth(),context.getHeight());
        System.out.println(context.getHeight());
    }


    @Override
    public void draw(Canvas canvas) {
        if (ourHolder.getSurface().isValid()) {
            canvas.drawBitmap(floor, null, whereToDraw, null);
        }
    }

    /**
     * Update.
     */
    public void update()
    {

    }

    /**
     * Gets floor.
     *
     * @return the floor
     */
    public Bitmap getFloor() {
        return floor;
    }
}
