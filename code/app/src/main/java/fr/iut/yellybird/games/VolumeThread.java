package fr.iut.yellybird.Game;

import android.util.Log;

public class VolumeThread extends Thread{
    private GameView gameView;
    private SoundMeter micro;
    private boolean running = false;

    public VolumeThread(GameView gameView){
        this.gameView = gameView;
        this.micro = new SoundMeter();
    }

    public void setRunning(boolean run) {
        running = run;
        if(run) micro.start();
        else micro.stop();
    }

    @Override
    public void run() {
        while (running) {

        }
    }
}
