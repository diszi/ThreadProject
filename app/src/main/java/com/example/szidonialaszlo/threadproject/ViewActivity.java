package com.example.szidonialaszlo.threadproject;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class ViewActivity extends AppCompatActivity {


    private TextView textView;
    private Timer timer = new Timer();
    private int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_layout);

        textView = (TextView) findViewById(R.id.szoveg);

//        timer = new Timer();
//        System.out.println(" NEW  TIMER");
//        LogOutTimerTask logOutTimerTask = new LogOutTimerTask();
//        timer.schedule(logOutTimerTask,60000);


    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        System.out.println(" ------------------------------------>>>>>> " );
       // if (timer != null){
            timer.cancel();
        startTimer();
           /* timer = null;
            System.out.println(" TIMER  = "+timer);
        }*/
    }

    public void startTimer(){
        System.out.println(" ---------------------------> start timer");
        timer = new Timer();
        LogOutTimerTask logOutTimerTask = new LogOutTimerTask();
        timer.schedule(logOutTimerTask,60000);
    }
    @Override
    protected void onPause() {
        super.onPause();
        /*System.out.println("  onPause");
        timer = new Timer();
        Log.i("Main", "Invoking logout timer");

        LogOutTimerTask logOutTimerTask = new LogOutTimerTask();

        timer.schedule(logOutTimerTask,60000);
*/
    }

    @Override
    protected void onResume() {
        super.onResume();

        /*if (timer != null){
            System.out.println(" Timer != null");
            timer.cancel();
            Log.i("Main", "cancel timer");


            timer = null;
        }*/

    }

    private class LogOutTimerTask extends TimerTask{

        @Override
        public void run() {
            Intent i = new Intent(ViewActivity.this,LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }
    }
}
