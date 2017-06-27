package com.example.davidguajardoosorio.marveljava.controller;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.davidguajardoosorio.marveljava.R;
import com.example.davidguajardoosorio.marveljava.adapter.MyAdapter;
import com.example.davidguajardoosorio.marveljava.model.Connection;
import com.example.davidguajardoosorio.marveljava.model.Data;
import com.example.davidguajardoosorio.marveljava.model.Result;
import com.example.davidguajardoosorio.marveljava.model.implementation.IConnection;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by davidguajardoosorio on 25-06-17.
 */

public class MarvelController extends AsyncTask<Void, Integer, Connection> {

    private ArrayList<Result> results;
    private Connection connection;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MyAdapter myAdapter;

    private int layout;

    public MarvelController() {
        new Thread(new Runnable() {
            public void run() {
                //EnCola();
            }
        }).start();

    }

    public MarvelController(RecyclerView recyclerView, ProgressBar progressBar, RecyclerView.LayoutManager layoutManager, int layout) {
        //connection = new Connection();
        this.recyclerView = recyclerView;
        this.layoutManager = layoutManager;
        this.progressBar = progressBar;
        this.layout = layout;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.progressBar.setVisibility(View.VISIBLE);
        this.results = new ArrayList<Result>();
    }

    @Override
    protected Connection doInBackground(Void... voids) {
        //EnCola();
        Log.d("TAG", "1");
        connection = new Connection();
        Log.d("TAG", "2");
        connection = EstableceConexion();
        Log.d("TAG", "4");
        return connection;
    }

    @Override
    protected void onPostExecute(Connection connectionParam) {
        super.onPostExecute(connectionParam);
        Log.d("TAG", "5");
        myAdapter = new MyAdapter(connectionParam.getData().getResults(), layout);
        Log.d("TAG", "6");
        this.recyclerView.setLayoutManager(layoutManager);
        Log.d("TAG", "7");
        this.recyclerView.setAdapter(myAdapter);
        Log.d("TAG", "8");
        this.progressBar.setVisibility(View.GONE);
        Log.d("TAG", "9");
    }

    private Connection EstableceConexion() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gateway.marvel.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        try {
            IConnection iConnection = retrofit.create(IConnection.class);
            Call<Connection> call = iConnection.getConnection();
            Connection conn = new Connection();
            conn = call.execute().body();
            Log.d("TAG", "3");
            return conn;
        } catch (Exception e) {
            Log.d("ERROR", e.getMessage());
        }
        return new Connection();
    }

    /*
    public void EnCola(){
        EstableceConexion().enqueue(new Callback<Connection>() {
            @Override
            public void onResponse(Call<Connection> call, Response<Connection> response) {
                myAdapter = Respuesta(response);
            }

            @Override
            public void onFailure(Call<Connection> call, Throwable t) {
                Log.d("ERROR", t.getMessage());
            }
        });
    }
    */

    /*
    private MyAdapter Respuesta(Response<Connection> response) {
        switch (response.code()) {
            case 200:
                connection = response.body();
                setConnection(connection);
                Log.d("DATA", getConnection().getData().getResults().get(0).getTitle());
                return new MyAdapter(getConnection().getData().getResults(), layout);
                //view.notifyDataSetChanged(data.getResults());
            case 401:
                Log.d("ERROR", "401");
                return null;
            default:
                Log.d("ERROR", "NO SE EL ERROR");
                return null;
        }
    }
    */


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
