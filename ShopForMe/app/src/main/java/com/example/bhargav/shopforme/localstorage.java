package com.example.bhargav.shopforme;

/**
 * Created by user on 26-02-2017.
 */import java.util.*;

public class localstorage {
    int c=0;
    String[] item = new String[100];
    Scanner obj=new Scanner(System.in);
    public String store(String j) {
        item[c]=j;
         return item[c];
    }
}
