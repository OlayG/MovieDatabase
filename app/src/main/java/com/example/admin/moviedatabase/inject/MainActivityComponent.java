package com.example.admin.moviedatabase.inject;

import com.example.admin.moviedatabase.MainActivity;
import com.example.admin.moviedatabase.adapter.MovieAdapter;

import dagger.Component;

/**
 * Created by Admin on 9/8/2017.
 */
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(MovieAdapter movieAdapter);
}
