package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash__screen );


        Thread thread=new Thread(){

            @Override
            public void run(){
                try {
                    sleep(3000);
                    Intent russplash=new Intent(getApplicationContext(),MainActivity.class);
                    startActivities(new Intent[]{russplash});
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }}};
        thread.start();
    }
}
