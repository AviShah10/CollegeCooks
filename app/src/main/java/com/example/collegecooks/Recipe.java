package com.example.collegecooks;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Recipe implements Parcelable {
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

    protected Recipe(Parcel in) {
        ingredients = in.createTypedArrayList(Ingredient.CREATOR);
        time = in.readInt();
        method = in.readString();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(ingredients);
        dest.writeInt(time);
        dest.writeString(method);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

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
