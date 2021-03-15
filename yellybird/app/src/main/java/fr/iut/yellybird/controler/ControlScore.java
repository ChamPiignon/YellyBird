package fr.iut.yellybird.controler;

import android.content.Context;

import fr.iut.yellybird.models.Score;
import fr.iut.yellybird.utils.Serializer;

public class ControlScore {
    private final static String FILENAME = "score";

    public void save(Score score,Context context)
    {
        Serializer.serialize(FILENAME,score,context);
    }

    public static Score load(Context context)
    {
        Score score;
        try {

            score = (Score) Serializer.deserialize(FILENAME, context);
            if(score == null)
            {
                score = new Score();
            }
            return score;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
