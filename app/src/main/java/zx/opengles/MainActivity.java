package zx.opengles;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

/**
 @author Marek Kulawiak
 */

public class MainActivity extends Activity
{
	protected ESSurfaceView glSurfaceView;
	public static int colorId=-1;
	public static float lightPosition;
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		glSurfaceView = new ESSurfaceView(this);

		//setContentView(glSurfaceView);
		setContentView(R.layout.activity_main);
		View tempView = findViewById(R.id.tempView);
		ViewGroup parent = (ViewGroup) tempView.getParent();
		int index = parent.indexOfChild(tempView);
		parent.removeView(tempView);
		parent.addView(glSurfaceView, index);
		Button orangeLight = findViewById(R.id.lightOrangeButton);
		orangeLight.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				colorId=1;
			}
		});
		Button pinkLight = findViewById(R.id.lightPinkButton);
		pinkLight.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				colorId=2;
			}
		});
		SeekBar bar = findViewById(R.id.lightSeekBar);
		bar.setProgress(50);
		bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				lightPosition = (float) progress;
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) { }
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) { }
		});

	}

	@Override
	protected void onResume() 
	{
		// The activity must call the GL surface view's onResume() on activity onResume().
		super.onResume();
		glSurfaceView.onResume();
	}

	@Override
	protected void onPause() 
	{
		// The activity must call the GL surface view's onPause() on activity onPause().
		super.onPause();
		glSurfaceView.onPause();
	}
}
