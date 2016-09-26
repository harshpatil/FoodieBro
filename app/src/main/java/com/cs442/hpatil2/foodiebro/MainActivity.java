package com.cs442.hpatil2.foodiebro;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.cs442.hpatil2.foodiebro.model.Dish;

import java.util.ArrayList;

/**
 * Created by HarshPatil on 9/25/16.
 */
public class MainActivity extends AppCompatActivity implements AddDishFragment.OnNewDishAddedListener, DishListFragment.DishListListener{

    private ArrayList<Dish> dishList = new ArrayList<Dish>();
    private DishAdapter dishAdapter;
    int itemId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        DishListFragment dishListFragment = (DishListFragment) fragmentManager.findFragmentById(R.id.DishListFragment);
        int resID = R.layout.dish_list_layout;
        dishAdapter = new DishAdapter(this, resID, dishList);
        dishListFragment.setListAdapter(dishAdapter);
        fetchData();
    }

    public void onNewDishAdded(String name, String price, String description, int imageId){

        FragmentManager fm = getFragmentManager();
        DishListFragment dishListFragment = (DishListFragment)fm.findFragmentById(R.id.DishListFragment);
        Dish dish = new Dish(name, price, description, itemId++, imageId);
        dishList.add(dishList.size(), dish);
        dishAdapter.notifyDataSetChanged();
        dishListFragment.getListView().smoothScrollToPosition(dishList.size());
    }

    public void onLongPress(int position){
        Dish item = dishList.get(position);
        dishList.remove(position);
        dishAdapter.notifyDataSetChanged();
        Toast.makeText(dishAdapter.getContext(), item.getName() +" removed from menu", Toast.LENGTH_LONG).show();
    }

    public void onDishClick(int position){
        dishList.get(position);
        Toast.makeText(dishAdapter.getContext(), "Dish Details \nName:" + dishList.get(position).getName() + " \nPrice:" + dishList.get(position).getPrice() + " \nIngredients:" + dishList.get(position).getDescription(), Toast.LENGTH_LONG).show();
    }

    public void fetchData(){
        Dish dish1 = new Dish("Masala Dosa","$20","Rice, Potato, Ghee \nTaste:Medium Spicy", itemId++, R.drawable.dosa);
        dishList.add(dishList.size(), dish1);
        dishAdapter.notifyDataSetChanged();
        Dish dish2 = new Dish("Burger","$10","Bun, Potato Patty, Cheese \nTaste:Medium Spicy", itemId++, R.drawable.burger);
        dishList.add(dishList.size(), dish2);
        dishAdapter.notifyDataSetChanged();
        Dish dish3 = new Dish("Kanda Pohe","$15","Pohe, Onion, Groundnut \nTaste:Medium Spicy", itemId++, R.drawable.pohe);
        dishList.add(dishList.size(), dish3);
        dishAdapter.notifyDataSetChanged();
        Dish dish4 = new Dish("Paneer Masala","$25","Paneer, Indian spices, Tomato \nTaste:Medium Spicy", itemId++, R.drawable.paneer);
        dishList.add(dishList.size(), dish4);
        dishAdapter.notifyDataSetChanged();
        Dish dish5 = new Dish("Dum Biriyani","$30","Rice, Spices, Vegetables \nTaste:Very Spicy", itemId++, R.drawable.biriyani);
        dishList.add(dishList.size(), dish5);
        dishAdapter.notifyDataSetChanged();
        Dish dish6 = new Dish("Jalebi","$40","Maida, Sugar, Kesar \nTaste:Sweet", itemId++, R.drawable.jalebi);
        dishList.add(dishList.size(), dish6);
        dishAdapter.notifyDataSetChanged();
        Dish dish7 = new Dish("Gulab Jaamun","$50","Maida, Sugar, Ghee \nTaste:Sweet", itemId++, R.drawable.jaamun);
        dishList.add(dishList.size(), dish7);
        dishAdapter.notifyDataSetChanged();
    }
}
