package huzefagadi.com.zoom.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import huzefagadi.com.zoom.R;


public class GridCard extends RelativeLayout {
    private Button heading;

    public GridCard(Context context) {
        super(context);
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
        Button button =(Button) findViewById(R.id.courseName);
        int btnSize=button.getLayoutParams().width;
        button.setLayoutParams(new LayoutParams(btnSize, btnSize));
        this.heading = button;

    }

    public void setText(String text)
    {
        this.heading.setText(text);
        this.heading.setTag(text);
    }

    public Button getButton()
    {
        return this.heading;
    }
}