package com.example.anu.housy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by anu on 1/6/15.
 */
public class PostAd_Services extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postad_services);

    }
    //for postsale button
    public void onpostsaleClick(View v) {

        // checking for button click
        if (v.getId() == R.id.Bpostsale)
        {
            Intent i = new Intent(PostAd_Services.this,PostAd.class);
            startActivity(i);
        }
    }
    //for postrent button
    public void onpostrentClick(View v) {

        // checking for button click
        if (v.getId() == R.id.Bpostrent)
        {
            Intent i = new Intent(PostAd_Services.this,PostAd.class);
            startActivity(i);
        }
    }

}
