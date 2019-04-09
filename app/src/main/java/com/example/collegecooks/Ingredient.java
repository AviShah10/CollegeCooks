package com.example.collegecooks;

public class Ingredient {
    private int denomination;
    private String measure;
    private boolean isMajor;
    private String name;

    public Ingredient (int denomination, String measure, boolean isMajor, String name){
        this.denomination = denomination;
        this.measure = measure;
        this.isMajor = isMajor;
        this.name = name;
    }

    public int getDenomination(){
        return this.denomination;
    }
    public String getMeasure(){
        return this.measure;
    }
    public boolean getIsMajor(){
        return this.isMajor;
    }
    public String getName(){
        return this.name;
    }

}
