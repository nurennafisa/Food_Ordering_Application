package com.sabrinajahan.spicymenu;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MenuRecyclerAdapter extends RecyclerView.Adapter<MenuRecyclerAdapter.MyViewHolder> {


    private List<Food> foodList;
    private Context context;
    private RecyclerViewClickListener recyclerViewClickListener;
    private int selectedItem;


    private static int lastClickedPosition = -1;

    public MenuRecyclerAdapter(Context context, List<Food> foodList, int selectedItem, RecyclerViewClickListener recyclerViewClickListener) {
        this.context = context;
        this.foodList = foodList;
        this.selectedItem = selectedItem;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    public int getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(int position){
        selectedItem = position;
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        if (position == selectedItem)
            return 1;
        else return 2;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;

        if (viewType==1)
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_food, parent, false);
        else         itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_food, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        int currentPosition = position;

        Food food = foodList.get(position);

        holder.name.setText(food.getName());
        holder.price.setText(food.getPrice());
        holder.description.setText(food.getDescription());
        holder.rating.setText(food.getRating());


        holder.imageViewFood.setImageDrawable(ContextCompat.getDrawable(context, food.getImage()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItem = currentPosition;
                if (recyclerViewClickListener != null)
                    recyclerViewClickListener.onItemClicked(currentPosition);
            }
        });

    }


    @Override
    public int getItemCount() {
        return foodList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name , price , description ,rating;
        public ImageView imageViewFood;


        public MyViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.name);
            price = view.findViewById(R.id.price);
            description = view.findViewById(R.id.description);
            imageViewFood = view.findViewById(R.id.imageViewFood);
            rating = view.findViewById(R.id.rating);

        }
    }

}