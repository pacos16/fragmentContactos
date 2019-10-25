package com.pacosignes.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.IOnContactListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        FragmentListado fragmentListado=new FragmentListado();

    }


    @Override
    public void onContactClick(Contact c) {
        Intent i = new Intent(this, DetalleActivity.class);
        i.putExtra("holo",c);
        startActivity(i);
    }

    public RecyclerViewAdapter.IOnContactListener giveListener(){

        return this;

    }
}
