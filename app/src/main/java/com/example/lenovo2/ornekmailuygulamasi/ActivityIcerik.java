package com.example.lenovo2.ornekmailuygulamasi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class ActivityIcerik extends AppCompatActivity{

    MailIcerikFrag mailIcerikFrag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }
        int pozisyon=getIntent().getIntExtra("pozisyon",0);
        mailIcerikFrag = new MailIcerikFrag(pozisyon);
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(android.R.id.content,mailIcerikFrag);
        transaction.commit();


    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mailIcerikFrag != null){
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.remove(mailIcerikFrag);
            transaction.commit();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if(item.getItemId()==android.R.id.home){
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            NavUtils.navigateUpTo(this,intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
