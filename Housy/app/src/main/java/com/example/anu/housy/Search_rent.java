package com.example.anu.housy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by anu on 29/5/15.
 */
public class Search_rent extends Activity {

    EditText name,amount,address,cty,phn;
    EditText city;
    String citydata;
    Button search_btn;
    Context con1 = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_rent);

        search_btn = (Button) findViewById(R.id.Bsearch);
        name = (EditText) findViewById(R.id.pname);
        amount = (EditText) findViewById(R.id.pamount);
        address = (EditText) findViewById(R.id.paddress);
        cty = (EditText) findViewById(R.id.pcity);
        phn = (EditText) findViewById(R.id.pcontact);
        city = (EditText) findViewById(R.id.TFcity);

        search_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                citydata = city.getText().toString();
                DatabaseHelperPost myDbPost = new DatabaseHelperPost(con1);

                Cursor res1 = myDbPost.getCity(myDbPost);
                res1.moveToFirst();
                boolean status = false;
                String CITY = "";
                String NAME = "";
                String AMOUNT ="";
                String ADDRESS = "";
                String CTY = "";
                String PHN = "";

                do {
                    if (citydata.equals(res1.getString(3))) {

                        status = true;
                        CITY = citydata;
                        NAME = NAME+"::"+res1.getString(0);
                        AMOUNT =AMOUNT+"::"+res1.getString(1);
                        ADDRESS =ADDRESS+"::"+res1.getString(2);
                        CTY = CTY+"::"+res1.getString(3);
                        PHN =PHN+"::"+ res1.getString(4);
                    }
                }
                while (res1.moveToNext());

                if (status) {

                    Toast.makeText(getBaseContext(), "You enterd .....\n " + CITY, Toast.LENGTH_LONG).show();
                    //************************************
                    //list all the details regarding to the city entered
                    //************************************
                    Intent intent = new Intent(Search_rent.this,PostrentDetails.class);

                    intent.putExtra("name",NAME);
                    intent.putExtra("amount",AMOUNT);
                    intent.putExtra("address",ADDRESS);
                    intent.putExtra("city",CTY);
                    intent.putExtra("phone",PHN);

                    startActivity(intent);
                   // Toast.makeText(getBaseContext(),"Rental Houses In The Enterd City.....\n " +NAME+"\n"+AMOUNT+"\n" +ADDRESS+"\n" + CTY +"\n"+ PHN,Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getBaseContext(), "Please Enter the correct name!!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}