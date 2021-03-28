package fr.iut.yellybird.view.adapter;

import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.iut.yellybird.R;
import fr.iut.yellybird.view.SkinActivity;
import fr.iut.yellybird.view.fragments.Skin;

/**
 * The type My view holder.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    private final ImageButton imageSkin;

    public MyViewHolder(@NonNull View viewItem){
        super(viewItem);
        imageSkin = viewItem.findViewById(R.id.fragment_skin);
    }

    public ImageButton getImageSkin(){
        return imageSkin;
    }

    public void setSkin(Skin currentSkin){
        imageSkin.setOnClickListener(v -> {
            ((SkinActivity)imageSkin.getContext()).setCurrentSkin(currentSkin);
        });
    }
}
