package com.example.user.assignment121;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//Creating class by extending AppCompatActivity class and implementing OnClickListener.
public class UpdateFrequency extends AppCompatActivity implements View.OnClickListener {

    //creating references of SharedPreference and SharedPreference Editor.
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    //Creating references for buttons used in layout.
    Button weekBtn,fortnightBtn,monthBtn,neverBtn;

    @Override
    //onCreate method.
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_frequency);    //Setting content view.

        //Setting references with their IDs.
        weekBtn=(Button)findViewById(R.id.week_btn);
        fortnightBtn=(Button)findViewById(R.id.fortnight_btn);
        monthBtn=(Button)findViewById(R.id.month_btn);
        neverBtn=(Button)findViewById(R.id.never_btn);

        //Setting onClickListeners.
        weekBtn.setOnClickListener(this);
        fortnightBtn.setOnClickListener(this);
        monthBtn.setOnClickListener(this);
        neverBtn.setOnClickListener(this);

        //Creating object of SharedPreference.
        sharedPreferences=getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
    }

    @Override
    //method to handle onClick event.
    public void onClick(View v)
    {
        //creating SharedPreference editor.
        editor=sharedPreferences.edit();

        //switch statement to know which button is clicked and save the data in SharedPreference according to that.
        switch (v.getId())
        {
            case R.id.week_btn : editor.putString("updateFrequency","7 Days");
                break;

            case R.id.fortnight_btn : editor.putString("updateFrequency","15 Days");
                break;

            case R.id.month_btn : editor.putString("updateFrequency","30 Days");
                break;

            case R.id.never_btn : editor.putString("updateFrequency","Never");
                break;
        }
        //Committing the editor.
        editor.commit();

        //intent to switch to MainActivity again.
        Intent intent=new Intent(UpdateFrequency.this,MainActivity.class);
        startActivity(intent);   //Starting activity.
    }


}
