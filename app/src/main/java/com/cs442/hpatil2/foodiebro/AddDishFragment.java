package com.cs442.hpatil2.foodiebro;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by HarshPatil on 9/24/16.
 */
public class AddDishFragment extends Fragment {

    View view;
    private OnNewDishAddedListener onNewDishAddedListener;

    public interface OnNewDishAddedListener {
        public void onNewDishAdded(String name, String price, String description, int imageId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.add_dish_layout, container, false);

        final EditText dishName = (EditText) view.findViewById(R.id.DishName);
        final EditText dishPrice = (EditText) view.findViewById(R.id.Price);
        final EditText dishDescription = (EditText) view.findViewById(R.id.Description);

        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name, price, description;
                if(dishName.getText().toString() != null && dishName.getText().toString().length() > 0){
                    name = dishName.getText().toString();
                }else {
                    name = "Default Dish";
                }

                if(dishPrice.getText().toString() != null && dishPrice.getText().toString().length() > 0){
                    price = dishPrice.getText().toString();
                }else {
                    price = "Ask Waiter :P";
                }

                if(dishDescription.getText().toString() != null && dishDescription.getText().toString().length() > 0){
                    description = dishPrice.getText().toString();
                }else {
                    description = "Includes all masala's \nTaste:Spicy";
                }
                onNewDishAddedListener.onNewDishAdded(name, price, description, R.drawable.pizza);
                dishName.setText("");
                dishPrice.setText("");
                dishDescription.setText("");
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            onNewDishAddedListener = (OnNewDishAddedListener)activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() +
                    "");
        }
    }
}
