package fr.iut.yellybird.view.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import fr.iut.yellybird.R;
import fr.iut.yellybird.view.SkinActivity;
import fr.iut.yellybird.view.adapter.SkinListAdapter;

public class SkinList extends Fragment {
    private SkinActivity myActivity;

    public SkinList(){
        super(R.layout.skin_list);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myActivity = ((SkinActivity)getContext());

        RecyclerView listView = view.findViewById(R.id.skin_list);
        listView.setLayoutManager(new LinearLayoutManager(myActivity));
        listView.setAdapter(new SkinListAdapter(myActivity.getSkins()));
    }
}
