package fr.iut.yellybird.Game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import androidx.core.content.res.ResourcesCompat;

import java.util.Random;

import fr.iut.yellybird.R;
import fr.iut.yellybird.Sprite.BackgroundSprite;
import fr.iut.yellybird.Sprite.BirdSpriteAnimation;
import fr.iut.yellybird.Sprite.FloorSprite;
import fr.iut.yellybird.Sprite.PipeSprite;

public class GameView extends SurfaceView {
    private SurfaceHolder holder;
    private GameThread gameThread;
    private BirdSpriteAnimation bird;
    private PipeSprite pipes;
    private FloorSprite floor;
    private BackgroundSprite bg;
    private SoundMeter microphone;
    private int score=0;
    private long lastClick=0;
    private int[] birdSprite={R.drawable.yellow, R.drawable.red , R.drawable.blue};
    public boolean gameOver = false;

    private Canvas canvas;

    public GameView(Context context) {
        super(context);
        gameThread = new GameThread(this);
        holder = getHolder();
        holder.addCallback(new Callback() {

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                initSprites();
                setCollision();
                gameThread.setRunning(true);
                gameThread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }
        });
    }

    private void initSprites() {
        bird = new BirdSpriteAnimation(this, birdSprite[new Random().nextInt(birdSprite.length)], 3, 36, 26,4,10);
        pipes = new PipeSprite(this,R.drawable.bottom_pipe,R.drawable.top_pipe);
        floor = new FloorSprite(this,R.drawable.base);
        bg = new BackgroundSprite(this,R.drawable.background);
    }

    private void setCollision()
    {
        bird.setFloorHeight(floor.getFloor().getHeight());
    }

    public void draw() {
        canvas = this.getHolder().lockCanvas();
        canvas.drawColor(Color.WHITE);
        bg.draw(canvas);
        pipes.draw(canvas);
        bird.draw(canvas);
        floor.draw(canvas);
        this.score();
        this.getHolder().unlockCanvasAndPost(canvas);
    }

    public void move() {
        pipes.moveX();
    }

    public boolean isGameOver()
    {
        if(bird.isOnTheFloor||gameOver||pipes.getWhereToDrawB().intersect(bird.getWhereToDraw())|| pipes.getWhereToDrawT().intersect(bird.getWhereToDraw()))
        {
            gameOver=true;
            return gameOver;
        }
        return false;
    }


    public void addPoint()
    {
        if(!bird.isOnTheFloor&&!gameOver&&!pipes.getWhereToDrawB().intersect(bird.getWhereToDraw())&& !pipes.getWhereToDrawT().intersect(bird.getWhereToDraw())&&pipes.getWhereToDrawB().right<=bird.x)
            score=score+1;
    }

    private void score()
    {
        int width = this.getWidth()/2;
        int height = this.getHeight()/11;
        TextPaint paint = new TextPaint();
        paint.setTypeface(ResourcesCompat.getFont(getContext(),R.font.yelly_font));
        paint.setColor(Color.BLACK);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(200f);
        canvas.drawText(" "+score,width,height,paint);
        paint.setTypeface(ResourcesCompat.getFont(getContext(),R.font.yelly_fill_font));
        paint.setColor(Color.WHITE);
        canvas.drawText(" "+score,width,height,paint);
    }



    //A supprimer
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (System.currentTimeMillis() - lastClick > 200) {
            lastClick = System.currentTimeMillis();
            synchronized (getHolder()) {
                if(!gameOver)
                {
                    bird.fly();
                }

            }

        }
     return true;
    }


}

