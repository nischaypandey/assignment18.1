package com.example.user.broadcastbattery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//main Activity class extending AppCompatActivity
public class MainActivity extends AppCompatActivity {

    //making object of textView
    TextView batteryLevel;


    //onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);          //setting contentView
        batteryLevel=findViewById(R.id.textBattery);     ///setting textView by its Id

        //registering Reciever for Displaying battery Status
        registerReceiver(broadcastReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }

    //BroadcastReceiver Class
    private BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {

       //overrriden onReceive Method
        @Override
        public void onReceive(Context context, Intent intent) {
          //getting from intent
            int level=intent.getIntExtra("level",0);
          //setting textView
            batteryLevel.setText("Battery Level Remaining: "+level+"%");

        }
    };


}
