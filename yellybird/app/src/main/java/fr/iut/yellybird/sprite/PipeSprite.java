package fr.iut.yellybird.sprite;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.SurfaceHolder;

import fr.iut.yellybird.game.GameView;
import fr.iut.yellybird.models.Pipes;

/**
 * The type Pipe sprite.
 */
public class PipeSprite implements Sprite {
    private Pipes pipes;
    private Bitmap bottomPipe;
    private Bitmap topPipe;
    private RectF whereToDrawB;
    private RectF whereToDrawT;
    private SurfaceHolder ourHolder;

    /**
     * Instantiates a new Pipe sprite.
     *
     * @param context               the context
     * @param ressourceIdBottomPipe the ressource id bottom pipe
     * @param ressourceIdTopPipe    the ressource id top pipe
     */
    public PipeSprite(GameView context, int ressourceIdBottomPipe, int ressourceIdTopPipe)
    {
        ourHolder=context.getHolder();
        topPipe = BitmapFactory.decodeResource(context.getResources(),ressourceIdTopPipe);
        bottomPipe = BitmapFactory.decodeResource(context.getResources(),ressourceIdBottomPipe);
        pipes =new Pipes(context.getHeight(),context.getWidth());
        whereToDrawT=new RectF(pipes.getX(), pipes.getyUp(), pipes.getX()+topPipe.getWidth(), topPipe.getHeight());
        whereToDrawB=new RectF(pipes.getX(), pipes.getyDown(), pipes.getX()+topPipe.getWidth(), topPipe.getHeight());
    }

    @Override
    public void draw(Canvas canvas)
    {
        if (ourHolder.getSurface().isValid()) {
            whereToDrawT.set(
                    pipes.getX(),
                    0,
                    pipes.getX()+ topPipe.getWidth(),
                    pipes.getyUp() + topPipe.getHeight());
            canvas.drawBitmap(topPipe, null, whereToDrawT, null);

            //tuyeau bas
            whereToDrawB.set(
                    pipes.getX(),
                    pipes.getyDown(), // 1000
                    pipes.getX()+bottomPipe.getWidth(),
                    canvas.getHeight() // 1000 + 400 = 1400
            ); // position Y du bas du tuyeau, si bottomPipe.getHeight() = 400;
            canvas.drawBitmap(bottomPipe, null, whereToDrawB,null);
        }
    }

    /**
     * Move x.
     */
    public void moveX(){
        pipes.setX((int) (pipes.getX()-(pipes.X_REDUCER*pipes.width)));
    }

    /**
     * Init position.
     */
    public void initPosition() {
        pipes.init();
    }

    /**
     * Gets pipes.
     *
     * @return the pipes
     */
    public Pipes getPipes() {
        return pipes;
    }

    /**
     * Gets where to draw b.
     *
     * @return the where to draw b
     */
    public RectF getWhereToDrawB() {
        return whereToDrawB;
    }

    /**
     * Gets where to draw t.
     *
     * @return the where to draw t
     */
    public RectF getWhereToDrawT() {
        return whereToDrawT;
    }
}
