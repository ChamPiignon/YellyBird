package fr.iut.yellybird.Sprite;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.SurfaceHolder;

import fr.iut.yellybird.Game.GameView;
import fr.iut.yellybird.components.Pipes;

public class PipeSprite {
    private Pipes pipes;
    private Bitmap bottomPipe;
    private Bitmap topPipe;
    private RectF whereToDrawB;
    private RectF whereToDrawT;
    private SurfaceHolder ourHolder;

    public PipeSprite(GameView context, int ressourceIdBottomPipe, int ressourceIdTopPipe)
    {
        ourHolder=context.getHolder();
        bottomPipe = BitmapFactory.decodeResource(context.getResources(),ressourceIdBottomPipe);
        topPipe = BitmapFactory.decodeResource(context.getResources(),ressourceIdTopPipe);
        pipes =new Pipes(context.getHeight(),context.getWidth());
        whereToDrawB=new RectF(pipes.getX(), pipes.getyUp(), pipes.getX()+topPipe.getWidth(), topPipe.getHeight());
        whereToDrawT=new RectF(pipes.getX(), pipes.getyUp(), pipes.getX()+topPipe.getWidth(), topPipe.getHeight());
    }

    public void draw(Canvas canvas)
    {
        if (ourHolder.getSurface().isValid()) {
            whereToDrawT.set(
                    pipes.getX(),
                    pipes.getyUp(),
                    pipes.getX()+ topPipe.getWidth(),
                    pipes.getyUp() + topPipe.getHeight());
            canvas.drawBitmap(topPipe, null, whereToDrawT, null);

            //tuyeau bas
            whereToDrawB.set(
                    pipes.getX(),
                    pipes.getyDown(), // 1000
                    pipes.getX()+bottomPipe.getWidth(),
                    pipes.getyDown() + bottomPipe.getHeight() // 1000 + 400 = 1400
            ); // position Y du bas du tuyeau, si bottomPipe.getHeight() = 400;
            canvas.drawBitmap(bottomPipe, null, whereToDrawB,null);
        }
        pipes.moveX();
    }


}
