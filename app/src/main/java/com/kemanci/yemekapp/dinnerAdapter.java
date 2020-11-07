package com.kemanci.yemekapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;



public class dinnerAdapter extends ArrayAdapter<yemekModel> {

    private Context context;
    private List<yemekModel> yemekModelList;
    public dinnerAdapter(@NonNull Context context, List<yemekModel> yemekModelList) {
        super(context, R.layout.listtile_yemek,yemekModelList);
        this.context=context;
        this.yemekModelList=yemekModelList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View customView=layoutInflater.inflate(R.layout.listtile_yemek,parent,false);
        ImageView imageView=customView.findViewById(R.id.tileImage);
        TextView timeText=customView.findViewById(R.id.tileTime);
        TextView countText=customView.findViewById(R.id.tilePersonCount);
        TextView header=customView.findViewById(R.id.tileHeader);

        header.setText(yemekModelList.get(position).getYemekAdi());
        countText.setText(yemekModelList.get(position).getKackisi());
        timeText.setText(yemekModelList.get(position).getSuresi());

        imageView.setImageDrawable(yemekModelList.get(position)._drawable);


        return customView;
    }
}
