package com.example.collegecooks;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;

public class DropDown extends AppCompatActivity {
    private static final String TAG = "DropDown";

    ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    ArrayList<Ingredient> finalIngredients = new ArrayList<Ingredient>();
    ArrayList<CheckBox> checkBoxes = new ArrayList<CheckBox>();
    String toast;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_down);


        Ingredient ing0 = new Ingredient(1, "cup", true, "Black Beans");
        ingredients.add(ing0);
        Ingredient ing1 = new Ingredient(2, "slices", true, "Bread");
        ingredients.add(ing1);
        Ingredient ing2 = new Ingredient(1.5, "cups", true, "Cheese");
        ingredients.add(ing2);
        Ingredient ing3 = new Ingredient(1, "cup", true, "Cheese Sauce");
        ingredients.add(ing3);
        Ingredient ing4 = new Ingredient(1, "", true, "Egg");
        ingredients.add(ing4);
        Ingredient ing5 = new Ingredient(1, "cup", true, "Hot Cheetos");
        ingredients.add(ing5);
        Ingredient ing6 = new Ingredient(1, "cup", true, "Ice Cream");
        ingredients.add(ing6);
        Ingredient ing7 = new Ingredient(1, "cups", true, "Krusteaz Waffle Mix");
        ingredients.add(ing7);
        Ingredient ing8 = new Ingredient(3, "tablespoons", true, "Milk");
        ingredients.add(ing8);
        Ingredient ing9 = new Ingredient(1, "spray", true, "Non Stick Spray");
        ingredients.add(ing9);
        Ingredient ing10 = new Ingredient(2, "cups", true, "Pasta");
        ingredients.add(ing10);
        Ingredient ing11= new Ingredient(1, "", true, "Pizza");
        ingredients.add(ing11);
        Ingredient ing12 = new Ingredient(1, "", true, "Tomato");
        ingredients.add(ing12);
        Ingredient ing13 = new Ingredient(2, "", true, "Tortillas");
        ingredients.add(ing13);
        Ingredient ing14 = new Ingredient(1, "tablespoon", true, "Vegetable Oil");
        ingredients.add(ing14);
        Ingredient ing15 = new Ingredient(0.25, "cup", false, "Oil");
        ingredients.add(ing15);


        CheckBox checkBox0 = (CheckBox)findViewById(R.id.cb0);
        checkBoxes.add(checkBox0);
        checkBox0.setText(ing0.getName());
        CheckBox checkBox1 = (CheckBox)findViewById(R.id.cb1);
        checkBoxes.add(checkBox1);
        checkBox1.setText(ing1.getName());
        CheckBox checkBox2 = (CheckBox)findViewById(R.id.cb2);
        checkBoxes.add(checkBox2);
        checkBox2.setText(ing2.getName());
        CheckBox checkBox3 = (CheckBox)findViewById(R.id.cb3);
        checkBoxes.add(checkBox3);
        checkBox3.setText(ing3.getName());
        CheckBox checkBox4 = (CheckBox)findViewById(R.id.cb4);
        checkBoxes.add(checkBox4);
        checkBox4.setText(ing4.getName());
        CheckBox checkBox5 = (CheckBox)findViewById(R.id.cb5);
        checkBoxes.add(checkBox5);
        checkBox5.setText(ing5.getName());
        CheckBox checkBox6 = (CheckBox)findViewById(R.id.cb6);
        checkBoxes.add(checkBox6);
        checkBox6.setText(ing6.getName());
        CheckBox checkBox7 = (CheckBox)findViewById(R.id.cb7);
        checkBoxes.add(checkBox7);
        checkBox7.setText(ing7.getName());
        CheckBox checkBox8 = (CheckBox)findViewById(R.id.cb8);
        checkBoxes.add(checkBox8);
        checkBox8.setText(ing8.getName());
        CheckBox checkBox9 = (CheckBox)findViewById(R.id.cb9);
        checkBoxes.add(checkBox9);
        checkBox9.setText(ing9.getName());
        CheckBox checkBox10 = (CheckBox)findViewById(R.id.cb10);
        checkBoxes.add(checkBox10);
        checkBox10.setText(ing10.getName());
        CheckBox checkBox11 = (CheckBox)findViewById(R.id.cb11);
        checkBoxes.add(checkBox11);
        checkBox11.setText(ing11.getName());
        CheckBox checkBox12 = (CheckBox)findViewById(R.id.cb12);
        checkBoxes.add(checkBox12);
        checkBox12.setText(ing12.getName());
        CheckBox checkBox13 = (CheckBox)findViewById(R.id.cb13);
        checkBoxes.add(checkBox13);
        checkBox13.setText(ing13.getName());
        CheckBox checkBox14 = (CheckBox)findViewById(R.id.cb14);
        checkBoxes.add(checkBox14);
        checkBox14.setText(ing14.getName());
        CheckBox checkBox15 = (CheckBox)findViewById(R.id.cb15);
        checkBoxes.add(checkBox15);
        checkBox14.setText(ing15.getName());



    }
//    public void tester(View view){
//        final Button button = findViewById(R.id.test);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                for(i = 0; i < ingredients.size(); i++){
//                    CheckBox temp = checkBoxes.get(i);
//                    if(temp.isChecked()) {
//                        finalIngredients.add(ingredients.get(i));
//                        toast += ingredients.get(i).getName();
//                    }
//                }
//
//            }
//
//        });
//        Log.d(TAG, toast);
//    }

    public void toRecipes(View v) {
        for(i = 0; i < ingredients.size(); i++){
            CheckBox temp = checkBoxes.get(i);
            if(temp.isChecked()) {
                finalIngredients.add(ingredients.get(i));
                toast += ingredients.get(i).getName() + " ";
            }
        }
        // Why is there a null value in the first index
        Log.d(TAG, toast);
        Intent intent = new Intent(this, RecipeView.class);
        intent.putExtra("Ingredients User Has", finalIngredients);
        startActivity(intent);
    }


}
