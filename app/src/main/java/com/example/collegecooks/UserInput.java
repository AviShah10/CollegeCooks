package com.example.collegecooks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class UserInput extends AppCompatActivity {


    Button submitButton = (Button)(findViewById(R.id.nameInput));
submitButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
      		....
		....
		....
        }
    });



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
    }

}
