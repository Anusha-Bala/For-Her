package com.example.anu.housy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by anu on 25/5/15.
 */
public class Display extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

    }
//for sale button
    public void onSaleClick(View v) {

        // checking for button click
        if (v.getId() == R.id.Bpostsale)
        {
            Intent i = new Intent(Display.this,Search_sale.class);
            startActivity(i);
        }
    }
//for rent button
    public void onRentClick(View v) {

        // checking for button click
        if (v.getId() == R.id.Bpostrent)
        {
           Intent i = new Intent(Display.this,Search_rent.class);
           startActivity(i);
        }
    }

}
