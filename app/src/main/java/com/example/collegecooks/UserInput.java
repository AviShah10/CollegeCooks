package com.example.collegecooks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class UserInput extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
    }

    public void submit(){

        TextView name = findViewById(R.id.recipeNameInput);
        TextView time = findViewById(R.id.recipeTimeInput);
        TextView directions = findViewById(R.id.recipeDirectionsInput);
        TextView appliances = findViewById(R.id.recipeAppliancesInput);

        ArrayList<Ingredient> stuff = new ArrayList<>();

        TextView denomination = findViewById(R.id.recipeDenomInput);
        String den = denomination.getText().toString();
        int denom = Integer.parseInt(den);

        TextView measureView = findViewById(R.id.recipeMeasureInput);
        String measure = measureView.getText().toString();

//        TextView isMajor = findViewById();

        TextView ingredNameView = findViewById(R.id.recipeIngredNameInput);
        String ingredName = ingredNameView.getText().toString();

        Ingredient first = new Ingredient(denom, measure, ingredName);

        stuff.add(first);

        Recipe one = new Recipe(, time, directions, appliances, name);
    }

}
