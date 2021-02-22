package fr.iut.yellybird.Game;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

import android.view.SurfaceView;

import fr.iut.yellybird.R;
import fr.iut.yellybird.Sprite.BirdSpriteAnimation;
import fr.iut.yellybird.Sprite.SpriteAnimation;

public class Game extends SurfaceView {
    private SurfaceHolder holder;
    private GameThread gameThread;
    private BirdSpriteAnimation bird;
    private MediaRecorder microphone;
    private int score;
    private long lastClick=0;
    private int birdSprite = R.drawable.yellow;

    public Game(Context context) {
        super(context);
        gameThread = new GameThread(this);
        holder = getHolder();
        holder.addCallback(new Callback() {

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                initSprites(birdSprite);
                gameThread.setRunning(true);
                gameThread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }
        });
    }

    private void initSprites(int sprite) {
        bird = new BirdSpriteAnimation(this, sprite, 3, 36, 26,4,10);
    }

    public void draw() {
            bird.draw();
    }

    public boolean isDead(int xPipe,int yPipe)
    {
        if(bird.isCollition(xPipe,yPipe) || bird.isOnTheFloor)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (System.currentTimeMillis() - lastClick > 300) {
            lastClick = System.currentTimeMillis();
            synchronized (getHolder()) {
//                bird.fly();
            }

        }

        return true;

    }
}

