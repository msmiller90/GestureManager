package net.miller;

import java.util.ArrayList;

import net.miller.R;

import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.os.Bundle;
import android.widget.Toast;

public class GesturesActivity extends Activity implements OnGesturePerformedListener {
    private GestureLibrary mLibrary;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spells);
        GestureOverlayView gestures = (GestureOverlayView) findViewById(R.id.gestures);
        gestures.addOnGesturePerformedListener(this);
    }
	
	void loadLibrary()
	{
        mLibrary = GestureBuilderActivity.getStore();
        if (!mLibrary.load()) {
        	finish();
        }	
	}
	
	
	public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
		loadLibrary();
		ArrayList<Prediction> predictions = mLibrary.recognize(gesture);

		// We want at least one prediction
		if (predictions.size() > 0) {
			Prediction prediction = predictions.get(0);
			// We want at least some confidence in the result
			if (prediction.score > 1.0) {
				// Show the spell
				Toast.makeText(this, prediction.name, Toast.LENGTH_SHORT).show();
			}
		}
	}
}