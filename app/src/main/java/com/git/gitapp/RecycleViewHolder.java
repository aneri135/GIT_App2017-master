package com.git.gitapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Priya on 2/8/2019.
 */

class RecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView cDate, cTitle, cUrl;
    ImageView imageView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        cDate = (TextView) itemView.findViewById(R.id.cDate);
        cTitle = (TextView) itemView.findViewById(R.id.cTitle);
        imageView = (ImageView) itemView.findViewById(R.id.list_avatar);
//        cUrl=(ImageView) itemView.findViewById(R.id.cUrl);
    }
}
