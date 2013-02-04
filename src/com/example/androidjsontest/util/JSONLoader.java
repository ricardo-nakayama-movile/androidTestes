package com.example.androidjsontest.util;

import java.io.IOException;

import android.os.AsyncTask;

import com.example.androidjsontest.interfaces.AsyncTaskInterface;
import com.example.androidjsontest.parcel.ChannelContentsResponseParcel;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class JSONLoader extends	AsyncTask<String, Void, ChannelContentsResponseParcel> {

	public AsyncTaskInterface delegate=null;
	
	@Override
	protected void onPreExecute() {
	}

	@Override
	protected ChannelContentsResponseParcel doInBackground(String... params) {

		ChannelContentsResponseParcel channelContentsResponseParcel = null;

		String response = JSONParser.getUrlResponse(params[0]);

		try {
			channelContentsResponseParcel = JSONParser.getChannelContentsObjFromJson(response);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return channelContentsResponseParcel;
	}

	protected void onProgressUpdate(Integer... progress) {
	}

	protected void onPostExecute(ChannelContentsResponseParcel result) {
	    delegate.processFinish(result);
	}

}