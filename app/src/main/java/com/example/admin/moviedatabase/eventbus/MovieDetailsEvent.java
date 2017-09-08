package com.example.admin.moviedatabase.eventbus;

import com.example.admin.moviedatabase.model.DetailsMovie;
import com.example.admin.moviedatabase.model.Result;

import java.util.List;

/**
 * Created by Admin on 9/8/2017.
 */

public class MovieDetailsEvent {

    public final DetailsMovie details;

    public MovieDetailsEvent(DetailsMovie details) {
        this.details = details;
    }

    public DetailsMovie getDetails() {
        return details;
    }
}
