package com.example.davidguajardoosorio.marveljava.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidguajardoosorio.marveljava.R;
import com.example.davidguajardoosorio.marveljava.model.Result;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by davidguajardoosorio on 25-06-17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private ArrayList<Result> results;
    private int layout;
    private Context context;

    public MyAdapter(ArrayList<Result> results, int layout) {
        this.results = results;
        this.layout = layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);
        context = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bind(results.get(i));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageComic;
        public TextView lblTitleComic;

        public ViewHolder(View itemView) {
            super(itemView);

            imageComic = (ImageView)itemView.findViewById(R.id.imageComic);
            lblTitleComic = (TextView)itemView.findViewById(R.id.lblTitleComic);
        }

        public void bind(final Result result) {
            Log.d("BIND", "PASO POR ACÁ");
            Picasso.with(context).load(result.getThumbnail().getPath()).fit().centerCrop().into(imageComic);
            lblTitleComic.setText(result.getTitle());
        }
    }

}
