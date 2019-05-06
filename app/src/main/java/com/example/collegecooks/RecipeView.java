package com.example.collegecooks;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        finalIngredients = bundle.getParcelableArrayList("Ingredients User Has");

        for(int i = 0; i < finalIngredients.size(); i++){
            ing += finalIngredients.get(i).getName() + " ";
        }

        Log.d(TAG, "From RecipeView: " + ing);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("recipes");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated
                for(DataSnapshot child : dataSnapshot.getChildren()){
                    finalRecipes.add(child.getValue(Recipe.class));
                    mNames.add(child.getValue(Recipe.class).getName());
                    mImageUrls.add("https://banner2.kisspng.com/20180214/sow/kisspng-food-pyramid-clip-art-food-pyramid-5a83d807cc8440.5540065915185899598377.jpg");
                    initRecyclerView();

//                    finalRecipes.add(child.getValue(Recipe.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Avi", "Failed to read value.", error.toException());
            }
        });
//        for(int i = 0; i < finalRecipes.size(); i++){
//            recipes += finalRecipes.get(i).getName() + " ";
//        }
//        Log.d(TAG, "From RecipeView Recipes: " +recipes);
//        initImageBitmaps();
    }

//    private void initImageBitmaps(){
//        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

//        for(int i = 0; i< finalRecipes.size(); i++){
//            mNames.add(finalRecipes.get(i).getName());
//        }
//        mImageUrls.add("https://cdn-image.myrecipes.com/sites/default/files/styles/4_3_horizontal_-_1200x900/public/chicken-black-bean-enchiladas-ck.jpg");
//        mNames.add("Black Bean Enchiladas");

//        mImageUrls.add("https://simple-nourished-living.com/wp-content/uploads/2012/10/Weight-Watchers-Cheese-Black-Bean-Nachos.jpg");
//        mNames.add("Black Bean Nachos");

//        mImageUrls.add("https://s.hdnux.com/photos/76/24/15/16335741/4/920x920.jpg");
//        mNames.add("Hot Cheeto Ice Cream");

//        mImageUrls.add("https://s3-media1.fl.yelpcdn.com/bphoto/_lAMiG-1AzwNmR1pUIwCAA/o.jpg");
//        mNames.add("Hot Cheeto Pizza");

//        mImageUrls.add("https://www.loveandoliveoil.com/wp-content/uploads/2017/05/yeast-waffles3-600x900.jpg");
//        mNames.add("Krusteaz Belgian Waffles");

//        mImageUrls.add("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/delish-how-to-make-an-omelette-horizontal-1542310072.png");
//        mNames.add("Omelette");

//        mImageUrls.add("https://bmexdi064h-flywheel.netdna-ssl.com/wp-content/uploads/2017/10/Instant-Pot-Macaroni-and-Cheese-foodiecrush.com-019.jpg");
//        mNames.add("Mac and Cheese");

//        mImageUrls.add("https://food.fnr.sndimg.com/content/dam/images/food/fullset/2013/2/14/0/FNK_Grilled-Tomato-and-Cheese_s4x3.jpg.rend.hgtvcom.616.462.suffix/1371614270782.jpeg");
//        mNames.add("Cheese Delights");

//        mImageUrls.add("https://itdoesnttastelikechicken.com/wp-content/uploads/2017/07/creamy-chipotle-lime-bean-salad-vegan-dairy-free-spicy-potluck-party-make-ahead-facebook.jpg");
//        mNames.add("Spicy Bean Salad");

//        mImageUrls.add("https://www.simplyrecipes.com/wp-content/uploads/2012/06/chicken-salad-square-a-1800.jpg");
//        mNames.add("Chicken Salad");

//        initRecyclerView();

//    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerView.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
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
//    public void toUserInput(View v) {
//        Intent intent = new Intent(this, UserInput.class);
//        startActivity(intent);
//    }



}
