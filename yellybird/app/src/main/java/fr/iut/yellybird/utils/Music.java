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


/**
 * The type Music.
 */
public class Music {
    private static MediaPlayer fly;
    private static MediaPlayer crash;
    private static MediaPlayer score;

    /**
     * Play fly.
     *
     * @param context the context
     */
    public static void playFly(Context context) {
        fly = MediaPlayer.create(context,R.raw.fly);
        fly.start();
    }

    /**
     * Play crash.
     *
     * @param context the context
     */
    public static void playCrash(Context context) {
        crash = MediaPlayer.create(context,R.raw.crash);
        crash.start();
    }

    /**
     * Play score.
     *
     * @param context the context
     */
    public static void playScore(Context context) {
        score = MediaPlayer.create(context,R.raw.score);
        score.start();
    }
}
