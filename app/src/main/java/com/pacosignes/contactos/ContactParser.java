package com.pacosignes.contactos;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class ContactParser {

    private Contact[] contacts;
    private Context context;

    public ContactParser(Context context){

        this.context=context;

    }


    public void parse(){
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.contacts);

            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            String json= new String(buffer,"UTF-8");
            JSONArray array= new JSONArray(json);
            contacts=new Contact[array.length()];

            for(int i=0;i<array.length();i++){

                JSONObject jsonObject=array.getJSONObject(i);
                int id=jsonObject.getInt("id");
                String name=jsonObject.getString("name");
                String firstSurname=jsonObject.getString("firstSurname");
                String secondSurname=jsonObject.getString("secondSurname");
                String photo=jsonObject.getString("photo");
                String birth=jsonObject.getString("birth");
                String company=jsonObject.getString("company");
                String email=jsonObject.getString("email");
                String phone1=jsonObject.getString("phone1");
                String phone2=jsonObject.getString("phone2");
                String adress=jsonObject.getString("address");
                contacts[i]=new Contact(id,name,firstSurname,secondSurname,photo,
                        birth,company,email,phone1,phone2,adress);
            }

        }catch (IOException ioe){

        }catch (JSONException jsone){

        }
    }

    public Contact[] getContacts(){
        return contacts;
    }
}
