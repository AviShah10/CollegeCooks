package com.example.collegecooks;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import java.util.ArrayList;

public class DropDown extends AppCompatActivity {

//    ListView listView;
    String[] labels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_down);

        Resources res = getResources();
        labels = ((Resources) res).getStringArray(R.array.checkBoxArray);

//        Unused ingredients
        /*listView = (ListView) findViewById(R.id.ingredientsListView);
        ArrayList <String> arrayList = new ArrayList<String>();
        arrayList.add("Black Beans");
        arrayList.add("Bread");
        arrayList.add("Cheese");
        arrayList.add("Cheese Sauce");
        arrayList.add("Egg");
        arrayList.add("Hot Cheetos");
        arrayList.add("Ice Cream");
        arrayList.add("Kruzteaz Waffle Mix");
        arrayList.add("Milk");
        arrayList.add("Non-Stick Spray");
        arrayList.add("Pasta");
        arrayList.add("Pizza");
        arrayList.add("Tomato");
        arrayList.add("Tortilla");
        arrayList.add("Vegetable Oil");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);*/



        CheckBox checkBox0 = (CheckBox)findViewById(R.id.cb0);
        checkBox0.setText(labels[0]);
        CheckBox checkBox1 = (CheckBox)findViewById(R.id.cb1);
        checkBox1.setText(labels[1]);
        CheckBox checkBox2 = (CheckBox)findViewById(R.id.cb2);
        checkBox2.setText(labels[2]);
        CheckBox checkBox3 = (CheckBox)findViewById(R.id.cb3);
        checkBox3.setText(labels[3]);
        CheckBox checkBox4 = (CheckBox)findViewById(R.id.cb4);
        checkBox4.setText(labels[4]);
        CheckBox checkBox5 = (CheckBox)findViewById(R.id.cb5);
        checkBox5.setText(labels[5]);
        CheckBox checkBox6 = (CheckBox)findViewById(R.id.cb6);
        checkBox6.setText(labels[6]);
        CheckBox checkBox7 = (CheckBox)findViewById(R.id.cb7);
        checkBox7.setText(labels[7]);
        CheckBox checkBox8 = (CheckBox)findViewById(R.id.cb8);
        checkBox8.setText(labels[8]);
        CheckBox checkBox9 = (CheckBox)findViewById(R.id.cb9);
        checkBox9.setText(labels[9]);
        CheckBox checkBox10 = (CheckBox)findViewById(R.id.cb10);
        checkBox10.setText(labels[10]);
        CheckBox checkBox11 = (CheckBox)findViewById(R.id.cb11);
        checkBox11.setText(labels[11]);
        CheckBox checkBox12 = (CheckBox)findViewById(R.id.cb12);
        checkBox12.setText(labels[12]);
        CheckBox checkBox13 = (CheckBox)findViewById(R.id.cb13);
        checkBox13.setText(labels[13]);
        CheckBox checkBox14 = (CheckBox)findViewById(R.id.cb14);
        checkBox14.setText(labels[14]);

//        final TextView textView = (TextView)findViewById(R.id.textView2);




//      Sample booleans
        checkBox0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                //b is that the box is checked
                if(b==true)
                {
//                    what to do if it is checked
//                    compoundButton.setBackgroundColor(Color.GREEN);
//                    textView.setText("Checked ");
                } else {
//                    what to do if it is unchecked
//                    compoundButton.setBackgroundColor(Color.WHITE);
//                    textView.setText("Unchecked ");
                }
            }
        });

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
