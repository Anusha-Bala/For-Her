package com.example.anu.housy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by anu on 25/5/15.
 */
public class SignUp extends Activity {

    DatabaseHelper myDb;
    EditText editname,edituname,editemail,editpswd;
    Button btndone;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        myDb = new DatabaseHelper(this);

        editname = (EditText)findViewById(R.id.TFname);
        edituname = (EditText)findViewById(R.id.TFuname);
        editemail = (EditText)findViewById(R.id.TFemail);
        editpswd = (EditText)findViewById(R.id.TFpswd);
        btndone = (Button)findViewById(R.id.Bdone);
        AddData();
    }
    public void AddData(){
        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(editname.getText().toString(),edituname.getText().toString(),editemail.getText().toString(),editpswd.getText().toString());
                if(isInserted =true){

                    Toast.makeText(SignUp.this,"REGISTERED SUCCESSFULLY !!!!",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(SignUp.this, "NOT REGISTERED!!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}