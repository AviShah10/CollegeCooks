package com.example.collegecooks;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Recipe implements Parcelable {

    //Instance variables
    private ArrayList<Ingredient> ingredients;
    private int time;
    private String method;
    private String name;

    //Default constructor
    public Recipe() {
        this.ingredients = new ArrayList<Ingredient>();
        this.time = 0;
        this.method = "";
        this.name = "";
    }

    //Parameter constructor
    public Recipe(ArrayList<Ingredient> ingredients, int time, String method, String name){
        this.ingredients = ingredients;
        this.time = time;
        this.method = method;
        this.name = name;

    }

    //Parcelable constructor
    protected Recipe(Parcel in) {
        ingredients = in.createTypedArrayList(Ingredient.CREATOR);
        time = in.readInt();
        method = in.readString();
        name = in.readString();
    }

    @Override
    //Writes to the parcelable with parameters
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(ingredients);
        dest.writeInt(time);
        dest.writeString(method);
        dest.writeString(name);
    }

    @Override
    //describeContents method
    public int describeContents() {
        return 0;
    }

    //Creator for the parcelable recipe
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

    //Getter methods
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
    //Overridden toString method
    public String toString() {
        return this.name;
    }
}
