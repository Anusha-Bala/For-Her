package com.example.anu.housy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by anu on 1/6/15.
 */
public class Services extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services);

    }
    public void onsearchclick(View v) {

        // checking for button click
        if (v.getId() == R.id.Bservicesearch)
        {
            Intent i = new Intent(Services.this,Display.class);
            startActivity(i);
        }
    }
    public void onpostclick(View v) {

        // checking for button click
        if (v.getId() == R.id.Bservicepost)
        {
            Intent i = new Intent(Services.this,PostAd_Services.class);
            startActivity(i);
        }
    }


}
