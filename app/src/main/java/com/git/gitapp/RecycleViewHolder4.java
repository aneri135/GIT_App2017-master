package com.git.gitapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Priya on 2/9/2019.
 */

class RecyclerViewHolder4 extends RecyclerView.ViewHolder {

    TextView fName, fExp, fQualification, fDesignation, fMail;
    ImageView imageView;

    public RecyclerViewHolder4(View itemView) {
        super(itemView);

        fName = (TextView) itemView.findViewById(R.id.fName);
        fExp = (TextView) itemView.findViewById(R.id.fExp);
        fMail = (TextView) itemView.findViewById(R.id.fMail);
        imageView = (ImageView) itemView.findViewById(R.id.fImg);
        fQualification = (TextView) itemView.findViewById(R.id.fQualification);
        fDesignation = (TextView) itemView.findViewById(R.id.fDesignation);


    }
}
