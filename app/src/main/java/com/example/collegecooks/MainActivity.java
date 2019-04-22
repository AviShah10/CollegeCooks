package com.example.collegecooks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        Ingredient pizza = new Ingredient(1, "pizza", false, "Pizza");
        Ingredient hotCheeto = new Ingredient(6, "ounces", false, "Hot Cheeto");

        ArrayList<Ingredient> list = new ArrayList<Ingredient>();
        list.add(pizza);
        list.add(hotCheeto);

        Recipe hotCheetoPizza = new Recipe(list, 15, "Put the hot Cheetos on the pizza, " +
                "either crushed up and sprinkled on the pizza or placed on top of the pizza. Put a handful of" +
                " Hot Cheetos, or until a desirable amount has been reached.", "Hot Cheeto Pizza");

        Log.d("Avi", "Persisting");
        myRef.child("recipes").setValue(hotCheetoPizza);



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot child : dataSnapshot.getChildren()){
//                    child.getValue();
                    Log.d("MainActivity",child.getValue(Recipe.class).toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Avi", "Failed to read value.", error.toException());
            }
        });
    }

    public void welcome(View v) {
        Intent intent = new Intent(this, DropDown.class);
        startActivity(intent);
    }
}
