package huzefagadi.com.zoom.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import huzefagadi.com.zoom.R;
import huzefagadi.com.zoom.customviews.GridCard;

/**
 * Created by huzefaasger on 27-12-2016.
 */
public class GridViewAdapter extends BaseAdapter {
    private Context mContext;

    public GridViewAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return 10;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        GridCard gridCard;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            gridCard = new GridCard(mContext);
            gridCard.setText("Text" + position);
        } else {
            gridCard = (GridCard) convertView;
        }
        return gridCard;
    }


}
