package com.git.gitapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Priya on 2/8/2019.
 */

class RecyclerAdapter1 extends RecyclerView.Adapter<RecyclerViewHolder1> {

    //    String [] name={"Androidwarriors","Stackoverflow","Developer Android","AndroidHive",
//            "Slidenerd","TheNewBoston","Truiton","HmkCode","JavaTpoint","Javapeper"};
    Context context;
    LayoutInflater inflater;

    List<Data> data = Collections.emptyList();

    public RecyclerAdapter1(Context context, List<Data> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;

    }


    @Override
    public RecyclerViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.list_news, parent, false);

        RecyclerViewHolder1 viewHolder = new RecyclerViewHolder1(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder1 holder, int position) {


        RecyclerViewHolder1 myHolder = (RecyclerViewHolder1) holder;
        Data current = data.get(position);
        myHolder.nDate.setText(current.nDate);
        myHolder.nTitle.setText(current.nTitle);

    }


    @Override
    public int getItemCount() {

        return data.size();

    }

    class RecycleViewHolder1 extends RecyclerView.ViewHolder {

        TextView nDate, nTitle;


        // create constructor to get widget reference
        public RecycleViewHolder1(View itemView) {
            super(itemView);
            nDate = (TextView) itemView.findViewById(R.id.nDate);
            nTitle = (TextView) itemView.findViewById(R.id.nTitle);

        }

    }


}
