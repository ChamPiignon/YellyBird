package fr.iut.yellybird.sprite;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.SurfaceHolder;

import fr.iut.yellybird.game.GameView;


/**
 * The type Sprite animation.
 */
public class SpriteAnimation implements  Sprite{
        private final int FRAME_COUNT;
    /**
     * The X.
     */
    public float x = 0, /**
     * The Y.
     */
    y = 0;
        private SurfaceHolder ourHolder;
        private Bitmap sprite;
        private int frameWidth;


    private int frameHeight;
        private int currentFrame = 0;
        private GameView context;
        private long lastFrameChangeTime = 0;
        private int frameLengthInMillisecond = 150;
        private Rect frameToDraw;
        private RectF whereToDraw;

    /**
     * Instantiates a new Sprite animation.
     *
     * @param context     the context
     * @param ressourceId the ressource id
     * @param nbFrame     the nb frame
     * @param width       the width
     * @param Height      the height
     * @param scale       the scale
     */
    public SpriteAnimation(GameView context, int ressourceId, int nbFrame, int width, int Height, int scale) {
            this.context = context;
            ourHolder = context.getHolder();
            FRAME_COUNT = nbFrame;
            frameWidth=width*scale;
            frameHeight=Height*scale;
            frameToDraw = new Rect(0, 0, frameWidth, frameHeight);
            whereToDraw = new RectF(x, y, x + frameWidth, frameHeight);
            sprite = BitmapFactory.decodeResource(context.getResources(), ressourceId);
            sprite = Bitmap.createScaledBitmap(sprite, frameWidth * FRAME_COUNT, frameHeight, false);
        }

    /**
     * Instantiates a new Sprite animation.
     *
     * @param context     the context
     * @param ressourceId the ressource id
     * @param nbFrame     the nb frame
     * @param width       the width
     * @param Height      the height
     */
    public SpriteAnimation(GameView context, int ressourceId, int nbFrame, int width, int Height) {
            this(context,ressourceId,nbFrame,width,Height,1);
        }


    /**
     * Manage current frame.
     */
    public void manageCurrentFrame() {
            long time = System.currentTimeMillis();
            if (time > lastFrameChangeTime + frameLengthInMillisecond) {
                    lastFrameChangeTime = time;
                    currentFrame++;

                    if (currentFrame >= FRAME_COUNT) {
                        currentFrame = 0;
                    }
                }

            frameToDraw.left = currentFrame * frameWidth;
            frameToDraw.right = frameToDraw.left + frameWidth;
        }
    @Override
    public void draw(Canvas canvas) {
        if (ourHolder.getSurface().isValid()) {
                whereToDraw.set((int) x, (int) y, (int) x + frameWidth, (int) y + frameHeight);
                manageCurrentFrame();
                canvas.drawBitmap(sprite, frameToDraw, whereToDraw, null);
        }
     }

    /**
     * Is collide boolean.
     *
     * @param x2 the x 2
     * @param y2 the y 2
     * @return the boolean
     */
    public boolean isCollide(float x2, float y2) {
        return x2 > x && x2 < x + frameWidth && y2 > y && y2 < y + frameHeight;
    }

    /**
     * Gets frame width.
     *
     * @return the frame width
     */
    public int getFrameWidth() {
        return frameWidth;
    }

    /**
     * Gets frame height.
     *
     * @return the frame height
     */
    public int getFrameHeight() {
        return frameHeight;
    }

    /**
     * Gets context.
     *
     * @return the context
     */
    public GameView getContext() {
        return context;
    }

    /**
     * Gets where to draw.
     *
     * @return the where to draw
     */
    public RectF getWhereToDraw() {
        return whereToDraw;
    }
}
