package fr.iut.yellybird.controler;

import android.content.Context;

import fr.iut.yellybird.R;
import fr.iut.yellybird.models.Score;
import fr.iut.yellybird.utils.Serializer;

public class ControlScore {
    public static void save(Score score, Context context)
    {
        score.init();
        Serializer.serialize(context.getResources().getString(R.string.score),score,context);
    }

    public static Score load(Context context)
    {
        Score score;
        try {

            score = (Score) Serializer.deserialize(context.getResources().getString(R.string.score), context);
            if(score == null)
            {
                score = new Score();
            }
            score.init();
            return score;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
