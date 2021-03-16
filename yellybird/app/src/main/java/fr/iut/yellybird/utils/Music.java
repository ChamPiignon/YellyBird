package fr.iut.yellybird.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import fr.iut.yellybird.R;


public class Music {
    private static MediaPlayer fly;
    private static MediaPlayer crash;
    private static MediaPlayer score;

    public static void playFly(Context context) {
        fly = MediaPlayer.create(context,R.raw.fly);
        fly.start();
    }

    public static void playCrash(Context context) {
        crash = MediaPlayer.create(context,R.raw.crash);
        crash.start();
    }

    public static void playScore(Context context) {
        score = MediaPlayer.create(context,R.raw.score);
        score.start();
    }
}
