package com.example.ballcarry;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class BallCarryActivity extends Activity
        implements SensorEventListener {
    private BallCarrySurFaceView mSurFaceView;
    
    
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    public static float accel_x = 0.0f;
    public static float accel_y = 0.0f;
    
    
}
