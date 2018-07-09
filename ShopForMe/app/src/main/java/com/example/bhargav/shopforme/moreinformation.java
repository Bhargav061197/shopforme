package com.example.bhargav.shopforme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class moreinformation extends AppCompatActivity {
    Button next1;
    TextView textView1;
    String moreinfo1="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moreinformation);
        textView1=(TextView) findViewById(R.id.textView1);
        Intent x1=getIntent();
        moreinfo1=x1.getStringExtra("moreinfo1");
        String mz=moreinfo1;
        next1=(Button) findViewById(R.id.next1);
        textView1.setText(mz);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(moreinformation.this,yesnocart.class);
                startActivity(j);
            }
        });

    }
}
