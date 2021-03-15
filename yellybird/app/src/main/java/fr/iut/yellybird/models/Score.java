package fr.iut.yellybird.models;

import java.io.Serializable;

public class Score implements Serializable {
    private int score;
    private int bestScore;

    public Score() {
        this.score = 0;
        this.bestScore = 0;
    }

    public void addPoint()
    {
        score+=1;
        if(bestScore<=score)
            bestScore=score;
    }

    public void initScore()
    {
        score=0;
    }

    public int getScore() {
        return score;
    }

    public int getBestScore() {
        return bestScore;
    }
}
