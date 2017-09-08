package com.example.admin.moviedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.moviedatabase.view.MainActivityContract;

public class MainActivity extends AppCompatActivity implements MainActivityContract.view{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showError(String error) {

    }
}
