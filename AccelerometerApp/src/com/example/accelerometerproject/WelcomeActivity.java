package com.example.accelerometerproject;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class WelcomeActivity extends Activity {
	 @Override
	 
	     protected void onCreate(Bundle savedInstanceState) {
	 
	         super.onCreate(savedInstanceState);
	 
	         setContentView(R.layout.welcomeactivity);
	 
	         //通过一个时间控制函数Timer，在实现一个活动与另一个活动的跳转。
	 
	      new Timer().schedule(new TimerTask() {
	 
	    @Override
	 
	    public void run() {
	 
	     startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
	 
	     finish();
	 
	      
	 
	    }
	 
	   }, 3000);//这里停留时间为1000=1s。
	 
	  }

}
