package com.example.szidonialaszlo.threadproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private AutoCompleteTextView compLoginName;
    private EditText password;
    Button loginBt;


    private int lastInteractionTime;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        compLoginName = (AutoCompleteTextView) findViewById(R.id.actLogin_Name);
        password = (EditText) findViewById(R.id.actLogin_Password);
        loginBt = (Button) findViewById(R.id.actLogin_Button);
        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,ViewActivity.class);
                startActivity(intent);
            }
        });
        //startUserInactivityDetectThread();

    }

//    public void startUserInactivityDetectThread(){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true){
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    if (getLastInteractionTime() > (1000*60)){
//
//                        Intent intent = new Intent(LoginActivity.this,ViewActivity.class);
//                        startActivity(intent);
//                    }
//
//                }
//            }
//        }).start();
//    }


    public long getLastInteractionTime() {
        return lastInteractionTime;
    }

    public void setLastInteractionTime(int lastInteractionTime) {
        this.lastInteractionTime = lastInteractionTime;
    }

}
