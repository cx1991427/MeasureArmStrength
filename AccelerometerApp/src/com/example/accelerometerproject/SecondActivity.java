package com.example.accelerometerproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
	 private TextView textView;  	 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondactivity);
		 initComponent();
		 
		Intent intent = getIntent(); 
		float strength = intent.getFloatExtra("strength", 0.01f); 
		textView.setText("Your Arm Strength is: " +"\n"+strength);
	}
	private void initComponent() {
		// TODO Auto-generated method stub
		textView = (TextView) findViewById(R.id.textView1); 
	}
	

}
