package com.sabrinajahan.spicymenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickListener{

    private RecyclerView rvFoods;
    private MenuRecyclerAdapter menuRecyclerAdapter;
    private List<Food> foodList = new ArrayList<>();

    private View layoutDetails;
    private ImageView bigImage;
    private TextView name , details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        layoutDetails = findViewById(R.id.layoutDetails);
        bigImage = findViewById(R.id.bigImage);
        name = findViewById(R.id.name);
        details = findViewById(R.id.details);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutDetails.setVisibility(View.GONE);
            }
        });

        setOffersRecyclerView();
    }

    private void setOffersRecyclerView() {
//    public Food(int id, String name, String price, String description, int image) {

        foodList.add(new Food(1 , "Biriyani","$12","Biryani is a mixed rice dish made with Indian spices, rice, either with meat, or eggs or vegetables such as potatoes.","4.6",R.drawable.picture1));
        foodList.add(new Food(1 , "Dosa","$5","A dosa is a thin flat bread originating from South India, made from a fermented batter predominantly consisting of lentils and rice.","4",R.drawable.picture2));
        foodList.add(new Food(1 , "Pizza","$10","Pizza is a dish of Italian origin consisting of a usually round, flat base of leavened wheat-based dough topped with tomatoes, cheese, and often various other ingredients, which is then baked at a high temperature, traditionally in a wood-fired oven.\n","4.8",R.drawable.picture3));
        foodList.add(new Food(1 , "Hamburger","$7","A hamburger is a food consisting of fillings —usually a patty of ground meat, typically beef—placed inside a sliced bun or bread roll.","3.5",R.drawable.picture4));
        foodList.add(new Food(1 , "Pasta","$6","Pasta is a type of food typically made from an unleavened dough of wheat flour mixed with water or eggs, and formed into sheets or other shapes, then cooked by boiling or baking.","5",R.drawable.picture5));
        foodList.add(new Food(1 , "French Fries","$4","French fries are batonnet or allumette-cut deep-fried potatoes. They are prepared by cutting potatoes into even strips, drying them, and frying them, usually in a deep fryer.","4",R.drawable.picture6));
        foodList.add(new Food(1 , "Kheer","$4","Kheer is a sweet dish and a type of wet pudding popular in the Indian subcontinent, usually made by boiling milk, sugar or jaggery, and rice.","4",R.drawable.picture7));
        foodList.add(new Food(1 , "Brownie","$7","A chocolate brownie come in a variety of forms and may be either fudgy or cakey, depending on their density.","4",R.drawable.picture8));
        foodList.add(new Food(1 , "Butter Chicken","$5","Butter chicken is a type of curry made from chicken with a spiced tomato and butter sauce.","4",R.drawable.picture9));
        foodList.add(new Food(1 , "Mojito","$3","Mojito often consists of five ingredients: sugar, lime juice, soda water, and mint. Its combination of sweetness, citrus, and herbaceous mint flavors.","4",R.drawable.picture10));

        rvFoods = findViewById(R.id.rv);
       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvFoods.setLayoutManager(linearLayoutManager);
        menuRecyclerAdapter = new MenuRecyclerAdapter(this, foodList, 0, this);
        rvFoods.setAdapter(menuRecyclerAdapter);
    }

    private void setDetailsInfo(Food food){

        layoutDetails.setVisibility(View.VISIBLE);

        bigImage.setImageDrawable(ContextCompat.getDrawable(this ,food.getImage() ));

        name.setText(food.getName());
        details.setText(food.getDescription());
    }

    @Override
    public void onItemClicked(int position) {
        Log.d("jj" , foodList.get(position).getName());


        setDetailsInfo(foodList.get(position));
    }
}