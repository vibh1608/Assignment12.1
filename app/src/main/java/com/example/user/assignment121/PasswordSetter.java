package com.example.user.assignment121;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//Creating class extending AppCompatActivity class and OnClicklistener.
public class PasswordSetter extends AppCompatActivity implements View.OnClickListener {

    //Creating refereneces of classes used in layout.
    EditText passwordSet;
    Button saveBtn;

    //creating references of SharedPreference and SharedPreference Editor.
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    //onCreate methood.
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_setter);   //Setting content view.

        //Setting references with their IDs.
        passwordSet=(EditText)findViewById(R.id.password);
        saveBtn=(Button)findViewById(R.id.save_btn);

        //Creating object of SharedPreference.
        sharedPreferences=getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);

        //Setting onClick listener to the button.
        saveBtn.setOnClickListener(this);
    }

    @Override
    //Method to handle onClick event.
    public void onClick(View v)
    {
        //Checking that save button is clicked.
        if(v.getId()==R.id.save_btn)
        {

            //Creating SharedPreference Editor and putting key-value pair.
            editor=sharedPreferences.edit();
            editor.putString("password",passwordSet.getText().toString());
            editor.commit();    //Committing the Editor.


            //Intent to swith to MainActivity again.
            Intent intent=new Intent(PasswordSetter.this,MainActivity.class);
            startActivity(intent);

        }
    }
}
