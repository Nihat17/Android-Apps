package vistula.allahverdiyev_46219.compass;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    Float azimuth_angle;

    private SensorManager compassSensorManager;
    Sensor accelerometer;
    Sensor magnetometer;

    TextView textViewAngle;
    ImageView imageViewCompass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compassSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = compassSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometer = compassSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);


    }

    @Override
    protected void onResume(){
        super.onResume();
        compassSensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
        compassSensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause(){
        super.onPause();
        compassSensorManager.unregisterListener(this);
    }


    float[] accel_read;
    float[] magnetic_read;
    private float current_degree = 0f;

    @Override
    public void onSensorChanged(SensorEvent event) {
        textViewAngle = (TextView)findViewById(R.id.textView2);
        imageViewCompass = (ImageView)findViewById(R.id.imageView);

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            accel_read = event.values;
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
            magnetic_read = event.values;

        if (accel_read != null && magnetic_read != null){
            float[] R = new float[9];
            float[] I = new float[9];
            boolean successful_read = SensorManager.getRotationMatrix(R, I, accel_read, magnetic_read);

            if (successful_read){
                float orientation[] = new float[3];
                SensorManager.getOrientation(R,orientation);
                azimuth_angle = orientation[0];
                float degrees = ((azimuth_angle*180f) / 3.14f);
                int degreesInt = Math.round(degrees);
                textViewAngle.setText(Integer.toString(degreesInt) + (char)0x00B0 + " to absolute north.");

                textViewAngle.setText(Integer.toString(degreesInt) + (char)0x00B0 + " to absolute north.");

                RotateAnimation rotate =
                        new RotateAnimation(current_degree, -degreesInt, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(100);
                rotate.setFillAfter(true);

                imageViewCompass.startAnimation(rotate);
                current_degree = -degreesInt;

            }

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
