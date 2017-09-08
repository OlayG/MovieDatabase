package com.example.admin.moviedatabase.view;

import android.util.Log;

import com.example.admin.moviedatabase.eventbus.MovieDetailsEvent;
import com.example.admin.moviedatabase.eventbus.MovieSearchEvent;
import com.example.admin.moviedatabase.model.DetailsMovie;
import com.example.admin.moviedatabase.model.SearchMovie;
import com.example.admin.moviedatabase.retrofit.RetrofitHelper;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Admin on 9/8/2017.
 */

public class MainActivityPresenter implements MainActivityContract.presenter {

    private static final String TAG = "MainActivityPresenter";
    MainActivityContract.view view;

    public void attachView(MainActivityContract.view view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void loadMovies(String movieTitle) {
        retrofit2.Call<SearchMovie> movieCall = RetrofitHelper.callMovieList(movieTitle);
        movieCall.enqueue(new retrofit2.Callback<SearchMovie>() {
            @Override
            public void onResponse(Call<SearchMovie> call, Response<SearchMovie> response) {
                EventBus.getDefault().post(new MovieSearchEvent(response.body().getResults()));
            }

            @Override
            public void onFailure(Call<SearchMovie> call, Throwable t) {

            }
        });
    }

    @Override
    public void fetchDetails(String movieId) {
        retrofit2.Call<DetailsMovie> detailsCall = RetrofitHelper.callMovieDetails(movieId);
        detailsCall.enqueue(new retrofit2.Callback<DetailsMovie>() {
            @Override
            public void onResponse(Call<DetailsMovie> call, Response<DetailsMovie> response) {
                Log.d(TAG, "onResponse: " + response.body().toString());
                EventBus.getDefault().post(new MovieDetailsEvent(response.body()));
            }

            @Override
            public void onFailure(Call<DetailsMovie> call, Throwable t) {

            }
        });
    }
}
