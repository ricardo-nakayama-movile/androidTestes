package com.example.androidjsontest.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.androidjsontest.R;
import com.example.androidjsontest.parcel.ChannelContentsResponseParcel;
import com.example.androidjsontest.interfaces.AsyncTaskInterface;
import com.example.androidjsontest.util.JSONLoader;

public class MainActivity extends Activity implements AsyncTaskInterface {

	private String channelContentsUrl = "https://s3.amazonaws.com/nativeapps/channel_kids/videos/channelkids_ios.json";
	JSONLoader jsonLoader = new JSONLoader();
	
	private Button buttonTest;
	Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Deve carregar os conteudos enquanto a splash screen esta sendo
		// mostrada
		setContentView(R.layout.activity_main);
		context = this;

		// Chamando a thread para executar uma requisição em background
		jsonLoader.execute(channelContentsUrl);
		jsonLoader.delegate = this;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void processFinish(final ChannelContentsResponseParcel output) {
		// TODO Auto-generated method stub

		// Deve ser carregado a lista aqui
//		Iterator<ChannelContents> channelsIter = output.getContents().iterator();
//		while (channelsIter.hasNext()) {
//			System.out.println(channelsIter.next().getDownloadUrl());
//		}
		
		buttonTest = (Button) findViewById(R.id.buttonTeste);
		
		buttonTest.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context,
						MainListActivity.class);
				intent.putExtra("teste", output);
				startActivity(intent);
			}
		});

	}

}
