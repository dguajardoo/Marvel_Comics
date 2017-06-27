package com.example.davidguajardoosorio.marveljava.app;

import android.app.Application;
import android.os.SystemClock;

import java.util.concurrent.TimeUnit;

/**
 * Created by davidguajardoosorio on 25-06-17.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));
    }
}
