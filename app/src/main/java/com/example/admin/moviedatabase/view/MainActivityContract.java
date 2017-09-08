package com.example.admin.moviedatabase.view;

import com.example.admin.moviedatabase.BasePresenter;
import com.example.admin.moviedatabase.BaseView;
import com.example.admin.moviedatabase.eventbus.MovieDetailsEvent;
import com.example.admin.moviedatabase.eventbus.MovieSearchEvent;

/**
 * Created by Admin on 9/8/2017.
 */

public interface MainActivityContract {

    interface view extends BaseView {

        void loadMovieListInReyclerView(MovieSearchEvent movieSearchEvent);
        void loadDetailsForCurrentSelectedMovie(MovieDetailsEvent movieDetailsEvent);
    }

    interface presenter extends BasePresenter<view> {

        void loadMovies(String movieTitle);

        void fetchDetails(String movieId);
    }
}
