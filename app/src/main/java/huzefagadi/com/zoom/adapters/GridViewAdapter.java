package huzefagadi.com.zoom.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import huzefagadi.com.zoom.Constants;
import huzefagadi.com.zoom.R;
import huzefagadi.com.zoom.customviews.GridCard;
import huzefagadi.com.zoom.fragments.HomeFragment;

/**
 * Created by huzefaasger on 27-12-2016.
 */
public class GridViewAdapter extends BaseAdapter {
    private Context mContext;
    private Fragment fragment;
    private String fragmentName;
    public GridViewAdapter(Context c, Fragment fragment,String fragmentName) {
        mContext = c;
        this.fragment = fragment;
        this.fragmentName=fragmentName;
    }

    public int getCount() {
        return Constants.COURSES.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        final GridCard gridCard;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            gridCard = new GridCard(mContext);

        } else {
            gridCard = (GridCard) convertView;
        }
        gridCard.setText(Constants.COURSES[position]);
        gridCard.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(fragmentName.equalsIgnoreCase("HomeFragment"))
               {
                   HomeFragment homeFragment = (HomeFragment)fragment;
                   homeFragment.onButtonPressed(String.valueOf(view.getTag()));
               }
            }
        });
        return gridCard;
    }


}
