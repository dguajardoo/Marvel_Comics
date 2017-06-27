package com.example.davidguajardoosorio.marveljava.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.davidguajardoosorio.marveljava.R;
import com.example.davidguajardoosorio.marveljava.adapter.MyAdapter;
import com.example.davidguajardoosorio.marveljava.controller.MarvelController;
import com.example.davidguajardoosorio.marveljava.model.Connection;
import com.example.davidguajardoosorio.marveljava.model.Data;
import com.example.davidguajardoosorio.marveljava.model.Result;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        //MarvelController marvelController = new MarvelController();
        LoadAdapter();
    }

    private void LoadAdapter() {
        new MarvelController(recyclerView, progressBar, layoutManager, R.layout.recycler_view_item).execute();
    }
}
