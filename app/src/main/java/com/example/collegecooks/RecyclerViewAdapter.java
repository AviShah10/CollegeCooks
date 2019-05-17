package com.example.collegecooks;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.awt.font.TextAttribute;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    //Variables
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Recipe> recipes = new ArrayList<>();
    private Context mContext;

    //Parameter constructor
    public RecyclerViewAdapter(Context context, ArrayList<String> mNames, ArrayList<String> mImageUrls, ArrayList<Recipe> recipes) {
        this.mNames = mNames;
        this.mImageUrls = mImageUrls;
        this.mContext = context;
        this.recipes = recipes;
    }

    @Override
    /**
     * creates the view for the recycler view
     */
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    //Creates a button listener to open a specific recipe
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        Glide.with(mContext).asBitmap().load(mImageUrls.get(position)).into(holder.image);
        holder.imageName.setText(mNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onCLick: clicked on: " + mNames.get(position));


                Toast.makeText(mContext, mNames.get(position), Toast.LENGTH_SHORT).show();

                Recipe temp = getRecipe(mNames.get(position));
                Log.d(TAG, temp.getName() + "yessir");
                Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("image_url", mImageUrls.get(position));
                intent.putExtra("image_name", mNames.get(position));
                intent.putExtra("recipe", temp);
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    //Getter method
    public int getItemCount() {
        return mNames.size();
    }

    //Recipe getter method
    public Recipe getRecipe(String mName){
        Log.d(TAG,"Inside getRecipe(): " + mName + " yessir");
        for(int i = 0; i < recipes.size(); i++){
            if(recipes.get(i).getName().equals(mName)) return recipes.get(i);
        }
        return recipes.get(3);
    }

    //Creates ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
