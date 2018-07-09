package com.example.bhargav.shopforme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.bhargav.shopforme.MainActivity.preference;
import static com.example.bhargav.shopforme.MainActivity.saveit;

public class product_detail extends AppCompatActivity {
    Button next;
    TextView textView;
    SharedPreferences sf;
    public static String x;
    String info="";
    String moreinfo1="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);
        textView=(TextView) findViewById(R.id.textView);
        sf=getSharedPreferences(preference,Context.MODE_PRIVATE);
        x = sf.getString(saveit,"");
        if (x.equalsIgnoreCase("9780070146129"))
        {
            info="Book Name: Basic Electrical And Electronics Engineering\nPrice: 350 INR\nAuthors: R Muthusubramanian & S Salivahanan\n" +
                    "Publishers: Mc Graw Hills";
            moreinfo1="No more info";
        }
        else if (x.equalsIgnoreCase("8901058850574"))
        {
            info="Hot&Spicy Maggi tomato chilli Sauce\n6 g\nMFD:-January 2017\nExpiry:-Best before 8 months\nPrice:20 INR";
            moreinfo1="Nutrition per 100g\nEnergy(kcal)    154\nProtein(g)   0.5\nCarbohydrate(g)   38.0\nTotal Sugar(g)   37.4";
        }
        else if (x.equalsIgnoreCase("4971850134855"))
        {
            info="Casio Scientific Calculator fx-991MS\nPrice:- 745 INR";
            moreinfo1="2-Line Display\nMatrix And Vector Calculations\nComplex Number Calculation" ;
        }
        textView.setText(info);
        next=(Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(product_detail.this,layout3.class);
                j.putExtra("moreinfo1",moreinfo1);
                startActivity(j);
            }
        });

    }

}
