package com.example.collegecooks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DropDown extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_down);

        listView = (ListView) findViewById(R.id.ingredientsListView);

        ArrayList <String> arrayList = new ArrayList<String>();

        arrayList.add("Is this working?");
        arrayList.add("Yeah I think so");
        arrayList.add("Cool");
        arrayList.add("You tryna actually add ingredients?");
        arrayList.add("Yeah, aiight");
        arrayList.add("Lemme just flex on Lauren that this works");
        arrayList.add("Ha get rekt");

        arrayList.add("-------Blank space------");
        arrayList.add("Joel again, flexxing with this alphabetical order");
        arrayList.add("I added all of our ingredients too yeet");
        arrayList.add("Apples");
        arrayList.add("Black Beans");
        arrayList.add("Bread");
        arrayList.add("Cheese");
        arrayList.add("Egg");
        arrayList.add("Hot Cheetos");
        arrayList.add("Ice Cream");
        arrayList.add("Kruzteaz Waffle Mix");
        arrayList.add("Non-Stick Spray");
        arrayList.add("Pizza");
        arrayList.add("Tomato");
        arrayList.add("Tortillas");
        arrayList.add("Vegetable Oil");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

    }

    public void toIngredients(View v) {
        Intent intent = new Intent(this, DropDown.class);
        startActivity(intent);
    }

}
