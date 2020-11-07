package com.kemanci.yemekapp;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import static com.kemanci.yemekapp.MainActivity.selectedItems;
import static com.kemanci.yemekapp.MainActivity.yemekler;

public class MainActivity2 extends AppCompatActivity {

    protected ListView dinnerListView;
    private TextView sonucSayisi;
    dinnerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sonucSayisi=findViewById(R.id.sonucSayisi);


        sonucSayisi.setText(yemekler.size()+"");

        dinnerListView=findViewById(R.id.dinnerListView);
        adapter=new dinnerAdapter(getApplicationContext(),yemekler);
        dinnerListView.setAdapter(adapter);



        dinnerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                singleton.secilenYemek= yemekler.get(position);
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
            }
        });
    }

    public void back(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        adapter.clear();
        yemekler.clear();
        selectedItems.clear();
        this.finishActivity(0);
    }
}