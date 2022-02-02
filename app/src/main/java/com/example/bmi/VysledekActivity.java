package com.example.bmi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import static java.util.Objects.requireNonNull;


public class VysledekActivity extends AppCompatActivity {


    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vysledek);


        Double vysledek = null;
        String skupina = null;
        ImageView img = findViewById(R.id.imageView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            vysledek = extras.getDouble("vysledek");
            skupina = extras.getString("kategorie");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            switch (requireNonNull(skupina)) {
                case "pod":
                img.setImageResource(R.drawable.fuj);
                    break;
                case "norm":
                    img.setImageResource(R.drawable.normal);
                    break;
                case "nad":
                    img.setImageResource(R.drawable.fatty);
                    break;
                case "hodneNad":
                    img.setImageResource(R.drawable.fat);
                    break;
                default:
                    img.setImageResource(R.drawable.unknown);
                    break;


            }


            TextView vysledekTxt = findViewById(R.id.textView7);
            vysledekTxt.setText(vysledek.toString());


        }

    }
        public void jdiZpet(View v)
        {

            Intent navrat = new Intent();
            setResult(RESULT_OK, navrat);
            finish();

        }
    }

