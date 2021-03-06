package com.example.bhargav.shopforme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends AppCompatActivity {
Button scan;
    String temp;
    String m;
    SharedPreferences sf;
    localstorage ob=new localstorage();
    public static final String preference="pref";
    public static final String saveit="savekey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scan = (Button) findViewById(R.id.scan);
        sf=getSharedPreferences(preference,Context.MODE_PRIVATE);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(true);
                integrator.initiateScan();

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
            } else {
                String scanvalue = result.getContents();
                temp = scanvalue;
                SharedPreferences.Editor editor = sf.edit();
                editor.putString(saveit, temp);
                editor.commit();
                String z = ob.store(temp);
                Intent i = new Intent(MainActivity.this, product_detail.class);
                startActivity(i);
                sf = getSharedPreferences(preference, Context.MODE_PRIVATE);


            }
        }
        else
        {
            super.onActivityResult(requestCode,resultCode,data);
        }
    }

}
