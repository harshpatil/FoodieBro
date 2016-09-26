package com.cs442.hpatil2.foodiebro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cs442.hpatil2.foodiebro.model.Dish;

import java.util.List;

/**
 * Created by HarshPatil on 9/25/16.
 */
public class DishAdapter extends ArrayAdapter<Dish> {

    int resource;

    public DishAdapter(Context context, int resource, List<Dish> dishList){

        super(context, resource, dishList);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout dishView;
        Dish dish = getItem(position);

        String name = dish.getName();
        String price = dish.getPrice();
        int itemId = dish.getItemId();
        int imageId = dish.getImageId();

        if(convertView == null){
            dishView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(inflater);
            layoutInflater.inflate(resource, dishView, true);
        }else {
            dishView = (LinearLayout) convertView;
        }

        TextView countView = (TextView)dishView.findViewById(R.id.itemNumber);
        TextView dishName = (TextView)dishView.findViewById(R.id.itemName);
        TextView dishPrice = (TextView)dishView.findViewById(R.id.itemPrice);
        ImageView imageView = (ImageView)dishView.findViewById(R.id.dishImage);
        imageView.setImageResource(imageId);

        dishPrice.setText(price);
        dishName.setText(name);
        countView.setText(String.valueOf(itemId));

        return dishView;
    }
}
