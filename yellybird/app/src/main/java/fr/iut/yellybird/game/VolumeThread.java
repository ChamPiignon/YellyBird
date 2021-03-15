package fr.iut.yellybird.game;


import fr.iut.yellybird.game.GameView;
import fr.iut.yellybird.models.SoundMeter;

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
