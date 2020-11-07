package com.kemanci.yemekapp;


import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public static List<yemekModel> yemekler=new ArrayList<>();

    protected ListView ingredientsListView;
    protected EditText searchText;
    protected Toolbar bottomToolbar;

    protected ingredientsAdapter ingredientsAdapter;

    protected ArrayList<String> malzemeler=new ArrayList<>();
    static ArrayList<String> selectedItems=new ArrayList<>();
    protected LinearLayout waiter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateMalzemeler();

        waiter=findViewById(R.id.waitLayout);
        searchText=findViewById(R.id.searchText);
        bottomToolbar=findViewById(R.id.bottomBar);
        ingredientsListView=findViewById(R.id.listView);

        ingredientsListView=findViewById(R.id.listView);
        ingredientsAdapter=new ingredientsAdapter(this,malzemeler);
        ingredientsListView.setAdapter(ingredientsAdapter);

        searchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomToolbar.setVisibility(View.VISIBLE);
                ingredientsListView.setVisibility(View.VISIBLE);
            }
        });
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                bottomToolbar.setVisibility(View.VISIBLE);
                ingredientsAdapter.getFilter().filter(searchText.getText().toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bottomToolbar.setVisibility(View.VISIBLE);
                ingredientsAdapter.getFilter().filter(searchText.getText().toString());


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }



    public void mainButtonClick(View view){
        HideKeyboard();
        ingredientsListView.setVisibility(View.GONE);
        waiter.setVisibility(View.VISIBLE);
        String seacher="";
        for(String s:selectedItems){

            if(s.contains(" ")){
                String[] ss=s.split(" ");
                seacher+=","+ss[0]+ss[1];
            }
            else{
                seacher+=","+s;
            }
        }
        TaskRunner runner=new TaskRunner();
        runner.executeAsync(new RunningTask(seacher),(data) -> {

            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(intent);
            finish();
        });


    }



    public void HideKeyboard(){
        View view=this.getCurrentFocus();
        if(view!=null){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    private void populateMalzemeler(){
        malzemeler.add("Biber");
        malzemeler.add("Salça");
        malzemeler.add("Soğan");
        malzemeler.add("Ayçiçek Yağı");
        malzemeler.add("Zeytin Yağı");
        malzemeler.add("Badem Sütü");
        malzemeler.add("Beyaz Ekmek");
        malzemeler.add("Beyaz Un");
        malzemeler.add("Biber Salçası");
        malzemeler.add("Biber Turşusu");
        malzemeler.add("Buğday Nişastası");
        malzemeler.add("Ceviz İçi");
        malzemeler.add("Çeri Domates");
        malzemeler.add("Çubuk Makarna");
        malzemeler.add("Çubuk Tarçın");
        malzemeler.add("Dana Antrikot");
        malzemeler.add("Dana But");
        malzemeler.add("Dana Döş Eti");
        malzemeler.add("Dana Eti");
        malzemeler.add("Domates Salçası");
        malzemeler.add("Sarımsak");
        malzemeler.add("Tavuk Goğsü");
        malzemeler.add("Tavuk But");
        malzemeler.add("Tavuk Kalça");
        malzemeler.add("Tavuk Bonfile");
        malzemeler.add("Dana Kuşbaşı");
        malzemeler.add("Dana Kıyma");
        malzemeler.add("Bulgur");
        malzemeler.add("Pirinç");
        malzemeler.add("Domates");
        malzemeler.add("Patates");
        malzemeler.add("Balık");
        malzemeler.add("Kırmızı Mercimek");
        malzemeler.add("Kuru Fasulye");
        malzemeler.add("Taze Fasulye");
        malzemeler.add("Nohut");
        malzemeler.add("Yeşil Mercimek");
        malzemeler.add("Barbunya");
        malzemeler.add("Patlıcan");
        malzemeler.add("Kabak");
        malzemeler.add("Yumurta");
        malzemeler.add("Süt");
        malzemeler.add("Peynir");
        malzemeler.add("Maydanoz");
        malzemeler.add("Fesleğen");
        malzemeler.add("Dereotu");
        malzemeler.add("Semizotu");
        malzemeler.add("Karnabahar");
        malzemeler.add("Marul");
        malzemeler.add("Salatalık");
        malzemeler.add("Portakal");
        malzemeler.add("Mandalina");
        malzemeler.add("Elma");
        malzemeler.add("Şeftali");
        malzemeler.add("Kayısı");
        malzemeler.add("Tereyağ");
        malzemeler.add("Tarçın");
        malzemeler.add("Ceviz");
        malzemeler.add("Fındık");
        malzemeler.add("Kakao");
        malzemeler.add("Kabartma Tozu");
        malzemeler.add("Vanilya");
        malzemeler.add("Şekerli Vanilin");
        malzemeler.add("Muz");
        malzemeler.add("Avokado");
        malzemeler.add("Ananas");
        malzemeler.add("Yoğurt");
        malzemeler.add("Zeytin");
        malzemeler.add("Şeker");
        malzemeler.add("Tuz");
        malzemeler.add("Arpa Şehriye");
        malzemeler.add("Tel Şehriye");
        malzemeler.add("Bal Kabaği");
        malzemeler.add("Krem Şanti");
        malzemeler.add("Bisküvi");
        malzemeler.add("Havuç");
        malzemeler.add("Köri");
        malzemeler.add("Karabiber");
        malzemeler.add("Kimyon");
        malzemeler.add("Kekik");
        malzemeler.add("Bıldırcın");
        malzemeler.add("Bıldırcın Yumurtası");
        malzemeler.add("Muskat Cevizi");
        malzemeler.add("Mahlep");
        malzemeler.add("Zencefil");
        malzemeler.add("Karanfil");
        malzemeler.add("Limon");
        malzemeler.add("Limon Tuzu");
        malzemeler.add("Pudra Şekeri");
        malzemeler.add("Karides");
        malzemeler.add("Mantar");
        malzemeler.add("Kuru Maya");
        malzemeler.add("Yaş Maya");
        malzemeler.add("Biberiye");
        malzemeler.add("Yulaf");
        malzemeler.add("Tahin");
        malzemeler.add("Milföy");
        malzemeler.add("Pekmez");
        malzemeler.add("Bal");
        malzemeler.add("Su");
        malzemeler.add("Kuzu Kuşbaşı");
        malzemeler.add("Kuzu Kıyma");
        malzemeler.add("Susam");
        malzemeler.add("Çörekotu");
        malzemeler.add("Çilek");
        malzemeler.add("Karpuz");
        malzemeler.add("Kavun");
        malzemeler.add("Hindistan Cevizi");
        malzemeler.add("Pul Biber");
        malzemeler.add("Brokoli");
        malzemeler.add("Lahana");
        malzemeler.add("Brüksel Lahanası");
        malzemeler.add("Pırasa");
        malzemeler.add("Ispanak");
        malzemeler.add("Ciğer");
        malzemeler.add("Asma Yaprağı");
        malzemeler.add("Roka");
        malzemeler.add("Sirke");
        malzemeler.add("Turşu");
        malzemeler.add("Ketçap");
        malzemeler.add("Mayonez");
        malzemeler.add("Hardal");
        malzemeler.add("Hindi");
        malzemeler.add("Bezelye");
        malzemeler.add("Kereviz");
        malzemeler.add("Mısır");
        malzemeler.add("Bakla");
        malzemeler.add("Enginar");
        malzemeler.add("Krema");
        malzemeler.add("Ayva");
        malzemeler.add("Balsamik Sirke");
        malzemeler.add("Bamya");
        malzemeler.add("Nişasta");
        malzemeler.add("Chia Tohumu");
        malzemeler.add("Makarna");
        malzemeler.add("Damla Sakızı");
        malzemeler.add("Defne Yaprağı");
        malzemeler.add("Dolmalık Biber");
        malzemeler.add("Kırmızı Biber");
        malzemeler.add("Deniz Tuzu");
        malzemeler.add("Dolmalık Fıstık");
        malzemeler.add("Dana Kuşbaşı");
        malzemeler.add("Galeta Unu");
        malzemeler.add("Ekmek İçi");
        malzemeler.add("İrmik");
        malzemeler.add("Kahve");
        malzemeler.add("Kapari");
        malzemeler.add("Kapya Biberi");
        malzemeler.add("Karbonat");
        malzemeler.add("Kaymak");
        malzemeler.add("Jalepano");
        malzemeler.add("Nohut");
        malzemeler.add("Kuş Üzümü");
        malzemeler.add("Labne Peyniri");
        malzemeler.add("Lazanya");
        malzemeler.add("Lime");
        malzemeler.add("Maden Suyu");
        malzemeler.add("Margarin");
        malzemeler.add("Mısır Gevreği");
        malzemeler.add("Nane");
        malzemeler.add("Nar Ekşisi");
        malzemeler.add("Pancar");
        malzemeler.add("Şalgam");
        malzemeler.add("Turp");
        malzemeler.add("Pirinç Unu");
        malzemeler.add("Portakal Kabuğu");
        malzemeler.add("Limon Kabuğu");
        malzemeler.add("Portakal Suyu");
        malzemeler.add("Limon Suyu");
        malzemeler.add("Çipura");
        malzemeler.add("Hamsi");
        malzemeler.add("Levrek");
        malzemeler.add("Palamut");
        malzemeler.add("Somon");
        malzemeler.add("Parmesan");
        malzemeler.add("Kaşar");
        malzemeler.add("Beyaz Peynir");
        malzemeler.add("Soya Sosu");
        malzemeler.add("Sumak");
        malzemeler.add("Et Suyu");
        malzemeler.add("Tavuk Suyu");
        malzemeler.add("Süzme Yoğurt");
        malzemeler.add("Tortilla Ekmeği");
        malzemeler.add("Antep Fıstığı");
        malzemeler.add("Yeni Bahar");
        malzemeler.add("Yeşil Soğan");
        malzemeler.add("Toz Kırmızı Biber");
        malzemeler.add("Yufka");
        malzemeler.add("Zerdeçal");
        malzemeler.add("Beyaz Biber");
        malzemeler.add("Mısır Unu");
        malzemeler.add("Ekmek İçi(Bayat)");
        malzemeler.add("Elma Sirkesi");
        malzemeler.add("Esmer Şeker");
        malzemeler.add("Fasulye");
        malzemeler.add("Hamburger Ekmeği");
        malzemeler.add("Haşlanmış Mısır");
        malzemeler.add("Hazır Kek");
        malzemeler.add("Ilık Su");
        malzemeler.add("İnce Bulgur");
        malzemeler.add("İstavrit");
        malzemeler.add("Kalamar");
        malzemeler.add("Kereviz Sapı");
        malzemeler.add("Kesme Şeker");
        malzemeler.add("Kırık Buz");
        malzemeler.add("Kırmızı Biber");
        malzemeler.add("Kırmızı Jalapeno Biberi");
        malzemeler.add("Kırmızı Lahana");
        malzemeler.add("Kırmızı Soğan");
        malzemeler.add("Kişniş Tohumu");
        malzemeler.add("Kıvırcık Marul");
        malzemeler.add("Kültür Mantarı");
        malzemeler.add("Küp Kesme Şeker");
        malzemeler.add("Kuru Soğan");
        malzemeler.add("Kurutulmuş Domates");
        malzemeler.add("Kuşbaşı");
        malzemeler.add("Kuzu But");
        malzemeler.add("Kuzu Ciğeri");
        malzemeler.add("Portakal Suyu");
        malzemeler.add("Lemongrass");
        malzemeler.add("Kıyma");
        malzemeler.add("Mısır Nişastası");
        malzemeler.add("Mozarella Peyniri");
        malzemeler.add("Nane Yaprağı");
        malzemeler.add("Petibör Bisküvi");
        malzemeler.add("Rende");
        malzemeler.add("Rendelenmiş Kaşar Peyniri");
        malzemeler.add("Rendelenmiş Parmesan Peyniri");
        malzemeler.add("Rendelenmiş Limon Kabuğu");
        malzemeler.add("Rendelenmiş Portakal Kabuğu");
        malzemeler.add("Vişne");
        malzemeler.add("Rom");
        malzemeler.add("Sade Soda");
        malzemeler.add("Salatalık Turşusu");
        malzemeler.add("Sarı Dolmalık Biber");
        malzemeler.add("Şehriye");
        malzemeler.add("Sıcak Et Suyu");
        malzemeler.add("Sıcak Su");
        malzemeler.add("Sıvı Yağ");
        malzemeler.add("Sivri Biber");
        malzemeler.add("Soda");
        malzemeler.add("Somon Fileto");
        malzemeler.add("Tane Karabiber");
        malzemeler.add("Tatlı Toz Kırmızı Biber");
        malzemeler.add("Toz Şeker");
        malzemeler.add("Vanilya Özütü");
        malzemeler.add("Vanilya Çubuğu");
        malzemeler.add("Yemi");
        malzemeler.add("Yeşil Biber");
        malzemeler.add("Yulaflı Bisküvi");
        malzemeler.add("Kedi Dili");
        malzemeler.add("Yumurta Sarısı");
        malzemeler.add("Yumurta Akı");
        malzemeler.add("Yumurtalı Fettucini Alfredo");

    }
}