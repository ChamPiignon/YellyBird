package fr.iut.yellybird.Sprite;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

import fr.iut.yellybird.Game.GameView;

public class BackgroundSprite implements Sprite {
    private Bitmap sprite;
    private SurfaceHolder ourHolder;

    public BackgroundSprite(GameView context, int ressourceId) {
        ourHolder = context.getHolder();
        Bitmap background = BitmapFactory.decodeResource(context.getResources(), ressourceId);
        sprite = Bitmap.createScaledBitmap(background, context.getWidth(), context.getHeight(), true);
    }

    @Override
    public void draw(Canvas canvas) {
        if (ourHolder.getSurface().isValid()) {
            canvas.drawBitmap(sprite, 0, 0, null);
        }
    }
}
