package com.uic.prelimexam.poliquitexam;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    AdView mAdview;
    EditText editText_username;
    Button button_start, button_tally;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        /*AD STARTS HERE********/
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        mAdview = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        mAdview.loadAd(adRequest);

        /*BUGTONG STARTS HERE********/
        editText_username = (EditText) findViewById(R.id.editText_username);
        button_start = (Button) findViewById(R.id.button_start);
        button_tally = (Button) findViewById(R.id.button_tally);

        if(uicGetSharedPreferenceValue("userInfo", "username").isEmpty()){
            button_tally.setEnabled(false);
        }

        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uicSetSharedPreferenceValue("userInfo", "username", editText_username.getText().toString());
                Intent intent = new Intent(MainActivity.this,BugtongActivity.class);
                startActivity(intent);
            }
        });

        button_tally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TallyActivity.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        uicDialogQuit();
    }

    public void uicDialogQuit(){
        AlertDialog.Builder altExit = new AlertDialog.Builder(MainActivity.this);
        altExit.setMessage("Do you want to close this app?").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //finish();
                        finishAffinity();
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alert = altExit.create();
        alert.setTitle("Closing Activity");
        alert.show();
    }

    public void uicToastMessage(String message){
        Toast.makeText(this, message ,Toast.LENGTH_SHORT).show();
    }

    public void uicSetSharedPreferenceValue(String sharedPrefName, String key, String value){
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String uicGetSharedPreferenceValue(String sharedPrefName, String key){
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
        String value = sharedPreferences.getString(key, "");
        return value;
    }


}