package com.example.collegecooks;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    public void submit(View v){

        TextView nameView = findViewById(R.id.recipeNameInput);
        String name = nameView.getText().toString();

        Log.d("UserInpt", "time here");
        TextView timeView = findViewById(R.id.recipeTimeInput);
        int time = Integer.parseInt(timeView.getText().toString());

        TextView directionsView = findViewById(R.id.recipeDirectionsInput);
        String directions = directionsView.getText().toString();

        TextView appliancesView = findViewById(R.id.recipeAppliancesInput);
        String appliances = appliancesView.getText().toString();

        ArrayList<Ingredient> stuff = new ArrayList<>();

//      Ingredient 1
        TextView denomination1 = findViewById(R.id.recipeDenomInput1);
        String den1 = denomination1.getText().toString();
        int denom1 = Integer.parseInt(den1);

        TextView measureView1 = findViewById(R.id.recipeMeasureInput1);
        String measure1 = measureView1.getText().toString();

        //        TextView isMajor = findViewById(); --> adding eventually

        TextView ingredNameView1 = findViewById(R.id.recipeIngredNameInput1);
        String ingredName1 = ingredNameView1.getText().toString();

//      Ingredient 2
        TextView denomination2 = findViewById(R.id.recipeDenomInput2);
        String den2 = denomination2.getText().toString();
        int denom2 = Integer.parseInt(den2);

        TextView measureView2 = findViewById(R.id.recipeMeasureInput2);
        String measure2 = measureView1.getText().toString();

        //        TextView isMajor = findViewById(); --> adding eventually

        TextView ingredNameView2 = findViewById(R.id.recipeIngredNameInput2);
        String ingredName2 = ingredNameView2.getText().toString();

//      Ingredient 3
        TextView denomination3 = findViewById(R.id.recipeDenomInput3);
        String den3 = denomination3.getText().toString();
        int denom3 = Integer.parseInt(den3);

        TextView measureView3 = findViewById(R.id.recipeMeasureInput3);
        String measure3 = measureView3.getText().toString();

        //        TextView isMajor = findViewById(); --> adding eventually

        TextView ingredNameView3 = findViewById(R.id.recipeIngredNameInput3);
        String ingredName3 = ingredNameView1.getText().toString();

//      Ingredient 4
        TextView denomination4 = findViewById(R.id.recipeDenomInput4);
        String den4 = denomination4.getText().toString();
        int denom4 = Integer.parseInt(den4);

        TextView measureView4 = findViewById(R.id.recipeMeasureInput4);
        String measure4 = measureView4.getText().toString();

        //        TextView isMajor = findViewById(); --> adding eventually

        TextView ingredNameView4 = findViewById(R.id.recipeIngredNameInput4);
        String ingredName4 = ingredNameView4.getText().toString();

//      Ingredient 5
        TextView denomination5 = findViewById(R.id.recipeDenomInput5);
        String den5 = denomination5.getText().toString();
        int denom5 = Integer.parseInt(den1);

        TextView measureView5 = findViewById(R.id.recipeMeasureInput5);
        String measure5 = measureView5.getText().toString();

        //        TextView isMajor = findViewById(); --> adding eventually

        TextView ingredNameView5 = findViewById(R.id.recipeIngredNameInput5);
        String ingredName5 = ingredNameView5.getText().toString();

        Ingredient one = new Ingredient(denom1, measure1, ingredName1);
        Ingredient two = new Ingredient(denom2, measure2, ingredName2);
        Ingredient three = new Ingredient(denom3, measure3, ingredName3);
        Ingredient four = new Ingredient(denom4, measure4, ingredName4);
        Ingredient five = new Ingredient(denom5, measure5, ingredName5);

        stuff.add(one);
        stuff.add(two);
        stuff.add(three);
        stuff.add(four);
        stuff.add(five);

        Recipe recipe = new Recipe(stuff, time, directions, appliances, name);
    }

}
