package com.example.anu.housy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;


/**
 * Created by anu on 2/6/15.
 */
public class PostrentDetails extends Activity {

    // LinearLayout anushalay;
    TableLayout tl;
    TableRow tr;
    TextView NameTV,AmountTV,AddressTV,CityTV,ContactTV;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tl = (TableLayout) findViewById(R.id.maintable);


        //setContentView(R.layout.postrentdetails);

        //  anushalay = (LinearLayout) findViewById(R.id.anusha);
        String name;
        String amount;
        String address;
        String city;
        String phone;


        name = getIntent().getStringExtra("name");
        amount = getIntent().getStringExtra("amount");
        address = getIntent().getStringExtra("address");
        city = getIntent().getStringExtra("city");
        phone = getIntent().getStringExtra("phone");

        String[] names = name.split("::");
        String [] amounts = amount.split("::");
        String [] addresses = address.split("::");
        String [] citys =  city.split("::");
        String [] phones = phone.split("::");

        addHeaders();
        addData(names,amounts,addresses,citys,phones);

    }

    public void addHeaders() {

        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        /** Creating a TextView to add to the row **/
        TextView NameTV = new TextView(this);
        NameTV.setText("Name");
        NameTV.setTextColor(Color.BLACK);
        NameTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        NameTV.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        NameTV.setPadding(5, 5, 5, 0);
        tr.addView(NameTV);  // Adding textView to tablerow.

        /** Creating another textview **/
        TextView AmountTV = new TextView(this);
        AmountTV.setText("Amount");
        AmountTV.setTextColor(Color.BLACK);
        AmountTV.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        AmountTV.setPadding(5, 5, 5, 0);
        AmountTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(AmountTV); // Adding textView to tablerow.

        /** Creating a TextView to add to the row **/
        TextView AddressTV = new TextView(this);
        AddressTV.setText("Address");
        AddressTV.setTextColor(Color.BLACK);
        AddressTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        AddressTV.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        AddressTV.setPadding(5, 5, 5, 0);
        tr.addView(AddressTV);  // Adding textView to tablerow.

        /** Creating another textview **/
        TextView CityTV = new TextView(this);
        CityTV.setText("City");
        CityTV.setTextColor(Color.BLACK);
        CityTV.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        CityTV.setPadding(5, 5, 5, 0);
        CityTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(CityTV); // Adding textView to tablerow.

        /** Creating a TextView to add to the row **/
        TextView ContactTV = new TextView(this);
        ContactTV.setText("Contact");
        ContactTV.setTextColor(Color.BLACK);
        ContactTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        ContactTV.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        ContactTV.setPadding(5, 5, 5, 0);
        tr.addView(ContactTV);  // Adding textView to tablerow.



        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        // we are adding two textviews for the divider because we have two columns
        tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT));


        // we are adding two textviews for the divider because we have two columns
        tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        // we are adding two textviews for the divider because we have two columns
        tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT));


        /** Creating another textview **/
        TextView divider1 = new TextView(this);
        divider1.setText("-------");
        divider1.setTextColor(Color.BLACK);
        divider1.setLayoutParams(new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        divider1.setPadding(0, 0, 0, 0);
        divider1.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider1); // Adding textView to tablerow.

        TextView divider2 = new TextView(this);
        divider2.setText("------");
        divider2.setTextColor(Color.BLACK);
        divider2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
        divider2.setPadding(0, 0, 0, 0);
        divider2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider2); // Adding textView to tablerow.

        TextView divider3 = new TextView(this);
        divider3.setText("------------------");
        divider3.setTextColor(Color.BLACK);
        divider3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        divider3.setPadding(0, 0, 0, 0);
        divider3.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider3); // Adding textView to tablerow.

        TextView divider4 = new TextView(this);
        divider4.setText("-------");
        divider4.setTextColor(Color.BLACK);
        divider4.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        divider4.setPadding(0, 0, 0, 0);
        divider4.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider4); // Adding textView to tablerow.

        TextView divider5 = new TextView(this);
        divider5.setText("--------");
        divider5.setTextColor(Color.BLACK);
        divider5.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        divider5.setPadding(0, 0, 0, 0);
        divider5.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider5); // Adding textView to tablerow.

        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT));
    }

    public void addData(String[] names,String[] amounts,String[] addresses,String[] citys,String[] phones) {

        for (int i = 0; i < names.length; i++) {
            /** Create a TableRow dynamically **/
            tr = new TableRow(this);
            tr.setLayoutParams(new LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            /** Creating a TextView to add to the row **/
            NameTV = new TextView(this);
            NameTV.setText(names[i]);
            NameTV.setTextColor(Color.BLUE);
            NameTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            NameTV.setLayoutParams(new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            NameTV.setPadding(0, 0, 0, 0);
            tr.addView(NameTV);  // Adding textView to tablerow.

            /** Creating another textview **/
            AmountTV = new TextView(this);
            AmountTV.setText(amounts[i]);
            AmountTV.setTextColor(Color.GREEN);
            AmountTV.setLayoutParams(new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            AmountTV.setPadding(0, 0, 0, 0);
            AmountTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(AmountTV); // Adding textView to tablerow.

            /** Creating another textview **/
            AddressTV = new TextView(this);
            AddressTV.setText(addresses[i]);
            AddressTV.setTextColor(Color.BLUE);
            AddressTV.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            AddressTV.setPadding(0, 0, 0, 0);
            AddressTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView( AddressTV); // Adding textView to tablerow.

            /** Creating another textview **/
            CityTV = new TextView(this);
            CityTV.setText(citys[i]);
            CityTV.setTextColor(Color.GREEN);
            CityTV.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            CityTV.setPadding(0, 0, 0, 0);
            CityTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(CityTV); // Adding textView to tablerow.

            /** Creating a TextView to add to the row **/
            ContactTV = new TextView(this);
            ContactTV.setText(phones[i]);
            ContactTV.setTextColor(Color.BLUE);
            ContactTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            ContactTV.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            ContactTV.setPadding(0, 0, 0, 0);
            tr.addView(ContactTV);  // Adding textView to tablerow.


            // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
        }

    }
}






