package com.example.ballcarry;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class BallCarryActivity extends Activity
        implements SensorEventListener {
    private BallCarrySurFaceView mSurFaceView;
    
    
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    public static float accel_x = 0.0f;
    public static float accel_y = 0.0f;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    	mSurFaceView = new BallCarrySurFaceView(this);
    	setContentView(mSurFaceView);
    	
    	mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
    	List<Sensor> list = mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
    	if (list.size() > 0) {
    		mAccelerometer = list.get(0);
    	}
    	
    }
    
    @Override
    protected void onResume() {
    	
    	super.onResume();
    	mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_GAME);
    }
    
    @Override
    protected void onPause() {
    	
    	super.onPause();
    	mSensorManager.unregisterListener(this);
    }
    
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    	
    }
    
    @Override
    public void onSensorChanged(SensorEvent event) {
    	
    	if (event.sensor.getType()!= Sensor.TYPE_ACCELEROMETER) {
    		return;
    	}
    	accel_x = event.values[0];
    	accel_y = event.values[1];
    }
    
}
