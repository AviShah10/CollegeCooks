package com.example.collegecooks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
//Hello, this is Joel

    //this is Lauren
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void welcome() {
        Intent intent = new Intent(this, FirstDownloadScreen.class);
        startActivity(intent);
    }
}
