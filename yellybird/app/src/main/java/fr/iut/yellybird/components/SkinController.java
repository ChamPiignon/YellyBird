package fr.iut.yellybird.components;

import java.util.LinkedList;
import java.util.List;

public class SkinController {
    private final List<ISkin> skins = new LinkedList<>();
    private ISkin selectedSkin;

    public SkinController(){
        skins.add(new DefaultSkin());
        selectedSkin = skins.get(0);
    }

    public ISkin getSelectedSkin() {
        return selectedSkin;
    }

    public void setSelectedSkin(ISkin selectedSkin) {
        this.selectedSkin = selectedSkin;
    }
}
