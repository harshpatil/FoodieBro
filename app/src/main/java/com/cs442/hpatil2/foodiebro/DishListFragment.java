package com.cs442.hpatil2.foodiebro;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by HarshPatil on 9/25/16.
 */
public class DishListFragment extends ListFragment {

    private DishListListener dishListListener;

    public interface DishListListener {
        public void onLongPress(int dishNumber);
        public void onDishClick(int dishNumber);
    }

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int itemPosition, long id) {
                dishListListener.onLongPress(itemPosition);
                return true;
            }
        });
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        dishListListener.onDishClick(position);
    }

        @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            dishListListener = (DishListListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() +
                    "");
        }
    }
}
