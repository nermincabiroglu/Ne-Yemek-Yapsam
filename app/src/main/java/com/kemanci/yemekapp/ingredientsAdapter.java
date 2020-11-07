package com.kemanci.yemekapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


import static com.kemanci.yemekapp.MainActivity.selectedItems;

public class ingredientsAdapter extends ArrayAdapter<String> implements Filterable {


    private ArrayList<String> malzemeler;
    private ArrayList<String> malzemelerFull;
    private Context context;

    public ingredientsAdapter(@NonNull Context context, ArrayList<String> malzemeler) {
        super(context, R.layout.listtile_malzeme,malzemeler);
        this.context=context;
        this.malzemeler=malzemeler;
        malzemelerFull=new ArrayList<>(malzemeler);
        this.malzemeler.clear();
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View customView=inflater.inflate(R.layout.listtile_malzeme,parent,false);
        TextView textView = customView.findViewById(R.id.listTileNameText);
        CheckBox checkBox=customView.findViewById(R.id.listTileAddButton);
        textView.setText(malzemeler.get(position));


        /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        */
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if(!selectedItems.contains(malzemeler.get(position))){
                        selectedItems.add(malzemeler.get(position));
                        System.out.println(malzemeler.get(position)+" malzemele eklendi");
                    }
                }
                else{
                    selectedItems.remove(malzemeler.get(position));
                    System.out.println(malzemeler.get(position)+" malzeme çıkarıldı");
                }
            }
        });




        return customView;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return malzemeFilter;
    }


    private Filter malzemeFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {


            ArrayList<String> filteringMalzeme=new ArrayList<>();
            if(constraint==null||constraint.length()==0){
                filteringMalzeme.addAll(malzemelerFull);
            }
            else{
                String pattern=constraint.toString().toLowerCase().trim();
                for(String call:malzemelerFull){
                    if(call.trim().toLowerCase().contains(pattern)||call.startsWith(pattern)){
                        filteringMalzeme.add(call);
                    }
                }
            }

            FilterResults filterResults=new FilterResults();
            filterResults.values=filteringMalzeme;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            malzemeler.clear();
            malzemeler.addAll((ArrayList)results.values);
            notifyDataSetChanged();


        }
    };

}
