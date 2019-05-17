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

    /**
     * This onCreate creates the list of ingredients for the user to select from
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_down);

        //Create ingredients
        Ingredient ing0 = new Ingredient(1, "", false, "Pizza");
        Ingredient ing1 = new Ingredient(6, "ounces", false, "Hot Cheetos");
        Ingredient ing2 = new Ingredient(1, "cup", true, "Ice Cream");
        Ingredient ing3 = new Ingredient(1, "cups", true, "Waffle Mix");
        Ingredient ing4 = new Ingredient(1, "", true, "Egg");
        Ingredient ing5 = new Ingredient(0.25, "cups", false, "Oil");
        Ingredient ing6 = new Ingredient(1, "spray", true, "Non Stick Spray");
        Ingredient ing7 = new Ingredient(1, "plate", true, "Tortilla Chips");
        Ingredient ing8 = new Ingredient(1, "cup", true, "Black Beans");
        Ingredient ing9 = new Ingredient(1, "cup", true, "Shredded Cheese");
        Ingredient ing10 = new Ingredient(2, "", true, "Tortillas");
        Ingredient ing11 = new Ingredient(1, "slice", true, "Bread");
        Ingredient ing12= new Ingredient(1, "", true, "Tomato");
        Ingredient ing13 = new Ingredient(1, "cup", true, "Cheese Sauce");
        Ingredient ing14 = new Ingredient(2, "cups", true, "Pasta");
        Ingredient ing15 = new Ingredient(3, "tablespoons", true, "Milk");
        Ingredient ing16 = new Ingredient(2, "tablespoons", true, "Butter");
        Ingredient ing17 = new Ingredient(2, "", true, "Chicken Breasts");
        Ingredient ing18 = new Ingredient(0.5, "cups", true, "Mayonnaise");
        Ingredient ing19 = new Ingredient(0.5, "cups", true, "Cranberries");
        Ingredient ing20 = new Ingredient(8, "ounces", true, "Rice");
        Ingredient ing21 = new Ingredient(2, "ounces", true, "Frozen Peas");
        Ingredient ing22 = new Ingredient(1, "", true, "Small Onion");
        Ingredient ing23 = new Ingredient(1, "pound", true, "Chicken Wings");
        Ingredient ing24 = new Ingredient(1.5, "tablespoons", true, "Soy Sauce");
        Ingredient ing25 = new Ingredient(1, "clove", true, "Garlic");
        Ingredient ing26 = new Ingredient(0.5, "tablespoons", true, "Ginger");
        Ingredient ing27 = new Ingredient(1, "can", true, "Lentils");
        Ingredient ing28 = new Ingredient(0.5, "cups", true, "Flour");
        Ingredient ing29 = new Ingredient(1, "pound", true, "Sausage");
        Ingredient ing30 = new Ingredient(2, "slices", true, "Sliced Cheese");

        //Add ingredients to an arrayList of Ingredients
        ingredients.add(ing0);
        ingredients.add(ing1);
        ingredients.add(ing2);
        ingredients.add(ing3);
        ingredients.add(ing4);
        ingredients.add(ing5);
        ingredients.add(ing6);
        ingredients.add(ing7);
        ingredients.add(ing8);
        ingredients.add(ing9);
        ingredients.add(ing10);
        ingredients.add(ing11);
        ingredients.add(ing12);
        ingredients.add(ing13);
        ingredients.add(ing14);
        ingredients.add(ing15);
        ingredients.add(ing16);
        ingredients.add(ing17);
        ingredients.add(ing18);
        ingredients.add(ing19);
        ingredients.add(ing20);
        ingredients.add(ing21);
        ingredients.add(ing22);
        ingredients.add(ing23);
        ingredients.add(ing4);
        ingredients.add(ing25);
        ingredients.add(ing26);
        ingredients.add(ing27);
        ingredients.add(ing28);
        ingredients.add(ing29);
        ingredients.add(ing30);


        //Creates checkboxes, adds them to an arrayList of checkboxes, sets each name to the name of its corresponding Ingredient
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
        checkBox15.setText(ing15.getName());
        CheckBox checkBox16 = (CheckBox)findViewById(R.id.cb16);
        checkBoxes.add(checkBox16);
        checkBox16.setText(ing16.getName());
        CheckBox checkBox17 = (CheckBox)findViewById(R.id.cb17);
        checkBoxes.add(checkBox17);
        checkBox17.setText(ing17.getName());
        CheckBox checkBox18 = (CheckBox)findViewById(R.id.cb18);
        checkBoxes.add(checkBox18);
        checkBox18.setText(ing18.getName());
        CheckBox checkBox19 = (CheckBox)findViewById(R.id.cb19);
        checkBoxes.add(checkBox19);
        checkBox19.setText(ing19.getName());
        CheckBox checkBox20 = (CheckBox)findViewById(R.id.cb20);
        checkBoxes.add(checkBox20);
        checkBox20.setText(ing20.getName());
        CheckBox checkBox21 = (CheckBox)findViewById(R.id.cb21);
        checkBoxes.add(checkBox21);
        checkBox21.setText(ing21.getName());
        CheckBox checkBox22 = (CheckBox)findViewById(R.id.cb22);
        checkBoxes.add(checkBox22);
        checkBox22.setText(ing22.getName());
        CheckBox checkBox23 = (CheckBox)findViewById(R.id.cb23);
        checkBoxes.add(checkBox23);
        checkBox23.setText(ing23.getName());
        CheckBox checkBox24 = (CheckBox)findViewById(R.id.cb24);
        checkBoxes.add(checkBox24);
        checkBox24.setText(ing24.getName());
        CheckBox checkBox25 = (CheckBox)findViewById(R.id.cb25);
        checkBoxes.add(checkBox25);
        checkBox25.setText(ing25.getName());
        CheckBox checkBox26 = (CheckBox)findViewById(R.id.cb26);
        checkBoxes.add(checkBox26);
        checkBox26.setText(ing26.getName());
        CheckBox checkBox27 = (CheckBox)findViewById(R.id.cb27);
        checkBoxes.add(checkBox27);
        checkBox27.setText(ing27.getName());
        CheckBox checkBox28 = (CheckBox)findViewById(R.id.cb28);
        checkBoxes.add(checkBox28);
        checkBox28.setText(ing28.getName());
        CheckBox checkBox29 = (CheckBox)findViewById(R.id.cb29);
        checkBoxes.add(checkBox29);
        checkBox29.setText(ing29.getName());
        CheckBox checkBox30 = (CheckBox)findViewById(R.id.cb30);
        checkBoxes.add(checkBox30);
        checkBox30.setText(ing30.getName());



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

    /**
     * Creates a list of ingredients checked and passes it to the RecipeView class
     * @param v
     */
    public void toRecipes(View v) {
        for(i = 0; i < ingredients.size(); i++){
            CheckBox temp = checkBoxes.get(i);
            if(temp.isChecked()) {
                finalIngredients.add(ingredients.get(i));
                toast += ingredients.get(i).getName() + " ";
            }
        }
        // Why is there a null value in the first index
        //Log.d(TAG, toast);
        Intent intent = new Intent(this, RecipeView.class);
        intent.putExtra("Ingredients User Has", finalIngredients);
        startActivity(intent);
    }


}
