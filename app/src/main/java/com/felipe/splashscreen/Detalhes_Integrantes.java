package com.felipe.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalhes_Integrantes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_integrantes);
        Intent i = getIntent();
        TextView RA = findViewById(R.id.RA);
        TextView nome = findViewById(R.id.nome);
        ImageView image = findViewById(R.id.foto);
        RA.setText(i.getStringExtra("RA"));
        nome.setText(i.getStringExtra("name"));
        image.setImageResource(Integer.parseInt(i.getStringExtra("image")));
    }


}