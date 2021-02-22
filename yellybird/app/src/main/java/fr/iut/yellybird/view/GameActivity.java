package fr.iut.yellybird.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fr.iut.yellybird.Game.Game;
import fr.iut.yellybird.R;
import fr.iut.yellybird.Sprite.SpriteAnimation;

public class GameActivity extends AppCompatActivity {

    private Game game;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = new Game(this);
        setContentView(game);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        game.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        sprite.pause();
    }
}