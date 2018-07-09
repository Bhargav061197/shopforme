package com.example.bhargav.shopforme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class layout3 extends AppCompatActivity {
    Button add;
    Button moreinfo;
    String moreinfo1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        add=(Button) findViewById(R.id.add);
        moreinfo=(Button) findViewById(R.id.moreinfo);
        Intent x=getIntent();
        moreinfo1=x.getStringExtra("moreinfo1");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(layout3.this,yesnocart.class);
                startActivity(in);

            }
        });
        moreinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(layout3.this,moreinformation.class);
                i.putExtra("moreinfo1",moreinfo1);
                startActivity(i);

            }
        });
    }


        }



