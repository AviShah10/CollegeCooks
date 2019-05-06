package com.example.collegecooks;

import android.content.Intent;
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
    String recipes;

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
                    mNames.add(child.getValue(Recipe.class).getName());
                    mImageUrls.add("https://attachments.office.net/owa/ashah2@wpi0.mail.onmicrosoft.com/service.svc/s/GetFileAttachment?id=AAMkAGE3NzViYjljLWEyZWYtNDE2ZC05MmI5LWUzYzVmZjdlM2EyNwBGAAAAAACI%2ftf8sQCIQa5F%2bvOkzO2TBwA2oU3Ny97KTL1PcSvS11GgAAAAYeRcAADwfoJHkV3WS4VikatnowtaAADL85EZAAABEgAQAB%2b2JePANdlAphGlQfuI8hU%3d&owa=outlook.office.com&isImagePreview=True&token=eyJhbGciOiJSUzI1NiIsImtpZCI6IjA2MDBGOUY2NzQ2MjA3MzdFNzM0MDRFMjg3QzQ1QTgxOENCN0NFQjgiLCJ4NXQiOiJCZ0Q1OW5SaUJ6Zm5OQVRpaDhSYWdZeTN6cmciLCJ0eXAiOiJKV1QifQ.eyJ2ZXIiOiJFeGNoYW5nZS5DYWxsYmFjay5WMSIsImFwcGN0eHNlbmRlciI6Ik93YURvd25sb2FkQDU4OWM3NmY1LWNhMTUtNDFmOS04ODRiLTU1ZWMxNWEwNjcyYSIsImFwcGN0eCI6IntcIm1zZXhjaHByb3RcIjpcIm93YVwiLFwicHJpbWFyeXNpZFwiOlwiUy0xLTUtMjEtMzY3MzI4NDY0Mi0xMjgzNzA4NzEwLTEzNTQ2NjQxNjEtMTkwNzk3MjhcIixcInB1aWRcIjpcIjExNTM5NzcwMjU3NjY5NTg2MjJcIixcIm9pZFwiOlwiODY3MzQ0N2YtM2M2ZC00ZjY3LWJjMTUtY2RjYTI5ZjNhZWJlXCIsXCJzY29wZVwiOlwiT3dhRG93bmxvYWRcIn0iLCJuYmYiOjE1NTY3MzI1ODIsImV4cCI6MTU1NjczMzE4MiwiaXNzIjoiMDAwMDAwMDItMDAwMC0wZmYxLWNlMDAtMDAwMDAwMDAwMDAwQDU4OWM3NmY1LWNhMTUtNDFmOS04ODRiLTU1ZWMxNWEwNjcyYSIsImF1ZCI6IjAwMDAwMDAyLTAwMDAtMGZmMS1jZTAwLTAwMDAwMDAwMDAwMC9hdHRhY2htZW50cy5vZmZpY2UubmV0QDU4OWM3NmY1LWNhMTUtNDFmOS04ODRiLTU1ZWMxNWEwNjcyYSJ9.BauCKPaKSCTltIabGiLY7A8YQxFV6hmuqTV3uY0N9ng6uyGQz-tfz45sAtHV1Ewp5mM_221lBeGicIrHzj_3uQx_L2FG40t2_YPOOPDhGV8_8Rx6IbPW9wpznH5j7XzzVS_3zW-xz1V_hoPLwxDb0AvSwrAvRD2Z2garbFg_cm-HeVCshxLtSyhFsXlGKpOX8xKNOV2zLvphHRDXC_V5ab2Z86lslohVqJ1wiT7y2bbqxbeaJ57DrADbLLtyeuPkpA3tcdxZ5T8aZMnjhXcCoGFccbZT45ZQ172RAZelLNv3hK-7XQDEizIcWn7SC05P7-CbcF1s9-F1jIg-3NhuNQ&NoRetry=1");
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
        for(int i = 0; i < finalRecipes.size(); i++){
            recipes += finalRecipes.get(i).getName() + " ";
        }
        Log.d(TAG, "From RecipeView Recipes: " +recipes);
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
    public void toUserInput(View v) {
        Intent intent = new Intent(this, UserInput.class);
        startActivity(intent);
    }



}
