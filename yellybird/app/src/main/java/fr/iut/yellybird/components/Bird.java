package fr.iut.yellybird.components;

public class Bird {
    private int x, y;
    private boolean alive;
    private ISkin skin;

    public Bird(){
        x = 50;
        y = 300;
        alive = true;

    }

    public void update(int y){
        this.y += y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
