package com.example.collegecooks;

import java.util.ArrayList;

public class Recipe {
    private ArrayList<Ingredient> ingredients;
    private int time;
    private String[] method;

    public Recipe(ArrayList<Ingredient> ingredients, int time, String[] method){
        this.ingredients = ingredients;
        this.time = time;
        this.method = method;
    }
    public ArrayList<Ingredient> getIngredients(){
        return this.ingredients;
    }
    public int getTime(){
        return this.time;
    }

    public String[] getMethod() {
        return this.method;
    }
}
