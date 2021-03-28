package fr.iut.yellybird.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.iut.yellybird.R;
import fr.iut.yellybird.view.fragments.Skin;

/**
 * The type Skin list adapter.
 */
public class SkinListAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private final List<Skin> skinList;

    /**
     * Instantiates a new Skin list adapter.
     *
     * @param skinList the skin list
     */
    public SkinListAdapter(List<Skin> skinList){
        this.skinList = skinList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_skin, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setSkin(skinList.get(position));
    }

    @Override
    public int getItemCount() {
        return skinList.size();
    }

}