package com.example.androidjsontest.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;

import com.example.androidjsontest.R;

public class SplashActivity extends Activity {

	private Handler handler = new Handler();
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		context = this;
		
		//setContentView(R.layout.splash);

		int minMillisToShowSplash = 2000;

		final long now = System.currentTimeMillis();
		final long finalMinMillisToShowSplash = minMillisToShowSplash;

		AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
			@Override
			protected Void doInBackground(Void... params) {
				return null;
			}

			@Override
			protected void onPostExecute(Void aVoid) {
				long remainingTime = Math.max(finalMinMillisToShowSplash
						- (System.currentTimeMillis() - now), 0);

				handler.postDelayed(new Runnable() {
					public void run() {

						startActivity(new Intent("MOVILE_MAIN"));
						finish();
					}
				}, remainingTime);
			}
		};

		// noinspection unchecked
		asyncTask.execute();
	}

}
