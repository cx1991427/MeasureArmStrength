package com.example.accelerometerproject;

import com.javacodegeeks.androidaccelerometerexample;

import android.app.Activity;
	import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
	import android.hardware.SensorEvent;
	import android.hardware.SensorEventListener;
	import android.hardware.SensorManager;
	import android.os.Bundle;
	import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
	 
	public class MainActivity extends Activity implements SensorEventListener {
//		private static final String TAG ="MainActivity";
	 
        private SensorManager sensorManager;
	    private Sensor accelerometer;
	 
	    private float deltaXMax = 0;
	    private float deltaYMax = 0;
	    private float deltaZMax = 0;
	    private float deltaTMax = 0;
	 
        private float deltaX = 0;
        private float deltaY = 0;
        private float deltaZ = 0;
        private float deltaT = 0;
        
        final float zero = 0.0f;
        
        private float[] gravity = new float[3];
 
        private TextView X, Y, Z, MaxX, MaxY, MaxZ,MaxT;
	    private Button btn1;

        public void onCreate(Bundle savedInstanceState) {
        	super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        X = (TextView) findViewById(R.id.currentX);
	        Y = (TextView) findViewById(R.id.currentY);
	        Z = (TextView) findViewById(R.id.currentZ);
	 
	        MaxX = (TextView) findViewById(R.id.maxX);
	        MaxY = (TextView) findViewById(R.id.maxY);
	        MaxZ = (TextView) findViewById(R.id.maxZ);
	        MaxT = (TextView) findViewById(R.id.maxT);
	        
	        btn1 = (Button) findViewById(R.id.button1);
	        
	        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);   
	        	            
	            
	        btn1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				
					 Intent intent = new Intent(MainActivity.this,SecondActivity.class);
					 intent.putExtra("strength", deltaTMax); 
					 startActivity(intent);  
					   
					 MaxX.setText(Float.toString(zero));
					 MaxY.setText(Float.toString(zero));
					 MaxZ.setText(Float.toString(zero));
					 
					 MaxT.setText(Float.toString(zero));					 
					 
					 X.setText(Float.toString(zero));
				     Y.setText(Float.toString(zero));
				     Z.setText(Float.toString(zero));	
//					toast("succeed!");				     
//				     startAontherActivity();
				     deltaXMax = 0;
				     deltaYMax = 0;
				     deltaZMax = 0;
				     deltaTMax = 0;
				     
				}	           
	          });	        
	    }
        
   /*    private void startAontherActivity(){
    	   Intent intent = new Intent(this,SecondActivity.class);
    	   startActivity(intent);   
       }*/
        
	    protected void onresume() {
	        super.onResume();
	        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_FASTEST);
//	        Log.v(TAG, "onResume()");
	    }
	    
	    protected void onPause() {
	        super.onPause();
	        sensorManager.unregisterListener(this);
//	        Log.v(TAG, "onPause()");
	    }
	    
	    @Override
		protected void onStart() {
			// TODO Auto-generated method stub
			super.onStart();
//			Log.v(TAG, "onStart()");
		}

		@Override
		protected void onRestart() {
			// TODO Auto-generated method stub
			super.onRestart();
//			Log.v(TAG, "onResstart()" );
		}

		@Override
		protected void onStop() {
			// TODO Auto-generated method stub
			super.onStop();
//			Log.v(TAG, "onStop()");
		}

		@Override
		protected void onDestroy() {
			// TODO Auto-generated method stub
			super.onDestroy();
//			Log.v(TAG, "onDestroy()" );
		}

		@Override
	    public void onAccuracyChanged(Sensor sensor, int accuracy){
			
	    }
	         
	    @Override
	    public void onSensorChanged(SensorEvent event) {
//	display clean values
				 X.setText(Float.toString(zero));
			     Y.setText(Float.toString(zero));
			     Z.setText(Float.toString(zero));
		    
//	display current values	   
		        X.setText(Float.toString(deltaX));
		        Y.setText(Float.toString(deltaY));
		        Z.setText(Float.toString(deltaZ));
		    
//	display max values	   
		        if (deltaX > deltaXMax) {
		            deltaXMax = deltaX;
		            MaxX.setText(Float.toString(deltaXMax));
		        }
		        if (deltaY > deltaYMax) {
		            deltaYMax = deltaY;
		            MaxY.setText(Float.toString(deltaYMax));
		        }
		        if (deltaZ > deltaZMax) {
		            deltaZMax = deltaZ;
		            MaxZ.setText(Float.toString(deltaZMax));
		        }
		        
		        deltaT = (float) Math.sqrt(deltaX*deltaX+deltaY*deltaY+deltaZ*deltaZ);
		        if ( deltaT> deltaTMax) {
		            deltaTMax = deltaT;
		            MaxT.setText(Float.toString(deltaTMax));
		        }
		    
		        
		        
	        final float alpha = 0.8f;
	        gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
	    	gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
	    	gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];
	    	deltaX = event.values[0]-gravity[0];
			deltaY = event.values[1]-gravity[1];
			deltaZ = event.values[2]-gravity[2];
	        
	        if (deltaX < 1)
	            deltaX = 0;
	        if (deltaY < 1)
	            deltaY = 0;
	        if (deltaZ < 1)
	            deltaZ = 0;	      	        	        
	    }	      
	
	}

