package com.interfaces;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements HitToServer{

    String response = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new getRequestAsync(MainActivity.this).execute();
    }

    @Override
    public String setParams() {
        return "http://www.omdbapi.com/?t=Game%20of%20Thrones&Season=1&Episode=1";
    }

    @Override
    public void onSuccess(String result) {
        this.response = result;
        System.out.println(result);
        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String onFailure() {
        System.out.println("onFailure() called from MainActivity");
        Toast.makeText(MainActivity.this, "Could not connect to server", Toast.LENGTH_SHORT).show();
        return null;
    }
}
