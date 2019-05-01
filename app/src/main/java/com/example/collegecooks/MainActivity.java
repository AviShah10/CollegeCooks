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

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        push();
    }
    public void push(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("recipes");

        Ingredient pizza = new Ingredient(1, "", false, "Pizza");
        Ingredient hotCheeto = new Ingredient(6, "ounces", false, "Hot Cheetos");
        Ingredient iceCream = new Ingredient(1, "cup", true, "Ice Cream");
        Ingredient waffleMix = new Ingredient(1, "cups", true, "Waffle Mix");
        Ingredient egg = new Ingredient(1, "", true, "Egg");
        Ingredient oil = new Ingredient(0.25, "cups", false, "Oil");
        Ingredient nonStickSpray = new Ingredient(1, "spray", true, "Non Stick Spray");
        Ingredient tortillaChips = new Ingredient(1, "plate", true, "Tortilla Chips");
        Ingredient blackBeans = new Ingredient(1, "cup", true, "Black Beans");
        Ingredient cheese = new Ingredient(1, "cup", true, "Cheese");
        Ingredient tortilla = new Ingredient(2, "", true, "Tortillas");
        Ingredient egg2 = new Ingredient(3, "", true, "Eggs");
        Ingredient cheese2 = new Ingredient(2, "slices", true, "Cheese");
        Ingredient bread = new Ingredient(1, "slice", true, "Bread");
        Ingredient tomato = new Ingredient(1, "", true, "Tomato");
        Ingredient cheeseSauce = new Ingredient(1, "cup", true, "Cheese Sauce");
        Ingredient pasta = new Ingredient(2, "cups", true, "Pasta");
        Ingredient milk = new Ingredient(3, "tablespoons", true, "Milk");
        Ingredient butter = new Ingredient(2, "tablespoons", true, "Butter");
        Ingredient chicken = new Ingredient(2, "", true, "Chicken Breasts");
        Ingredient mayonnaise = new Ingredient(0.5, "cups", true, "Mayonnaise");
        Ingredient cranberries = new Ingredient(0.5, "cups", true, "Cranberries");
        Ingredient rice = new Ingredient(8, "ounces", true, "Rice");
        Ingredient peas = new Ingredient(2, "ounces", true, "Frozen Peas");
        Ingredient onion = new Ingredient(1, "", true, "Small Onion");
        Ingredient chickenWings = new Ingredient(1, "pound", true, "Chicken Wings");
        Ingredient soySauce = new Ingredient(1.5, "tablespoons", true, "Soy Sauce");
        Ingredient freshGarlic = new Ingredient(1, "clove", true, "Garlic");
        Ingredient freshGinger = new Ingredient(0.5, "tablespoons", true, "Ginger");
        Ingredient lentils = new Ingredient(1, "can", true, "Lentils");
        Ingredient flour = new Ingredient(0.5, "cups", true, "Flour");
        Ingredient sausage = new Ingredient(1, "pound", true, "Sausage");

        ArrayList<Ingredient> ingHotCheetoPizza = new ArrayList<Ingredient>();
        ingHotCheetoPizza.add(pizza);
        ingHotCheetoPizza.add(hotCheeto);

        ArrayList<Ingredient> ingHotCheetoIceCream = new ArrayList<Ingredient>();
        ingHotCheetoIceCream.add(iceCream);
        ingHotCheetoIceCream.add(hotCheeto);

        ArrayList<Ingredient> ingWaffles = new ArrayList<Ingredient>();
        ingWaffles.add(waffleMix);
        ingWaffles.add(egg);
        ingWaffles.add(oil);
        ingWaffles.add(nonStickSpray);

        ArrayList<Ingredient> ingQuesadillas = new ArrayList<Ingredient>();
        ingQuesadillas.add(tortilla);
        ingQuesadillas.add(blackBeans);
        ingQuesadillas.add(cheese);

        ArrayList<Ingredient> ingNachos = new ArrayList<Ingredient>();
        ingNachos.add(tortillaChips);
        ingNachos.add(blackBeans);
        ingNachos.add(cheese);

        ArrayList<Ingredient> ingOmelet = new ArrayList<Ingredient>();
        ingOmelet.add(egg2);
        ingOmelet.add(cheese2);
        ingOmelet.add(nonStickSpray);

        ArrayList<Ingredient> ingCheeseDelights = new ArrayList<Ingredient>();
        ingCheeseDelights.add(bread);
        ingCheeseDelights.add(cheese2);
        ingCheeseDelights.add(tomato);

        ArrayList<Ingredient> ingMacAndCheese = new ArrayList<Ingredient>();
        ingMacAndCheese.add(pasta);
        ingMacAndCheese.add(cheeseSauce);
        ingMacAndCheese.add(milk);
        ingMacAndCheese.add(butter);

        ArrayList<Ingredient> ingChickenSalad = new ArrayList<Ingredient>();
        ingChickenSalad.add(chicken);
        ingChickenSalad.add(mayonnaise);
        ingChickenSalad.add(cranberries);
        ingChickenSalad.add(bread);

        ArrayList<Ingredient> ingCantoneseRice = new ArrayList<Ingredient>();
        ingCantoneseRice.add(rice);
        ingCantoneseRice.add(egg2);
        ingCantoneseRice.add(peas);
        ingCantoneseRice.add(onion);
        ingCantoneseRice.add(oil);

        ArrayList<Ingredient> ingAsianChickenWings = new ArrayList<Ingredient>();
        ingAsianChickenWings.add(chickenWings);
        ingAsianChickenWings.add(soySauce);
        ingAsianChickenWings.add(freshGarlic);
        ingAsianChickenWings.add(freshGinger);
        ingAsianChickenWings.add(oil);

        ArrayList<Ingredient> ingLentilPatties= new ArrayList<Ingredient>();
        ingLentilPatties.add(lentils);
        ingLentilPatties.add(egg);
        ingLentilPatties.add(flour);
        ingLentilPatties.add(onion);
        ingLentilPatties.add(oil);

        ArrayList<Ingredient> ingLentilOmelets = new ArrayList<Ingredient>();
        ingLentilOmelets.add(lentils);
        ingLentilOmelets.add(egg2);
        ingLentilOmelets.add(oil);

        ArrayList<Ingredient> ingSausagePasta = new ArrayList<Ingredient>();
        ingSausagePasta.add(sausage);
        ingSausagePasta.add(pasta);
        ingSausagePasta.add(cheese);


        Recipe hotCheetoPizza = new Recipe(ingHotCheetoPizza, 15, "Put the hot Cheetos on the pizza, " +
                "either crushed up and sprinkled on the pizza or placed on top of the pizza. Put a handful of" +
                " Hot Cheetos, or until a desirable amount has been reached.", "Hot Cheeto Pizza");
        Recipe hotCheetoIceCream = new Recipe(ingHotCheetoIceCream, 5, "Put the Hot Cheetos on the ice cream, " +
                "either crushed up and sprinkled on the ice cream or placed on top of the ice cream. Put a handful of Hot " +
                "Cheetos, or until a desirable amount has been reached.", "Hot Cheeto Ice Cream");
        Recipe waffles = new Recipe(ingWaffles, 20, "Preheat the waffle iron. Mix ¾ cup of the waffle mix with 1 egg, " +
                "¼ cup oil, and ⅔ cup water. Pour the batter onto the waffle iron and close it. Wait 3-4 minutes and " +
                "take the waffle out. \n" +
                "You may like syrup, butter, chocolate chips, strawberries, and other items for toppings.", "Waffles");
        Recipe quesadillas = new Recipe(ingQuesadillas, 8, "Heat the stove to medium heat. Take a bowl " +
                "of black beans and mix in some salt and pepper (taco seasoning optional and crushing beans optional). " +
                "Take a tortilla and spread the beans on the tortilla. Put a layer of cheese on top of the beans. " +
                "Cover everything with another tortilla. Place the quesadilla on the heated stove. Cook the quesadilla " +
                "on one side for 3-5 minutes (until bottom tortilla has a browned color). Flip the quesadilla and cook " +
                "for 2-3 more minutes. Take out the quesadilla and serve with optional salsa or sour cream.",
                "Black Bean Quesadillas");
        Recipe nachos = new Recipe(ingNachos, 5, "Align a desired number of tortilla chips on a plate. " +
                "Take a bowl of black beans and mix in some salt and pepper (taco seasoning optional and crushing beans" +
                " optional). Place the beans on the chips. Put a layer of cheese on the chips. Put the plate in the " +
                "microwave and heat for about 1 minute and 30 seconds (or until the cheese is melted). Take out the " +
                "nachos and serve with optional salsa or sour cream.", "Black Bean Nachos");
        Recipe omelets = new Recipe(ingOmelet, 10, "Heat the burner to medium. Crack 2-4 eggs in a bowl " +
                "and mix until homogeneous. Spray the pan and pour mixture into pan (so the the full pan is covered) " +
                "once burner is heated. (Way to check: let a small amount of egg mixture drip onto the pan on the burner " +
                "and if instantly cooks, then burner is ready.) Wait until bottom of omelet has solidified, then put " +
                "cheese on one half of omelet. After cheese has melted slightly, flip non-cheesy side of omelet on top " +
                "of the other side. Flip once solidified, then serve.", "Omelets");
        Recipe cheeseDelights = new Recipe(ingCheeseDelights, 5, "Put a slice of tomato on top of a " +
                "piece of bread, then put a slice of cheese on top of the slice of tomato. Heat in toaster oven on" +
                " high for about 2 minutes (or until toaster oven automatically turns off). Heat more if needed to " +
                "melt cheese further. (Heat required depends on toaster oven - should be enough to melt the cheese " +
                "on top of the tomato slice.)", "Cheese Delights");
        Recipe macAndCheese = new Recipe(ingMacAndCheese, 15, "Boil water. Cook pasta. Mix cheese " +
                "sauce, milk, and butter with the pasta until the desired taste is achieved.", "Mac and Cheese");
        Recipe chickenSalad = new Recipe(ingChickenSalad, 20, "Put raw chicken into pot of cold water " +
                "- bring to boil. Reduce heat to simmer, cover, simmer approximately 15 minutes. Cut into one piece " +
                "to confirm NO PINK - all must be white and it is done. Let chicken cool, cut into small pieces. In " +
                "bowl mix chicken with handful of grapes or cucumber pieces, or  cranberries, add mayo and salt until " +
                "spreadable. Spread onto bread or roll or wrap.", "Chicken Salad");
        Recipe cantoneseRice = new Recipe(ingCantoneseRice, 15, "Cook rice, set aside. Cook onions in " +
                "oil, after 5 minutes add beaten eggs. Set heat on low, add frozen green peas. Mix everything together, " +
                "it's ready.", "Cantonese Rice");
        Recipe asianChickenWings = new Recipe(ingAsianChickenWings, 20, "Brown the chicken wings in the " +
                "pan with oil for 3 minutes on each side, then lower the heat and cover. When the chicken is done, put " +
                "the heat on low and add the soy sauce + ginger + garlic. Cover and let marinate for 5-10 minutes.",
                "Asian Chicken Wings");
        Recipe lentilPatties = new Recipe(ingLentilPatties, 10, "Mash the lentils, but leave some texture. " +
                "Add an egg, mix. Add flour, mix. Add bits of raw onion, mix. Use oil to cook on a pan, forming patties." +
                "\n", "Lentil Patties");
        Recipe lentilOmelets = new Recipe(ingLentilOmelets, 20, "Drain lentils, put them in the pan, let " +
                "the leftover water evaporate. Then add oil, and beaten eggs, on high heat. 1lb lentils for 4 eggs. Lower " +
                "the heat, cover. The top won't cook evenly, so after about 15 minutes, cut the circle in 4 parts, and turn " +
                "each part so the other side can cook. Leave for 5 minutes, covered. This makes 4 portions."
                , "Lentil Omelets");
        Recipe sausagePasta = new Recipe(ingSausagePasta, 20, "Fry and drain sausage. Cook pasta. Mix " +
                "sausage into pasta. Grate however much mozarella you want and mix into pasta/sausage. Sprinkle with " +
                "parmesan. Bake in 350 degree oven until hot and the cheese is melted, but not so long that the noodles " +
                "become crispy.  Usually around 5-10 min.", "Sausage Pasta");

        Log.d("Avi", "Persisting");
        myRef.child("hotCheetoPizza").setValue(hotCheetoPizza);
        myRef.child("hotCheetoIceCream").setValue(hotCheetoIceCream);
        myRef.child("waffles").setValue(waffles);
        myRef.child("quesadillas").setValue(quesadillas);
        myRef.child("nachos").setValue(nachos);
        myRef.child("omelets").setValue(omelets);
        myRef.child("cheeseDelights").setValue(cheeseDelights);
        myRef.child("macAndCheese").setValue(macAndCheese);
        myRef.child("chickenSalad").setValue(chickenSalad);
        myRef.child("cantoneseRice").setValue(cantoneseRice);
        myRef.child("asianChickenWings").setValue(asianChickenWings);
        myRef.child("lentilPatties").setValue(lentilPatties);
        myRef.child("lentilOmelets").setValue(lentilOmelets);
        myRef.child("sausagePasta").setValue(sausagePasta);


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
