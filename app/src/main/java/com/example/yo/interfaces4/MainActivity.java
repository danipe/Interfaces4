package com.example.yo.interfaces4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    CheckBox cb;
    TextView tvMostrar, tvLong, tvRating;
    RatingBar rb;
    LinearLayout ll;
    boolean fondo=false, letras=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = (LinearLayout) findViewById(R.id.layoutFondo);
        b1 = (Button) findViewById(R.id.botonFondo);
        b2 = (Button) findViewById(R.id.botonLetras);
        cb = (CheckBox) findViewById(R.id.checkMostrar);
        tvMostrar = (TextView) findViewById(R.id.textoMostrar);
        tvLong = (TextView) findViewById(R.id.clickLargo);
        tvLong.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getApplicationContext(),"El toast aparece por arte de magia",Toast.LENGTH_LONG).show();
                return false;
            }
        });
        tvRating = (TextView) findViewById(R.id.textoRatingBar);
        rb = (RatingBar) findViewById(R.id.ratingBar);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                tvRating.setText("["+v+"/5]");
            }
        });
    }

    public void cambiarFondo(View v) {
        if(fondo){
            ll.setBackgroundColor(Color.WHITE);
            b1.setText("fondo rojo");
        }else{
            ll.setBackgroundColor(Color.RED);
            b1.setText("fondo blanco");
        }
        fondo = !fondo;
    }

    public void cambiarLetras(View v) {
        if(letras){
            b2.setText("letras rojas");
            b2.setTextColor(Color.BLACK);
        }else{
            b2.setText("letras negras");
            b2.setTextColor(Color.RED);
        }
        letras = !letras;
    }

    public void checkBox(View v) {
        if(cb.isChecked()){
            tvMostrar.setVisibility(View.VISIBLE);
        }else{
            tvMostrar.setVisibility(View.INVISIBLE);
        }
    }
}

