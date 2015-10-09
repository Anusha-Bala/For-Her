package com.example.anu.housy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by anu on 4/6/15.
 */
public class PostAd_Sale extends Activity {

    DatabaseHelperSale myDbSale;
    EditText editname1,editamount1,editaddress1,editcity1,editphn1;
    Button btnsale;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postad);

        myDbSale = new DatabaseHelperSale(this);

        editname1 = (EditText)findViewById(R.id.pname);
        editamount1 = (EditText)findViewById(R.id.pamount);
        editaddress1 = (EditText)findViewById(R.id.paddress);
        editcity1 = (EditText)findViewById(R.id.pcity);
        editphn1 = (EditText)findViewById(R.id.pcontact);
        btnsale = (Button)findViewById(R.id.Bpostad);
        AddData();
    }
    public void AddData(){
        btnsale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean Inserting= myDbSale.insertpostsale(editname1.getText().toString(), editamount1.getText().toString(), editaddress1.getText().toString(), editcity1.getText().toString(), editphn1.getText().toString());
                if (Inserting = true) {

                    Toast.makeText(PostAd_Sale.this, "POSTED SUCCESSFULLY !!!!", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(PostAd_Sale.this,Display.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(PostAd_Sale.this, "NOT POSTED!!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}

