package com.example.user.assignment121;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Creating references of classes used in the layout.
    LinearLayout passwordTab,frequencyTab;
    CheckBox screenLock;
    TextView settingsUpdate;

    //reference of SharedPreference.
    SharedPreferences sharedPreferences;
    public static String settings="Settings Not Updated";

    @Override
    //onCreate method.
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   //Setting the contentview.


        //Setting the references with their IDs.
        passwordTab=(LinearLayout)findViewById(R.id.password_tab);
        frequencyTab=(LinearLayout)findViewById(R.id.update_frequency);
        screenLock=(CheckBox)findViewById(R.id.screen_lock);
        settingsUpdate=(TextView)findViewById(R.id.settings_details);

        //Setting onClick Listeners to the elements.
        passwordTab.setOnClickListener(this);
        frequencyTab.setOnClickListener(this);
        screenLock.setOnClickListener(this);


        //Creating object of SharedPreference.
        sharedPreferences=getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);

        //Checking for different keys in the SharedPreference to set the textView.
        if(!sharedPreferences.getString("password","").isEmpty())
        {
            settings="";
            settings=settings+"Password : "+sharedPreferences.getString("password","")+"\n";
        }
        if(!sharedPreferences.getString("screenLock","").isEmpty())
        {
            settings=settings+"Screen Lock : "+sharedPreferences.getString("screenLock","")+"\n";
            settingsUpdate.setText(settings);
        }
        if(!sharedPreferences.getString("updateFrequency","").isEmpty())
        {
            settings=settings+"Update Frequency : "+sharedPreferences.getString("updateFrequency","")+"\n";
        }

        //Setting text of TextView.
        settingsUpdate.setText(settings);


    }

    @Override
    //Method to handle onClick event.
    public void onClick(View v)
    {
        //for Setting the paasword.
        if(v.getId()==R.id.password_tab)
        {
            //Displaying Toast.
            Toast.makeText(getApplicationContext(),"password Clicked", Toast.LENGTH_SHORT).show();

            //Creating Intent to switch to another class.
            Intent passwordSet= new Intent(MainActivity.this,PasswordSetter.class);
            startActivity(passwordSet);
        }
        //for screen lock.
        else if(v.getId()==R.id.screen_lock)
        {
            //Displaying Toast.
            Toast.makeText(getApplicationContext(),"checkbox",Toast.LENGTH_SHORT).show();

            //Creating SharedPreference editor to store key-value oairs.
            SharedPreferences.Editor editor=sharedPreferences.edit();

            //Checking that checkbox is checked or not.
            //And process according to that.
            if(screenLock.isChecked())
            {
                settings=settings+"Screen Lock : true\n";
                settingsUpdate.setText(settings);
                editor.putString("screenLock","true");
            }
            else
            {
                settings=settings+"Screen Lock : false\n";
                settingsUpdate.setText(settings);
                editor.putString("screenLock","false");
            }
        }
        //for updating the frequency.
        else if(v.getId()==R.id.update_frequency)
        {
            Toast.makeText(getApplicationContext(),"frequency",Toast.LENGTH_SHORT).show();
            Intent frequencySet=new Intent(MainActivity.this,UpdateFrequency.class);
            startActivity(frequencySet);
        }
    }
}
