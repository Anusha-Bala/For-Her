package com.example.anu.housy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

    EditText user,pass;
    String userdata,passdata;
    Button login_btn;
    Context con = this;
    public String NAME = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_btn = (Button)findViewById(R.id.Blogin);
        user = (EditText) findViewById(R.id.TFusername);
        pass = (EditText) findViewById(R.id.TFpassword);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userdata = user.getText().toString();
                passdata = pass.getText().toString();

                DatabaseHelper myDb = new DatabaseHelper(con);
                Cursor res = myDb.getAllData(myDb);
                res.moveToFirst();
                boolean status = false;

                do {
                 if (userdata.equals(res.getString(1)) && (passdata.equals(res.getString(3)))) {
                        status = true;
                        NAME = userdata;
                        break;

                  }
                }
                while (res.moveToNext());

               if (status) {

                    Toast.makeText(getBaseContext(), "Login success.....\n Welcome...." + NAME, Toast.LENGTH_LONG).show();
                   //*********************************
                    //go to post rent,post sale page here if login is successfull
                   //*************************************
                    Intent intent = new Intent(Login.this,Services.class);
                   startActivity(intent);
                    finish();
               } else {Toast.makeText(getBaseContext(), "Please check the credentials again!!!", Toast.LENGTH_LONG).show();
                   finish();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;

    }

    //for signup button
    public void onSignupClick(View v) {

        // checking for button click
        if (v.getId() == R.id.Bsignup)
        {
            Intent i = new Intent(Login.this,SignUp.class);
            startActivity(i);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
