package com.example.anu.housy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by anu on 4/6/15.
 */
public class Home extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }

    public void onGoClick(View v) {

        // checking for button click
        if (v.getId() == R.id.Bgo) {
            Intent i = new Intent(Home.this, Login.class);
            startActivity(i);
        }
    }
}