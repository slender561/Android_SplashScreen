package com.felipe.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalhesIntegrantes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_integrantes);
        Intent i = getIntent();
        TextView RA = findViewById(R.id.RA);
        TextView nome = findViewById(R.id.nome);
        ImageView image = findViewById(R.id.foto);
        TextView github = findViewById(R.id.github);
        RA.setText(i.getStringExtra("RA"));
        nome.setText(i.getStringExtra("name"));
        image.setImageResource(Integer.parseInt(i.getStringExtra("image")));
        github.setMovementMethod(LinkMovementMethod.getInstance());
        github.setLinkTextColor(Color.BLUE);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Intent.ACTION_VIEW, Uri.parse(i.getStringExtra("github")));
                startActivity(in);
            }
        });
    }


}