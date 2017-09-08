package com.example.admin.moviedatabase;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.moviedatabase.adapter.MovieAdapter;
import com.example.admin.moviedatabase.eventbus.MovieDetailsEvent;
import com.example.admin.moviedatabase.eventbus.MovieSearchEvent;
import com.example.admin.moviedatabase.inject.DaggerMainActivityComponent;
import com.example.admin.moviedatabase.view.MainActivityContract;
import com.example.admin.moviedatabase.view.MainActivityPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityContract.view {

    @Inject
    MainActivityPresenter presenter;
    @BindView(R.id.etSearchQuery)
    AppCompatEditText etSearchQuery;
    @BindView(R.id.rvMovieList)
    RecyclerView rvMovieList;

    MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerMainActivityComponent.create().inject(this);
        presenter.attachView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public void showError(String error) {

    }

    @OnClick(R.id.btnSearch)
    public void onViewClicked() {

        if (etSearchQuery.getText().length() > 0) {
            presenter.loadMovies(etSearchQuery.getText().toString());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    @Override
    public void loadMovieListInReyclerView(MovieSearchEvent movieResults) {

        rvMovieList.setLayoutManager(new LinearLayoutManager(this));
        rvMovieList.setItemAnimator(new DefaultItemAnimator());
        movieAdapter = new MovieAdapter(movieResults.getResults());
        rvMovieList.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    @Override
    public void loadDetailsForCurrentSelectedMovie(MovieDetailsEvent movieDetailsEvent) {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.movie_details_dialog);
        dialog.setTitle(movieDetailsEvent.getDetails().getTitle());

        AppCompatTextView tvOverview = dialog.findViewById(R.id.tvOverview);
        tvOverview.setText(movieDetailsEvent.getDetails().getOverview());

        dialog.show();

    }


}
