package com.kemanci.yemekapp;

import android.graphics.drawable.Drawable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static com.kemanci.yemekapp.MainActivity.yemekler;

public class RunningTask implements Callable<JSONObject> {
    private final String input;

    public RunningTask(String input) {
        this.input = input;
    }

    @Override
    public JSONObject call() throws IOException, JSONException,MalformedURLException {
        String _url="https://tarifler.azurewebsites.net/search/"+input+"/apikey=982523";
        URL url=new URL(_url);
        System.out.println(_url);
        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
        BufferedReader bf=new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String br="";
        String full="";
        while ((br=bf.readLine())!=null){
            full+=br;
        }

        JSONObject data=new JSONObject(full);


        JSONArray jsonArray=data.getJSONArray("yemekler");

        for(int i=0;i<jsonArray.length();i++) {
            JSONObject gecici = (JSONObject) jsonArray.get(i);
            JSONArray geciciArray = gecici.getJSONArray("malzemeler");
            List<malzeme> _malzemeler = new ArrayList<>();
            for (int j = 0; j < geciciArray.length(); j++) {
                String birim = ((JSONObject) geciciArray.get(j)).getString("birim");
                String miktar = ((JSONObject) geciciArray.get(j)).getString("miktar");
                String malzemeAdi = ((JSONObject) geciciArray.get(j)).getString("malzemeAdi");
                _malzemeler.add(new malzeme(birim, miktar, malzemeAdi));
            }
            String yemekAdi = gecici.getString("yemekAdi");
            String tarifi = gecici.getString("tarif");
            String suresi = gecici.getString("süresi");
            String kackisi = gecici.getString("kacKisi");
            String image = gecici.getString("url");

            yemekModel yemek = new yemekModel(yemekAdi, suresi, kackisi, tarifi, image, _malzemeler);
            URL urle = new URL("https://tarifler.azurewebsites.net/"+image);

            InputStream content = (InputStream)urle.getContent();

            Drawable d = Drawable.createFromStream(content , "src");

            yemek._drawable=d;
            yemekler.add(yemek);

        }

        return data;
    }
}
