package com.example.bhargav.shopforme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import static com.example.bhargav.shopforme.MainActivity.preference;
import static com.example.bhargav.shopforme.MainActivity.saveit;

public class finallist extends AppCompatActivity {
    String[] items={};
    ListView listView;
    ArrayAdapter<String>itemsAdapter;
    SharedPreferences sf;
    String x;
    Button checkout;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finallist);
        sf=getSharedPreferences(preference, Context.MODE_PRIVATE);
        x = sf.getString(saveit,"");
        if(x.equalsIgnoreCase("9780070146129")) {
            String z="->Basic Electrical & Electronics Engineering->1->350 INR";
            items = new String[]{x.concat(z)};
        }
        else if(x.equalsIgnoreCase("8901058850574"))
        {
            String z="->Maggi Hot&Sweet Tomato Chilli Sauce->4->80 INR";
            items = new String[]{x.concat(z)};
        }
        else if(x.equalsIgnoreCase("4971850134855"))
        {
            String z="->Casio Scientific Calculator fx-991MS->1->745 INR";
            items = new String[]{x.concat(z)};
        }

        ListView listView=(ListView)findViewById(R.id.listView);
        itemsAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,items);
        listView.setAdapter(itemsAdapter);
        checkout=(Button) findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(finallist.this,paymentdone.class);
                startActivity(j);
            }
        });

    }
}
