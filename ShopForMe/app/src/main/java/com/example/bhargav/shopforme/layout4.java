package com.example.bhargav.shopforme;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class layout4 extends AppCompatActivity {
    Button dwc;
    String temp;
    Button scan1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout4);
        dwc=(Button)findViewById(R.id.dwc);
        scan1=(Button)findViewById(R.id.scan1);
        final Activity activity=this;
        dwc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(layout4.this,finallist.class);
                startActivity(a);
            }
        });
        scan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a1= new Intent(layout4.this,product_detail.class);
                a1.putExtra("temp", temp);
                startActivity(a1);
                IntentIntegrator integrator=new IntentIntegrator(activity);
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
        if (result != null)
        {
            if (result.getContents()==null)
            {
                Toast.makeText(this,"You cancelled the scanning",Toast.LENGTH_LONG).show();
            }
            else
            {
                String scanvalue= result.getContents();
                temp=scanvalue;
            }

        }
        else
        {
            super.onActivityResult(requestCode,resultCode,data);
        }
    }

}
