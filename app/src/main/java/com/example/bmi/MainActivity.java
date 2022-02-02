package com.example.bmi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.bmi.R.id.switch1;
import static com.example.bmi.R.id.vahaValue;
import static com.example.bmi.R.id.vyskaValue;


public class MainActivity extends AppCompatActivity {
    double BMI;
String kategorie="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);


    }


    @SuppressLint("SetTextI18n")
    public void onClickButton(View view){
        EditText vaha = findViewById(vahaValue);
        EditText vyska= findViewById(vyskaValue);


       String err = "chyba: zadej váhu a výšku";
if(vaha.getText().toString().matches("")||vyska.getText().toString().matches("")) {

    Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }
else{
    RadioButton centimetryRadioButton = findViewById(R.id.radioButton);

    double vahaValue = Double.parseDouble(vaha.getText().toString());
    double vyskaValue =  Double.parseDouble(vyska.getText().toString());

    if (centimetryRadioButton.isChecked()){ vyskaValue = vyskaValue / 100;}
    BMI = vahaValue / (vyskaValue * vyskaValue);
    //String vysledekBMI = Double.toString(BMI);
    TextView vetaPredVysledkem = findViewById(R.id.textView4);
    TextView textVysledek = findViewById(R.id.textViewVysledek);
    vetaPredVysledkem.setVisibility(View.VISIBLE);
    textVysledek.setText(Double.toString(Math.floor(BMI)));
    obarvitVysledek(BMI);
    String formatVysledek=(textVysledek.getText().toString());
    textVysledek.setText(formatVysledek);

    /*
 Intent i=new Intent(this,VysledekActivity.class);
i.putExtra("vysledek",BMI);
startActivity(i);
*/
}

}

    private void obarvitVysledek(double vysledek)
    {        TextView textVysledek= findViewById(R.id.textViewVysledek);


        if(vysledek< 18.5)
        {
            textVysledek.setTextColor(Color.YELLOW);
kategorie="pod";


        }
        else if(vysledek< 24.9)
        {
            textVysledek.setTextColor(Color.GREEN);
            kategorie="norm";


        }
         else if(vysledek< 29.9)
        {
            textVysledek.setTextColor(Color.rgb(255, 165, 0));
            kategorie="nad";

        }
        else
        {
            textVysledek.setTextColor(Color.RED);
            kategorie="hodneNad";



        }

    }
    public void onClickSwitch(View view) {

       Switch switchPohlavi = findViewById(switch1);
        RadioButton muz_RadioButton = findViewById(R.id.radioButton3);
        RadioButton zena_RadioButton = findViewById(R.id.radioButton4);

        if (switchPohlavi.isChecked()) {
            muz_RadioButton.setEnabled(false);
            zena_RadioButton.setEnabled(false);
        } else {
            muz_RadioButton.setEnabled(true);
            zena_RadioButton.setEnabled(true);

        }

    }



    public void zavolejAktivitu(View view)
    {

        Intent i=new Intent(this,VysledekActivity.class);
        i.putExtra("vysledek",BMI);
        i.putExtra("kategorie",kategorie);


        startActivity(i);
    }






}