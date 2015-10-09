package com.example.anu.housy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by anu on 1/6/15.
 */
public class PostAd extends Activity {
    DatabaseHelperPost myDbPost;
    EditText editname,editamount,editaddress,editcity,editphn;
    Button btnpost;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postad);

        myDbPost = new DatabaseHelperPost(this);

        editname = (EditText)findViewById(R.id.pname);
        editamount = (EditText)findViewById(R.id.pamount);
        editaddress = (EditText)findViewById(R.id.paddress);
        editcity = (EditText)findViewById(R.id.pcity);
        editphn = (EditText)findViewById(R.id.pcontact);
        btnpost = (Button)findViewById(R.id.Bpostad);
        AddData();
    }
    public void AddData(){
        btnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean Inserting= myDbPost.insertpostrent(editname.getText().toString(), editamount.getText().toString(), editaddress.getText().toString(), editcity.getText().toString(), editphn.getText().toString());
                if (Inserting = true) {

                    Toast.makeText(PostAd.this, "POSTED SUCCESSFULLY !!!!", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(PostAd.this,Display.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(PostAd.this, "NOT POSTED!!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
