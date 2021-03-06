package com.example.steven.hw6;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class addActivity extends AppCompatActivity {

    private EditText edstore_name;
    private EditText edphone;
    private EditText edaddress;
    private MyDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        helper = new MyDBHelper(this , "expense.db" , null , 1);
        findViews();
    }

    private void findViews()
    {
        edstore_name = (EditText) findViewById(R.id.edstore_name);
        edaddress = (EditText) findViewById(R.id.edaddress);
        edphone = (EditText) findViewById(R.id.edphone);
    }
    public void add(View v)
    {
        String store_name = edstore_name.getText().toString();
        String address = edaddress.getText().toString();
        int phone = Integer.parseInt(edphone.getText().toString());
        ContentValues values = new ContentValues();

        values.put("store_name", store_name);
        values.put("address", address);
        values.put("phone", phone);

        long id = helper.getWritableDatabase().insert("exp", null, values);

        Log.d("ADD", id+"");

        startActivity(
                new Intent(addActivity.this,MainActivity.class));

    }
    public void notadd(View v)
    {
        startActivity(
                new Intent(addActivity.this,MainActivity.class));
    }

}
