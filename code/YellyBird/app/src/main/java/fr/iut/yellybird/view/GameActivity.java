package fr.iut.yellybird.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fr.iut.yellybird.game.GameView;

/**
 * The type Game activity.
 */
public class GameActivity extends AppCompatActivity {

    private GameView gameView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        setContentView(gameView);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        gameView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        sprite.pause();
    }
}