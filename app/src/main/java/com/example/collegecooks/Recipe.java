package com.example.collegecooks;

import java.util.ArrayList;

public class Recipe {
    private ArrayList<Ingredient> ingredients;
    private int time;

    public Recipe(ArrayList<Ingredient> ingredients, int time){
        this.ingredients = ingredients;
        this.time = time;
    }
    public ArrayList<Ingredient> getIngredients(){
        return this.ingredients;
    }
    public int getTime(){
        return this.time;
    }

}
