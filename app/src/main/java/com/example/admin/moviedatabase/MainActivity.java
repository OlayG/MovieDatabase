package com.example.admin.moviedatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;

import com.example.admin.moviedatabase.inject.DaggerMainActivityComponent;
import com.example.admin.moviedatabase.view.MainActivityContract;
import com.example.admin.moviedatabase.view.MainActivityPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityContract.view {

    @Inject
    MainActivityPresenter presenter;
    @BindView(R.id.etSearchQuery)
    AppCompatEditText etSearchQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerMainActivityComponent.create().inject(this);
        presenter.attachView(this);
    }

    @Override
    public void showError(String error) {

    }

    @OnClick(R.id.btnSearch)
    public void onViewClicked() {

        if(etSearchQuery.getText().length() > 0){
            presenter.loadMovies(etSearchQuery.getText().toString());
        }
    }
}
