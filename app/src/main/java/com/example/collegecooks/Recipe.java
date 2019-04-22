package com.example.collegecooks;

import java.util.ArrayList;

public class Recipe {
    private ArrayList<Ingredient> ingredients;
    private int time;
    private String method;
    private String name;

    public Recipe() {
        this.ingredients = new ArrayList<Ingredient>();
        this.time = 0;
        this.method = "";
        this.name = "";
    }

    public Recipe(ArrayList<Ingredient> ingredients, int time, String method, String name){
        this.ingredients = ingredients;
        this.time = time;
        this.method = method;
        this.name = name;
    }
    public ArrayList<Ingredient> getIngredients(){
        return this.ingredients;
    }
    public int getTime(){
        return this.time;
    }
    public String getMethod() {
        return this.method;
    }
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
