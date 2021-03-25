package fr.iut.yellybird.view.fragments;

import androidx.fragment.app.Fragment;

import fr.iut.yellybird.R;

public class Skin extends Fragment {
    private final int value;

    public Skin(int value) {
        super(R.layout.fragment_skin);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
