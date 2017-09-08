package com.example.admin.moviedatabase.inject;

import com.example.admin.moviedatabase.view.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 9/8/2017.
 */
@Module
class MainActivityModule {

    @Provides
    MainActivityPresenter providesMainActivityPresenter(){
        return new MainActivityPresenter();
    }
}
