package com.git.gitapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by vidhi on 2/21/2019.
 */
public class FolderImageAdapter extends RecyclerView.Adapter<FolderImageAdapter.ViewHolder> {
    private Context context;
    private String path;
    private String[] fileNames;


    public FolderImageAdapter(Context context, String path, String[] fileNames) {
        this.context = context;
        this.path = path;
        this.fileNames = fileNames;

    }

    @Override
    public FolderImageAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.folder_image, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FolderImageAdapter.ViewHolder viewHolder, int i) {


        Picasso.with(context).load("file:///android_asset/images/" + path + "/" + fileNames[i]).resize(240, 120).into(viewHolder.img_android);

    }

    @Override
    public int getItemCount() {
        return fileNames.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_android;

        public ViewHolder(View view) {
            super(view);


            img_android = (ImageView) view.findViewById(R.id.img_android);

            img_android.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, ViewPage.class);
                    i.putExtra("pos", getAdapterPosition());
                    if (path.equals("Jazba")) {
                        i.putExtra("path", "Jazba");
                    }
                    else if(path.equals("TX")) {
                        i.putExtra("path","TX");
                    }
                    else if(path.equals("Ratri B4 Navratri")) {
                        i.putExtra("path","Ratri B4 Navratri");
                    }
                    else if(path.equals("Annual Sports")) {
                        i.putExtra("path","Annual Sports");
                    }
                    else {
                        i.putExtra("path","Kite Festival");
                    }
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);

                }
            });
        }
    }
}

