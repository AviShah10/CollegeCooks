package com.example.collegecooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RecipeView extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);

        Log.d(TAG, "onCreate: started.");
        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        mImageUrls.add("https://cdn-image.myrecipes.com/sites/default/files/styles/4_3_horizontal_-_1200x900/public/chicken-black-bean-enchiladas-ck.jpg");
        mNames.add("Black Bean Enchiladas");

        mImageUrls.add("https://simple-nourished-living.com/wp-content/uploads/2012/10/Weight-Watchers-Cheese-Black-Bean-Nachos.jpg");
        mNames.add("Black Bean Nachos");

        mImageUrls.add("https://s.hdnux.com/photos/76/24/15/16335741/4/920x920.jpg");
        mNames.add("Hot Cheeto Ice Cream");

        mImageUrls.add("https://s3-media1.fl.yelpcdn.com/bphoto/_lAMiG-1AzwNmR1pUIwCAA/o.jpg");
        mNames.add("Hot Cheeto Pizza");

        mImageUrls.add("https://www.loveandoliveoil.com/wp-content/uploads/2017/05/yeast-waffles3-600x900.jpg");
        mNames.add("Krusteaz Belgian Waffles");

        mImageUrls.add("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/delish-how-to-make-an-omelette-horizontal-1542310072.png");
        mNames.add("Omelette");

        mImageUrls.add("https://bmexdi064h-flywheel.netdna-ssl.com/wp-content/uploads/2017/10/Instant-Pot-Macaroni-and-Cheese-foodiecrush.com-019.jpg");
        mNames.add("Mac and Cheese");

        mImageUrls.add("https://food.fnr.sndimg.com/content/dam/images/food/fullset/2013/2/14/0/FNK_Grilled-Tomato-and-Cheese_s4x3.jpg.rend.hgtvcom.616.462.suffix/1371614270782.jpeg");
        mNames.add("Cheese Delights");

        mImageUrls.add("https://itdoesnttastelikechicken.com/wp-content/uploads/2017/07/creamy-chipotle-lime-bean-salad-vegan-dairy-free-spicy-potluck-party-make-ahead-facebook.jpg");
        mNames.add("Spicy Bean Salad");

        mImageUrls.add("https://www.simplyrecipes.com/wp-content/uploads/2012/06/chicken-salad-square-a-1800.jpg");
        mNames.add("Chicken Salad");

        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerView.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
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

}
