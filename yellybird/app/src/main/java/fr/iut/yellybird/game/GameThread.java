package fr.iut.yellybird.game;
import fr.iut.yellybird.models.SoundMeter;

public class GameThread extends Thread {
    static final long FPS = 60;
    private GameView view;
    private SoundMeter micro;
    private boolean running = false;

    public GameThread(GameView view) {
        this.view = view;
        this.micro = new SoundMeter();
    }

    public void setRunning(boolean run) {
        running = run;
        if (run) micro.start();
        else micro.stop();
    }

    @Override
    public void run() {
        long ticksPS = 1000 / FPS;
        long startTime = 0;
        long sleepTime;
        long lastJump = 0;
        while (running) {
            startTime = System.currentTimeMillis();

            synchronized (view.getHolder()) {
                view.draw();
                view.addPoint();
                if (!view.isGameOver()) {
                    view.move();
                }
            }
            // Log.v("MicInfoService", "amplitude: " + micro.getAmplitude()); // makes laggy
            /*if ( System.currentTimeMillis() - lastJump > 1000 && micro.getAmplitude() > 3000 ) {
                System.out.println("ENOUGH");
                lastJump = System.currentTimeMillis();
                view.getBird().fly();
            }*/

            sleepTime = ticksPS - (System.currentTimeMillis() - startTime);
            try {
                if (sleepTime > 0)
                    sleep(sleepTime);
                else
                    sleep(10);
            } catch (Exception e) {
            }
        }
    }
}
