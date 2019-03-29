package com.example.collegecooks;

public class Ingredient {
    private int denomination;
    private String measure;
    private boolean isMajor;

    public Ingredient (int denomination, String measure, boolean isMajor){
        this.denomination = denomination;
        this.measure = measure;
        this.isMajor = isMajor;
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

}
