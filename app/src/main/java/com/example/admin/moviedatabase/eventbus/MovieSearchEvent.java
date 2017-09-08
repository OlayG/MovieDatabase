package com.example.admin.moviedatabase.eventbus;

import com.example.admin.moviedatabase.model.Result;

import java.util.List;

/**
 * Created by Admin on 9/8/2017.
 */

public class MovieSearchEvent {

    public final List<Result> results;

    public MovieSearchEvent(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }
}
