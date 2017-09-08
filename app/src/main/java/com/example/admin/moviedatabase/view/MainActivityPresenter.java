package com.example.admin.moviedatabase.view;

/**
 * Created by Admin on 9/8/2017.
 */

public class MainActivityPresenter implements MainActivityContract.presenter {

    MainActivityContract.view view;

    public void attachView(MainActivityContract.view view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
