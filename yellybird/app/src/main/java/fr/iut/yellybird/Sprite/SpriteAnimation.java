package fr.iut.yellybird.Sprite;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.SurfaceHolder;

import fr.iut.yellybird.Game.GameView;


public class SpriteAnimation {
        private final int FRAME_COUNT;
        public float x = 0, y = 0;
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

        public SpriteAnimation(GameView context, int ressourceId, int nbFrame, int width, int Height) {
            this(context,ressourceId,nbFrame,width,Height,1);
        }


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

    public void draw(Canvas canvas) {
        if (ourHolder.getSurface().isValid()) {
                whereToDraw.set((int) x, (int) y, (int) x + frameWidth, (int) y + frameHeight);
                manageCurrentFrame();
                canvas.drawBitmap(sprite, frameToDraw, whereToDraw, null);
        }
     }

    public boolean isCollition(float x2, float y2) {
        return x2 > x && x2 < x + frameWidth && y2 > y && y2 < y + frameHeight;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }

    public GameView getContext() {
        return context;
    }
}
