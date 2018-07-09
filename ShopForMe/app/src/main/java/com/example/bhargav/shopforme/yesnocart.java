package com.example.bhargav.shopforme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.bhargav.shopforme.R.id.line1;
import static com.example.bhargav.shopforme.R.id.line3;
import static com.example.bhargav.shopforme.R.id.ok;

public  class yesnocart extends AppCompatActivity {
    private int count=0;
    String hello;
    String message;
    Button ok;
    Button items;
    Context context=this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    SharedPreferences sf;
    public static final String preference="pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout3);
        items=(Button) findViewById(R.id.items);
        ok=(Button) findViewById(R.id.ok);
        items.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                count=count+1;
                message=Integer.toString(count);
                Button items=(Button)v;
                ((Button)v ).setText("No of Items:   "+message);/*remove the bug by mapping*/
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(yesnocart.this, layout4.class);
                startActivity(x);
                if(count>0)
                {
                    sf=getSharedPreferences(preference,Context.MODE_PRIVATE);
                    String scanned=sf.toString();
                    userDbHelper=new UserDbHelper(context);
                    sqLiteDatabase=userDbHelper.getWritableDatabase();
                    userDbHelper.addInformation(scanned,message,sqLiteDatabase);
                    Toast.makeText(yesnocart.this, "ITEM ADDED TO CART", Toast.LENGTH_SHORT).show();
                    UserDbHelper helper = new UserDbHelper(yesnocart.this);
                    String path = userDbHelper.addInformation(scanned,message,sqLiteDatabase);

                    userDbHelper.close();

                }
            }
        }
        );


    }

}