package com.example.dongja94.samplecustomchoicelist;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dongja94 on 2016-01-14.
 */
public class ItemView extends FrameLayout implements Checkable {
    public ItemView(Context context) {
        super(context);
        init();
    }

    TextView titleView;
    ImageView checkView, selectorView;

    private void init() {
        inflate(getContext(), R.layout.view_item, this);
        titleView = (TextView)findViewById(R.id.text_title);
        checkView = (ImageView)findViewById(R.id.image_check);
        selectorView = (ImageView)findViewById(R.id.image_selector);
    }

    public void setText(String text) {
        titleView.setText(text);
    }

    boolean isChecked;

    private void drawCheck() {
        if (isChecked) {
//            checkView.setImageResource(android.R.drawable.checkbox_on_background);
//            setBackgroundColor(Color.RED);
            selectorView.setVisibility(View.VISIBLE);
        } else {
//            checkView.setImageResource(android.R.drawable.checkbox_off_background);
//            setBackgroundColor(Color.TRANSPARENT);
            selectorView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void setChecked(boolean checked) {
        if (isChecked != checked) {
            isChecked = checked;
            drawCheck();
        }
    }

    @Override
    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void toggle() {
        setChecked(!isChecked);
    }
}
