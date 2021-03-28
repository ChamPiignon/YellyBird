package fr.iut.yellybird.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.iut.yellybird.R;
import fr.iut.yellybird.view.adapter.SkinListAdapter;
import fr.iut.yellybird.view.fragments.DetailSkin;
import fr.iut.yellybird.view.fragments.Skin;

/**
 * The type Skin activity.
 */
public class SkinActivity extends AppCompatActivity {
    private Skin selectedSkin;
    private RecyclerView listView;
    private SkinListAdapter adapter;
    private List<Skin> skins;

    /**
     * Instantiates a new Skin activity.
     */
    public SkinActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listView = (RecyclerView)findViewById(R.id.skin_list);
        skins = new ArrayList<>();
        skins.add(new Skin(R.drawable.bird));
        skins.add(new Skin(R.drawable.blue));
        skins.add(new Skin(R.drawable.red));

        adapter = new SkinListAdapter(skins);
        listView.setAdapter(adapter);

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.selected_skin, DetailSkin.class, null)
                .commit();
    }

    /**
     * Sets current skin.
     *
     * @param currentSkin the current skin
     */
    public void setCurrentSkin(Skin currentSkin) {
        if (currentSkin != selectedSkin) {
            selectedSkin = currentSkin;
        }
    }

    /**
     * Gets skins.
     *
     * @return the skins
     */
    public List<Skin> getSkins() {
        return skins;
    }
}
