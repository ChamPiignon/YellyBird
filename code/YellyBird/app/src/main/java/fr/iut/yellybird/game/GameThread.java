package fr.iut.yellybird.game;
import fr.iut.yellybird.models.SoundMeter;

/**
 * The type Game thread.
 */
public class GameThread extends Thread {
    /**
     * The Fps.
     */
    static final long FPS = 100;
    private GameView view;
    private SoundMeter micro;
    private boolean running = false;

    /**
     * Instantiates a new Game thread.
     *
     * @param view the view
     */
    public GameThread(GameView view) {
        this.view = view;
        this.micro = new SoundMeter();
    }

    /**
     * Sets running.
     *
     * @param run the run
     */
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
        while (running) {
            startTime = System.currentTimeMillis();
            view.draw();
            view.addPoint();
            if (!view.isGameOver()) {
                view.move();
            }
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