package com.example.collegecooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";
    private Recipe recipe = new Recipe();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started.");

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        recipe = bundle.getParcelable("recipe");
        Log.d(TAG, recipe.getName() + recipe.getTime() + " yessir");


        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = recipe.getName();
            Log.d(TAG, imageName + " yessir");

            setImage(imageUrl, imageName);
        }
    }


    private void setImage(String imageUrl, String imageName){
        Log.d(TAG, "setImage: setting the image and name to widgets.");

        TextView name = findViewById(R.id.image_description);
        name.setText(imageName);

        TextView time = findViewById(R.id.image_time);
        time.setText(recipe.getTime() + " Minutes");

        String ingredients = "";
        for(int i = 0; i < recipe.getIngredients().size(); i++){
            Ingredient temp = recipe.getIngredients().get(i);
            if(recipe.getIngredients().get(i).getMeasure().equals("")){
                ingredients += temp.getDenomination() + " " + temp.getName() + "\n";
            }
            else{
                ingredients += temp.getDenomination() + " " + temp.getMeasure() + " of " + temp.getName() + "\n";
            }
        }
        TextView ing = findViewById(R.id.image_ingredients);
        ing.setText(ingredients);

        TextView method = findViewById(R.id.image_direction);
        method.setText(recipe.getMethod());

        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }

}


