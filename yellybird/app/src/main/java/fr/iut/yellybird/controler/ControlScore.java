package fr.iut.yellybird.controler;

import android.content.Context;

import fr.iut.yellybird.R;
import fr.iut.yellybird.models.Score;
import fr.iut.yellybird.utils.Serializer;

/**
 * The type Control score.
 */
public class ControlScore {
    /**
     * Save.
     *
     * @param score   the score
     * @param context the context
     */
    public static void save(Score score, Context context)
    {
        score.initScore();
        Serializer.serialize(context.getResources().getString(R.string.score),score,context);
    }

    /**
     * Load score.
     *
     * @param context the context
     * @return the score
     */
    public static Score load(Context context)
    {
        Score score;
        try {

            score = (Score) Serializer.deserialize(context.getResources().getString(R.string.score), context);
            if(score == null)
            {
                score = new Score();
            }
            score.initScore();
            return score;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
