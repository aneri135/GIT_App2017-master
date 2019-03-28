package com.git.gitapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.support.v7.recyclerview.R.styleable.RecyclerView;

/**
 * Created by vidhi on 2/9/2019.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<AndroidVersion> android;
    private Context context;
//    public int i;
//    public String name=android.get(i).getAndroid_version_name();


    public DataAdapter(Context context, ArrayList<AndroidVersion> android) {
        this.android = android;
        this.context = context;


    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        Picasso.with(context).load(android.get(i).getAndroid_image_url()).resize(200, 150).into(viewHolder.img_android);
        viewHolder.tv_android.setText(android.get(i).getAndroid_version_name());
        final String name = (String) viewHolder.tv_android.getText();
        Log.e("name", name);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, FolderImage.class);
//                i.putExtra("pos",getAdapterPosition());
                if (name.equals("Jazba")) {
                    i.putExtra("name", "Jazba");
                } else if (name.equals("TX")) {
                    i.putExtra("name", "TX");
                } else if (name.equals("Ratri B4 Navratri")) {
                    i.putExtra("name", "Ratri B4 Navratri");
                } else if (name.equals("Annual Sports")) {
                    i.putExtra("name", "Annual Sports");
                } else {
                    i.putExtra("name", "Kite Festival");
                }

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return android.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        //        private TextView tv_android;
        private ImageView img_android;
        public TextView tv_android;
//

        public ViewHolder(View view) {
            super(view);

            tv_android = (TextView) view.findViewById(R.id.tv_android);
            img_android = (ImageView) view.findViewById(R.id.img_android);

//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Intent i=new Intent(context,FolderImage.class);
//                    i.putExtra("pos",getAdapterPosition());
//                    if (name.equals("Jazba")) {
//                        i.putExtra("name", "Jazba");
//                    }
//                    else if(name.equals("TX")) {
//                        i.putExtra("name","TX");
//                    }
//
//                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(i);
//                }
//            });


        }


    }


}

