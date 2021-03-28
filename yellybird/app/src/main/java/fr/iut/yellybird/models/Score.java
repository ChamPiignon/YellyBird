package fr.iut.yellybird.models;

import java.io.Serializable;

/**
 * The type Score.
 */
public class Score implements Serializable {
    private int score;
    private int bestScore;

    /**
     * Instantiates a new Score.
     */
    public Score() {
        this.score = 0;
        this.bestScore = 0;
    }

    /**
     * Add point.
     */
    public void addPoint()
    {
        score+=1;
        if(bestScore<=score)
            bestScore=score;
    }

    /**
     * Init score.
     */
    public void initScore()
    {
        score=0;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets best score.
     *
     * @return the best score
     */
    public int getBestScore() {
        return bestScore;
    }
}
