package fr.iut.yellybird.Sprite;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.SurfaceHolder;

import fr.iut.yellybird.Game.GameView;
import fr.iut.yellybird.components.Pipes;

public class FloorSprite implements Sprite {
    private Bitmap floor;
    private RectF whereToDraw;
    private SurfaceHolder ourHolder;

    public FloorSprite(GameView context, int ressourceId)
    {
        ourHolder=context.getHolder();
        floor = BitmapFactory.decodeResource(context.getResources(),ressourceId);
        //whereToDraw=new RectF(pipes.getX(), pipes.getyUp(), pipes.getX()+topPipe.getWidth(), topPipe.getHeight());
        whereToDraw=new RectF(0,context.getHeight()-floor.getHeight(),context.getWidth(),context.getHeight());
        System.out.println(context.getHeight());
    }


    @Override
    public void draw(Canvas canvas) {
        if (ourHolder.getSurface().isValid()) {
//            whereToDraw.set(
//                    pipes.getX(),
//                    pipes.getyUp(),
//                    pipes.getX()+ topPipe.getWidth(),
//                    pipes.getyUp() + topPipe.getHeight()
//            );
            canvas.drawBitmap(floor, null, whereToDraw, null);
        }
    }

    public void update()
    {

    }
}
