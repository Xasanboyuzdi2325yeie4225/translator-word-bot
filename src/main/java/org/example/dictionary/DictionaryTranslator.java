package org.example.dictionary;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.dictionary.module.Root;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class DictionaryTranslator {
    private static final String API_KEY = "dict.1.1.20230619T100631Z.a68e0f34bb39286a.b84925c575596f86a298e92a727afc764f00a01d";
    private static final String LANG_URL = "https://dictionary.yandex.net/api/v1/dicservice.json/getLangs?key=" + API_KEY;

    public String  getResult(String o,String n,String a) {
        System.out.println("old: "+o+", new: "+n+", text: "+a);
         final String TRANSLATE_URL = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=" + API_KEY + "&lang="+o+"-"+n+"&text="+a;

        Gson gson=new Gson();
        try {

            URL url = new URL(TRANSLATE_URL);
            URLConnection connection = url.openConnection();
            InputStreamReader inputStreamReader=new InputStreamReader(new BufferedInputStream(connection.getInputStream()));
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String text=null;
            String json="";
            while ((text= bufferedReader.readLine())!=null){
                json+=text;
            }
            Type type=new TypeToken<List<Root>>(){}.getType();
            System.out.println(gson.fromJson(json, Root.class).def.get(0).tr.get(0).text);
            return gson.fromJson(json, Root.class).def.get(0).tr.get(0).text;
        }catch (Exception e){

            return "Error: "+e.getMessage();
        }

    }


    public List<String> getAllLanguage(){
        Gson gson=new Gson();
        URL url=null;
        URLConnection connection=null;
        try {
            url = new URL(LANG_URL);
            connection = url.openConnection();
            InputStreamReader inputStreamReader=new InputStreamReader(new BufferedInputStream(connection.getInputStream()));
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String text=null;
            String json="";
            while ((text= bufferedReader.readLine())!=null){
                json+=text;
            }
            Type type=new TypeToken<String[]>(){}.getType();

            return (List.of(gson.fromJson(json, String[].class)));
        }catch (Exception e){
        return null;
        }


    }



}
