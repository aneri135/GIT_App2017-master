package com.git.gitapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

/**
 * Created by vidhi on 2/9/2019.
 */

public class ViewPageAdapter extends PagerAdapter {
    // Declare Variables
    Context context;
    private String path;
    private String[] filenames;
    //    String[] flag;
    int v;
    LayoutInflater inflater;

    public ViewPageAdapter(Context context, String path, String[] filenames) {
        this.context = context;
        this.path = path;
        this.filenames = filenames;

//        this.flag = flag;
    }

    @Override
    public int getCount() {
        return filenames.length;
//        return 1;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        ImageView imgflag;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.view_pager, container,
                false);


        // Locate the ImageView in viewpager_item.xml
        imgflag = (ImageView) itemView.findViewById(R.id.img_android);
        // Capture position and set to the ImageView

        Picasso.with(context).load("file:///android_asset/images/" + path + "/" + filenames[position]).resize(240, 120).into(imgflag);
//        imgflag.setImageResource("file:///android_asset/images/" + path + "/" + filenames[position]);
//        imgflag.setImageResource(Integer.parseInt(filenames[position]));
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int v, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}

