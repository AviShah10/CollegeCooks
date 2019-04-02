package com.example.collegecooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class RecipeView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);

    }

    public void toIngredients(View v) {
        Intent intent = new Intent(this, DropDown.class);
        startActivity(intent);
    }
    public void toRecipes(View v) {
        Intent intent = new Intent(this, RecipeView.class);
        startActivity(intent);
    }

}
