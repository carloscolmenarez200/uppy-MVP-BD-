package com.developers.carlos.uppy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.developers.carlos.uppy.main.MainActivity;

public class BienvenidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
    }

    public void onClikEntrar(View v){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
