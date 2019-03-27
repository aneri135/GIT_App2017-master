package com.comman;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by Sumeet on 6/5/2016.
 */
public class MyCustomTextview extends TextView {

    public MyCustomTextview(Context context) {
        super(context);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/OpenSans-Semibold.ttf"));
    }
}
