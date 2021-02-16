package fr.iut.yellybird.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fr.iut.yellybird.R;
import fr.iut.yellybird.Sprite.SpriteAnimation;

public class GameActivity extends AppCompatActivity {

    private SpriteAnimation sprite;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sprite= new SpriteAnimation(this,R.drawable.yellow,3,36*4,26*4);
        setContentView(sprite);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sprite.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        sprite.pause();
    }
}