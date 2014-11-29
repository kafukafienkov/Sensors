package com.bartek.example.sensors;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.OrientationEventListener;


public class MainActivity extends ActionBarActivity {

    private CompassView compassView;
    private OrientationEventListener orientationEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        compassView = new CompassView(this);
        setContentView(compassView);

        orientationEventListener = new OrientationEventListener(this) {
            @Override
            public void onOrientationChanged(int orientation) {
                compassView.updateData(orientation);
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        orientationEventListener.enable();
    }


    @Override
    protected void onPause() {
        super.onPause();
        orientationEventListener.disable();
    }
}
