package com.kemanci.yemekapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity3 extends AppCompatActivity {

    protected TextView tarifText;
    protected TextView sureText;
    protected TextView countText;
    protected TextView malzemelerText;
    protected TextView headerText;
    protected ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tarifText=findViewById(R.id.tarifText);
        sureText=findViewById(R.id.timeText);
        countText=findViewById(R.id.countText);
        headerText=findViewById(R.id.headerText);
        malzemelerText=findViewById(R.id.malzemelerText);
        imageView=findViewById(R.id.openImage);


        sureText.setText(singleton.secilenYemek.getSuresi());
        countText.setText(singleton.secilenYemek.getKackisi());
        imageView.setImageDrawable(singleton.secilenYemek._drawable);

        headerText.setText(singleton.secilenYemek.getYemekAdi());

        malzemelerText.setText("\n");
        for(malzeme m:singleton.secilenYemek.getMalzemeler()){
            String gecici=malzemelerText.getText().toString();
            malzemelerText.setText(gecici+m.miktar+" "+m.birim+" "+m.malzemeAdi+"\n");
        }

        int c=0;
        tarifText.setText("\n");
        for (String s:singleton.secilenYemek.getTarif().split("[|]")){
            c++;
            String gecici=tarifText.getText().toString();
            tarifText.setText(gecici+c+". "+s+"\n\n");

        }
    }

    public void back2(View v){
        finish();
    }
}