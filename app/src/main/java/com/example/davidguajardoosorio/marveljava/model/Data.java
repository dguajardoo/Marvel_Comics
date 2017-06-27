package com.example.davidguajardoosorio.marveljava.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by davidguajardoosorio on 25-06-17.
 */

public class Data {
    private int limit;
    private int count;
    private ArrayList<Result> results;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }
}
