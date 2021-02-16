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
        public float x = 10, y = 10;
        private SurfaceHolder ourHolder;
        private boolean playing;
        private Canvas canvas;
        private Bitmap sprite;
        private int frameWidth, frameHeight;
        private final int FRAME_COUNT;
        private int currentFrame = 0;
        private long fps;
        private long timeThisFrame;
        private long lastFrameChangeTime = 0;
        private int frameLengthInMillisecond = 150;
        private Rect frameToDraw;
        private RectF whereToDraw;

        public SpriteAnimation(Context context,int ressourceId, int nbFrame,int width,int Height) {
            super(context);
            ourHolder = getHolder();
            FRAME_COUNT = nbFrame;
            frameWidth=width;
            frameHeight=Height;
            frameToDraw = new Rect(0, 0, frameWidth, frameHeight);
            whereToDraw = new RectF(x, y, x + frameWidth, frameHeight);
            sprite = BitmapFactory.decodeResource(getResources(), ressourceId);
            sprite = Bitmap.createScaledBitmap(sprite, frameWidth * FRAME_COUNT, frameHeight, false);
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

                    if (currentFrame >= FRAME_COUNT) {
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
                whereToDraw.set((int) x, (int) y, (int) x + frameWidth, (int) y + frameHeight);
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
