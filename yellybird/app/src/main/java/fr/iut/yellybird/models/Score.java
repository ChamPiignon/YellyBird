package fr.iut.yellybird.models;

import java.io.Serializable;

public class Score implements Serializable {
    int score=0;
    int bestScore=0;

    public void addpoint()
    {
        score+=1;
        if(bestScore<=score)
            bestScore=score;
    }

    public void init()
    {
        int score=0;
    }

}
