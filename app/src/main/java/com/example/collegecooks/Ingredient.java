package com.example.collegecooks;

import android.os.Parcel;
import android.os.Parcelable;

public class Ingredient implements Parcelable{
    private double denomination;
    private String measure;
    private boolean isMajor;
    private String name;

    public Ingredient (){
        this.denomination = 0;
        this.measure = "";
        this.isMajor = true;
        this.name = "";
    }

    public Ingredient (double denomination, String measure, boolean isMajor, String name){
        this.denomination = denomination;
        this.measure = measure;
        this.isMajor = isMajor;
        this.name = name;
    }

    public Ingredient (int denomination, String measure, String name){
        this.denomination = denomination;
        this.measure = measure;
        this.name = name;
    }

    protected Ingredient(Parcel in) {
        denomination = in.readDouble();
        measure = in.readString();
        isMajor = in.readByte() != 0;
        name = in.readString();
    }

    public static final Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel in) {
            return new Ingredient(in);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };

    public double getDenomination(){
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(denomination);
        dest.writeString(measure);
        dest.writeByte((byte) (isMajor ? 1 : 0));
        dest.writeString(name);
    }
}
