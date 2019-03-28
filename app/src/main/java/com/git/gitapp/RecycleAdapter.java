package com.git.gitapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    //    String [] name={"Androidwarriors","Stackoverflow","Developer Android","AndroidHive",
//            "Slidenerd","TheNewBoston","Truiton","HmkCode","JavaTpoint","Javapeper"};
    Context context;
    LayoutInflater inflater;

    List<Data> data = Collections.emptyList();

    public RecyclerAdapter(Context context, List<Data> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.list_item, parent, false);

        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {


        RecyclerViewHolder myHolder = (RecyclerViewHolder) holder;
        Data current = data.get(position);
        myHolder.cDate.setText(current.cDate);
        myHolder.cTitle.setText(current.cTitle);

        myHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = data.get(position).cUrl;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {

        return data.size();

    }

    class RecycleViewHolder extends RecyclerView.ViewHolder {

        TextView cDate, cTitle, cUrl;


        // create constructor to get widget reference
        public RecycleViewHolder(View itemView) {
            super(itemView);
            cDate = (TextView) itemView.findViewById(R.id.cDate);
            cTitle = (TextView) itemView.findViewById(R.id.cTitle);
//            cUrl=(TextView) itemView.findViewById(R.id.cUrl);

        }

    }


}
