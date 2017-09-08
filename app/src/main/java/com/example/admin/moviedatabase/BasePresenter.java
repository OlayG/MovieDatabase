package com.example.admin.moviedatabase;

/**
 * Created by Admin on 9/8/2017.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);
    void detachView();
}
