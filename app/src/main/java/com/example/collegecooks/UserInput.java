package com.example.collegecooks;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class UserInput extends AppCompatActivity {

    private static final String TAG = "UserInput";
    

    @Override
    //Opens the user input activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
    }

    //class run when the submit button is pressed
    public void submit(View v){
        //only runs if checks and ingChecks passes
        if(checks() && ingChecks()){
            TextView nameView = findViewById(R.id.recipeNameInput);
            String name = nameView.getText().toString();

            TextView timeView = findViewById(R.id.recipeTimeInput);
            int time = Integer.parseInt(timeView.getText().toString());

            TextView directionsView = findViewById(R.id.recipeDirectionsInput);
            String directions = directionsView.getText().toString();

//        TextView appliancesView = findViewById(R.id.recipeAppliancesInput);
//        String appliances = appliancesView.getText().toString();

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
            String measure2 = measureView2.getText().toString();

            //        TextView isMajor = findViewById(); --> adding eventually

            TextView ingredNameView2 = findViewById(R.id.recipeIngredNameInput2);
            String ingredName2 = ingredNameView2.getText().toString();


            Ingredient one = new Ingredient(denom1, measure1, true, ingredName1);
            Ingredient two = new Ingredient(denom2, measure2, true, ingredName2);
            stuff.add(one);
            stuff.add(two);

//      Ingredient 3
            TextView denomination3 = findViewById(R.id.recipeDenomInput3);
            TextView measureView3 = findViewById(R.id.recipeMeasureInput3);
            TextView ingredNameView3 = findViewById(R.id.recipeIngredNameInput3);
            if(!TextUtils.isEmpty(denomination3.getText()) && !TextUtils.isEmpty(measureView3.getText()) && !TextUtils.isEmpty(ingredNameView3.getText())){
                String den3 = denomination3.getText().toString();
                int denom3 = Integer.parseInt(den3);
                String measure3 = measureView3.getText().toString();
                String ingredName3 = ingredNameView3.getText().toString();
                Ingredient three = new Ingredient(denom3, measure3,true, ingredName3);
                stuff.add(three);
            }


//      Ingredient 4
            TextView denomination4 = findViewById(R.id.recipeDenomInput4);
            TextView measureView4 = findViewById(R.id.recipeMeasureInput4);
            TextView ingredNameView4 = findViewById(R.id.recipeIngredNameInput4);
            if(!TextUtils.isEmpty(denomination4.getText()) && !TextUtils.isEmpty(measureView4.getText()) && !TextUtils.isEmpty(ingredNameView4.getText())){
                String den4 = denomination4.getText().toString();
                int denom4 = Integer.parseInt(den4);
                String measure4 = measureView4.getText().toString();
                String ingredName4 = ingredNameView4.getText().toString();
                Ingredient four = new Ingredient(denom4, measure4,true, ingredName4);
                stuff.add(four);
            }


//      Ingredient 5
            TextView denomination5 = findViewById(R.id.recipeDenomInput5);
            TextView measureView5 = findViewById(R.id.recipeMeasureInput5);
            TextView ingredNameView5 = findViewById(R.id.recipeIngredNameInput5);
            if(!TextUtils.isEmpty(denomination5.getText()) && !TextUtils.isEmpty(measureView5.getText()) && !TextUtils.isEmpty(ingredNameView5.getText())){
                String den5 = denomination4.getText().toString();
                int denom5 = Integer.parseInt(den5);
                String measure5 = measureView5.getText().toString();
                String ingredName5 = ingredNameView5.getText().toString();
                Ingredient five = new Ingredient(denom5, measure5,true, ingredName5);
                stuff.add(five);
            }

            Recipe recipe = new Recipe(stuff, time, directions, name);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("recipes");
            myRef.child(recipe.getName().replace(" ", "")).setValue(recipe);

            Toast.makeText(this, name + " has been added to the database!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, RecipeView.class);
            startActivity(intent);
        }
    }

    //Checks if there are any problems with the entered information
    public boolean checks(){
        boolean a = true;

        TextView nameView = findViewById(R.id.recipeNameInput);
        if(TextUtils.isEmpty(nameView.getText())) {
            Toast.makeText(this, "A recipe name is required", Toast.LENGTH_LONG).show();
            a = false;
        }

        TextView timeView = findViewById(R.id.recipeTimeInput);
        if(TextUtils.isEmpty(timeView.getText())) {
            Toast.makeText(this, "A time is required!", Toast.LENGTH_LONG).show();
            a = false;
        }

        TextView directionsView = findViewById(R.id.recipeDirectionsInput);
        if(TextUtils.isEmpty(directionsView.getText())) {
            Toast.makeText(this, "Directions are required!", Toast.LENGTH_LONG).show();
            a = false;
        }

        //      Ingredient 1
        TextView denomination1 = findViewById(R.id.recipeDenomInput1);
        TextView measureView1 = findViewById(R.id.recipeMeasureInput1);
        TextView ingredNameView1 = findViewById(R.id.recipeIngredNameInput1);
        if(TextUtils.isEmpty(denomination1.getText()) || TextUtils.isEmpty(measureView1.getText()) || TextUtils.isEmpty(ingredNameView1.getText())) {
            Toast.makeText(this, "All information for this mandatory ingredient is required", Toast.LENGTH_LONG).show();
            a = false;
        }

        //      Ingredient 2
        TextView denomination2 = findViewById(R.id.recipeDenomInput2);
        TextView measureView2 = findViewById(R.id.recipeMeasureInput2);
        TextView ingredNameView2 = findViewById(R.id.recipeIngredNameInput2);
        if(TextUtils.isEmpty(denomination2.getText()) || TextUtils.isEmpty(measureView2.getText()) || TextUtils.isEmpty(ingredNameView2.getText())) {
            Toast.makeText(this, "All information for this mandatory ingredient is required", Toast.LENGTH_LONG).show();
            a = false;
        }

        return a;
    }

    //Checks if there are any problems with the ingredients
    public boolean ingChecks(){
        boolean a = true;
        //      Ingredient 3
        TextView denomination3 = findViewById(R.id.recipeDenomInput3);
        TextView measureView3 = findViewById(R.id.recipeMeasureInput3);
        TextView ingredNameView3 = findViewById(R.id.recipeIngredNameInput3);
        if(TextUtils.isEmpty(denomination3.getText()) && (!TextUtils.isEmpty(measureView3.getText()) || !TextUtils.isEmpty(ingredNameView3.getText()))){
            Toast.makeText(this, "All information for this ingredient is required", Toast.LENGTH_LONG).show();
            a = false;
        }
        else if(TextUtils.isEmpty(measureView3.getText()) && (!TextUtils.isEmpty(denomination3.getText()) || !TextUtils.isEmpty(ingredNameView3.getText()))){
            Toast.makeText(this, "All information for this ingredient is required", Toast.LENGTH_LONG).show();
            a = false;
        }
        else if(TextUtils.isEmpty(ingredNameView3.getText()) && (!TextUtils.isEmpty(denomination3.getText()) || !TextUtils.isEmpty(measureView3.getText()))){
            Toast.makeText(this, "All information for this ingredient is required", Toast.LENGTH_LONG).show();
            a = false;
        }

//      Ingredient 4
        TextView denomination4 = findViewById(R.id.recipeDenomInput4);
        TextView measureView4 = findViewById(R.id.recipeMeasureInput4);
        TextView ingredNameView4 = findViewById(R.id.recipeIngredNameInput4);
        if(TextUtils.isEmpty(denomination4.getText()) && (!TextUtils.isEmpty(measureView4.getText()) || !TextUtils.isEmpty(ingredNameView4.getText()))){
            Toast.makeText(this, "All information for this ingredient is required", Toast.LENGTH_LONG).show();
            a = false;
        }
        else if(TextUtils.isEmpty(measureView4.getText()) && (!TextUtils.isEmpty(denomination4.getText()) || !TextUtils.isEmpty(ingredNameView4.getText()))){
            Toast.makeText(this, "All information for this ingredient is required", Toast.LENGTH_LONG).show();
            a = false;
        }
        else if(TextUtils.isEmpty(ingredNameView4.getText()) && (!TextUtils.isEmpty(denomination4.getText()) || !TextUtils.isEmpty(measureView4.getText()))){
            Toast.makeText(this, "All information for this ingredient is required", Toast.LENGTH_LONG).show();
            a = false;
        }

//      Ingredient 5
        TextView denomination5 = findViewById(R.id.recipeDenomInput5);
        TextView measureView5 = findViewById(R.id.recipeMeasureInput5);
        TextView ingredNameView5 = findViewById(R.id.recipeIngredNameInput5);
        if(TextUtils.isEmpty(denomination5.getText()) && (!TextUtils.isEmpty(measureView5.getText()) || !TextUtils.isEmpty(ingredNameView5.getText()))){
            Toast.makeText(this, "All information for this ingredient is required", Toast.LENGTH_LONG).show();
            a = false;
        }
        else if(TextUtils.isEmpty(measureView5.getText()) && (!TextUtils.isEmpty(denomination5.getText()) || !TextUtils.isEmpty(ingredNameView5.getText()))){
            Toast.makeText(this, "All information for this ingredient is required", Toast.LENGTH_LONG).show();
            a = false;
        }
        else if(TextUtils.isEmpty(ingredNameView5.getText()) && (!TextUtils.isEmpty(denomination5.getText()) || !TextUtils.isEmpty(measureView5.getText()))){
            Toast.makeText(this, "All information for this ingredient is required", Toast.LENGTH_LONG).show();
            a = false;
        }

        return a;
    }


}
