package huzefagadi.com.zoom.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import android.widget.TextView;

import huzefagadi.com.zoom.R;
import huzefagadi.com.zoom.activities.MainActivity;


public class GridCard extends RelativeLayout {
    private TextView heading;
    private int screenWidth;
    public GridCard(Context context) {
        super(context);
        DisplayMetrics metrics = new DisplayMetrics();
        ((MainActivity)context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenWidth = metrics.widthPixels;
        init();
    }

    public GridCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GridCard(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.grid_card, this);
        TextView button =(TextView) findViewById(R.id.courseName2);
        int btnSize=(screenWidth/2)-20;
        button.setLayoutParams(new LayoutParams(btnSize, btnSize));
        button.setWidth(screenWidth);
        button.setHeight(screenWidth);
        this.heading = button;

    }

    public void setText(String text)
    {
        this.heading.setText(text);
        this.heading.setTag(text);
    }

    public TextView getButton()
    {
        return this.heading;
    }
}