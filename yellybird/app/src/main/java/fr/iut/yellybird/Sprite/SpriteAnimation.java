package fr.iut.yellybird.Sprite;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



public class SpriteAnimation extends SurfaceView implements Runnable {

        private Thread gameThread;
        private SurfaceHolder ourHolder;
        private volatile boolean playing;
        private Canvas canvas;
        private Bitmap sprite;
        private float manXPos = 10, manYPos = 10;
        private int frameWidth = 26, frameHeight = 36;
        private int frameCount = 3;
        private int currentFrame = 0;
        private long fps;
        private long timeThisFrame;
        private long lastFrameChangeTime = 0;
        private int frameLengthInMillisecond = 150;

        private Rect frameToDraw = new Rect(0, 0, frameWidth, frameHeight);

        private RectF whereToDraw = new RectF(manXPos, manYPos, manXPos + frameWidth, frameHeight);

        public SpriteAnimation(Context context,int ressourceId, int nbFrame) {
            super(context);
            ourHolder = getHolder();
            frameCount = nbFrame;
            sprite = BitmapFactory.decodeResource(getResources(), ressourceId);
            sprite = Bitmap.createScaledBitmap(sprite, frameWidth * frameCount, frameHeight, false);
        }

        @Override
        public void run() {
            while (playing) {
                long startFrameTime = System.currentTimeMillis();
                draw();

                timeThisFrame = System.currentTimeMillis() - startFrameTime;

                if (timeThisFrame >= 1) {
                    fps = 1000 / timeThisFrame;
                }
            }
        }

        public void manageCurrentFrame() {
            long time = System.currentTimeMillis();
            if (time > lastFrameChangeTime + frameLengthInMillisecond) {
                    lastFrameChangeTime = time;
                    currentFrame++;

                    if (currentFrame >= frameCount) {
                        currentFrame = 0;
                    }
                }

            frameToDraw.left = currentFrame * frameWidth;
            frameToDraw.right = frameToDraw.left + frameWidth;
        }

        public void draw() {
            if (ourHolder.getSurface().isValid()) {
                canvas = ourHolder.lockCanvas();
                canvas.drawColor(Color.WHITE);
                whereToDraw.set((int) manXPos, (int) manYPos, (int) manXPos + frameWidth, (int) manYPos + frameHeight);
                manageCurrentFrame();
                canvas.drawBitmap(sprite, frameToDraw, whereToDraw, null);
                ourHolder.unlockCanvasAndPost(canvas);
            }
        }

        public void pause() {
            playing = false;

            try {
                gameThread.join();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void resume() {
            playing = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
}
