package com.example.collegecooks;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Context;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecipeView extends AppCompatActivity {

    private static final String TAG = "RecipeView";

    private ArrayList<Recipe> finalRecipes = new ArrayList<Recipe>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<Ingredient> finalIngredients = new ArrayList<Ingredient>();
    String ing;

    private ArrayList<Integer> recipeMiss = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        boolean hello = true;
        if (bundle == null) {
            hello = false;
        }
        if (hello) {
            finalIngredients = bundle.getParcelableArrayList("Ingredients User Has");
        }

        for (int i = 0; i < finalIngredients.size(); i++) {
            ing += finalIngredients.get(i).getName() + " ";
        }

        Log.d(TAG, "From RecipeView: " + ing);

        /**
        for (int i = 0; i<finalIngredients.size(); i++) {
            Log.d(TAG, "From RecipeView: INGREDIENT NUMBER "+ i + " is "+finalIngredients.get(i).getName());
        }
         Verified that finalIngredients is the correct list
         **/


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("recipes");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    finalRecipes.add(child.getValue(Recipe.class));
                    mNames.add(child.getValue(Recipe.class).getName());
                    mImageUrls.add("https://banner2.kisspng.com/20180214/sow/kisspng-food-pyramid-clip-art-food-pyramid-5a83d807cc8440.5540065915185899598377.jpg");
                }
                godSort();
                initRecyclerView();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Avi", "Failed to read value.", error.toException());
            }
        });

    }


    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerView.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        mNames.clear();

        for (int i = 0; i<finalRecipes.size(); i++) {
            mNames.add(finalRecipes.get(i).getName());
        }

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, finalRecipes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void toIngredients(View v) {
        Intent intent = new Intent(this, DropDown.class);
        startActivity(intent);
    }

    public void toRecipes(View v) {
        Intent intent = new Intent(this, RecipeView.class);
        startActivity(intent);
    }

    public void toUserInput(View v) {
        Intent intent = new Intent(this, UserInput.class);
        startActivity(intent);
    }


    public void godSort() {
        //godSort1 sets up the ArrayList of misses

        int recipeMissInt = 0;
        int recipeHitInt = 0;

        for (int a = 0; a < finalRecipes.size(); a++) {                           //FOR ALL RECIPES
            for (int b = 0; b < finalRecipes.get(a).getIngredients().size(); b++) {    //FOR RECIPE'S INGREDIENTS
                for (int c = 0; c < finalIngredients.size(); c++) {           //FOR CHECKED INGREDIENTS

                    if (finalRecipes.get(a).getIngredients().get(b).getName().equals((String) finalIngredients.get(c).getName())) {       //Check each of allrecipe's ingredients DOESN'T equals the each of the checked ingredients
                        recipeHitInt = recipeHitInt + 1;

                        /**
                        Log.d(TAG, "In the godSort: " + finalRecipes.get(a).getIngredients().get(b).getName() +
                                " equalled " + finalIngredients.get(c).getName());
                        Log.d(TAG, "now recipeMissInt is " + recipeMissInt);
                         **/

                    }

                }
            }

            recipeMissInt = finalRecipes.get(a).getIngredients().size() - recipeHitInt;
            recipeMiss.add(recipeMissInt);

            recipeMissInt = 0;
            recipeHitInt = 0;

            //Log.d(TAG, "In the godSort: the recipeMiss array is " + recipeMiss.toString());

        }

        Log.d(TAG, "In the godSort: the FINAL recipeMiss array is " + recipeMiss.toString());

        godSort2();
    }

    public void godSort2() {
        //godSort2 puts the recipes and their misses into their corresponding bins

        ArrayList<Recipe> allRecipes0Miss = new ArrayList<Recipe>();
        ArrayList<Recipe> allRecipes1Miss = new ArrayList<Recipe>();
        ArrayList<Recipe> allRecipes2Miss = new ArrayList<Recipe>();
        ArrayList<Recipe> allRecipes3Miss = new ArrayList<Recipe>();
        ArrayList<Recipe> allRecipes4Miss = new ArrayList<Recipe>();
        ArrayList<Recipe> allRecipes5Miss = new ArrayList<Recipe>();

        ArrayList<Recipe> allRecipesSort = new ArrayList<Recipe>();

        for (int i = 0; i < finalRecipes.size(); i++) {
            if (recipeMiss.get(i) == 0) {
                allRecipes0Miss.add(finalRecipes.get(i));        //if 0 misses, add to 0 miss array
            } else if (recipeMiss.get(i) == 1) {
                allRecipes1Miss.add(finalRecipes.get(i));        //if 1 misses, add to 1 miss array
            } else if (recipeMiss.get(i) == 2) {
                allRecipes2Miss.add(finalRecipes.get(i));        //if 2 misses, add to 2 miss array
            } else if (recipeMiss.get(i) == 3) {
                allRecipes3Miss.add(finalRecipes.get(i));        //if 3 misses, add to 3 miss array
            } else if (recipeMiss.get(i) == 4) {
                allRecipes4Miss.add(finalRecipes.get(i));        //if 4 misses, add to 4 miss array
            } else if (recipeMiss.get(i) == 5) {
                allRecipes5Miss.add(finalRecipes.get(i));        //if 5 misses, add to 5 miss array
            }
        }

        //messy returns, still works though
        for (int a = 0; a < allRecipes0Miss.size(); a++) {
            allRecipesSort.add(allRecipes0Miss.get(a));
        }
        for (int a = 0; a < allRecipes1Miss.size(); a++) {
            allRecipesSort.add(allRecipes1Miss.get(a));
        }
        for (int a = 0; a < allRecipes2Miss.size(); a++) {
            allRecipesSort.add(allRecipes2Miss.get(a));
        }
        for (int a = 0; a < allRecipes3Miss.size(); a++) {
            allRecipesSort.add(allRecipes3Miss.get(a));
        }
        for (int a = 0; a < allRecipes4Miss.size(); a++) {
            allRecipesSort.add(allRecipes4Miss.get(a));
        }
        for (int a = 0; a < allRecipes5Miss.size(); a++) {
            allRecipesSort.add(allRecipes5Miss.get(a));
        }

        /**
        for (int i = 0; i < allRecipes0Miss.size(); i++ ) {
            Log.d(TAG, "End of godSort, a recipe with zero is " +allRecipes0Miss.get(i).getName());
        }
         individual verification, separating into bins works
         **/


        finalRecipes = allRecipesSort;

        /**
        Log.d(TAG, "End of godSort, allRecipesSort is " +finalRecipes.toString());
        godSort is verified to work
         **/
    }


}





/**
 //SELECT * FROM time WHERE time is less than or equal to "10"
 Log.d(TAG, "From Recipe View: The query is preparing to begin querying");
 Query query = FirebaseDatabase.getInstance().getReference("recipes")
 .orderByChild("time")
 .endAt(5);
 //end at grabs things less than or equal to what's in the parentheses



 Log.d(TAG, "From Recipe View: The query is preparing to begin querying");
 Query query = FirebaseDatabase.getInstance().getReference("recipes")
 .orderByChild("time")
 .endAt(5);

 //enter the query
 query.addListenerForSingleValueEvent(valueEventListener);

 Log.d(TAG, "From Recipe View: The query has quereyed (get hype)");
 **/


//        for(int i = 0; i < finalRecipes.size(); i++){
//            recipes += finalRecipes.get(i).getName() + " ";
//        }
//        Log.d(TAG, "From RecipeView Recipes: " +recipes);
//        initImageBitmaps();
