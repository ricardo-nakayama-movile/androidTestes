package com.example.androidjsontest.activities;

import android.app.Activity;
import android.os.Bundle;

import com.example.androidjsontest.R;
import com.loopj.android.image.SmartImageView;

public class SmartImageViewTest extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.smartimageviewtest);
		SmartImageView profileImage = (SmartImageView) findViewById(R.id.profileImage);
		profileImage.setImageUrl("http://s3.amazonaws.com/s3.zeewe.com/s3/tv/series/canalkids/4247.jpg");
	}

}
