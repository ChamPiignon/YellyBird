package fr.iut.yellybird.Game;

public class GameThread  extends Thread {
    static final long FPS = 60;
    private GameView view;
    private boolean running = false;


    public GameThread(GameView view) { this.view = view; }

    public void setRunning(boolean run) {
        running = run;
    }

    @Override
    public void run() {
        long ticksPS = 1000 / FPS;
        long startTime = 0;
        long sleepTime;
        while (running) {
            startTime = System.currentTimeMillis();
                synchronized (view.getHolder()) {
                    view.draw();
                    if(!view.isGameOver()){
                        view.move();
                    }
                }
            }
            sleepTime = ticksPS - (System.currentTimeMillis() - startTime);
            try {
                if (sleepTime > 0)
                    sleep(sleepTime);
                else
                    sleep(10);
            } catch (Exception e) {}
        }
    }
