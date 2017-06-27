package com.example.davidguajardoosorio.marveljava.model.implementation;

import com.example.davidguajardoosorio.marveljava.model.Connection;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by davidguajardoosorio on 24-06-17.
 */

public interface IConnection {
    @GET("v1/public/comics?ts=1&apikey=c52de2a3fd7e09c777ff27a08af428d3&hash=f1f1f38d77aee4c6c86999191be0c876")
    Call<Connection> getConnection();
}
