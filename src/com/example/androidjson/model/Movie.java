package com.example.androidjson.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.androidjsontest.parcel.ChannelContentsParcel;
import com.example.androidjsontest.parcel.ChannelContentsResponseParcel;

public class Movie {

	public String title;
	public String tag;
	public String accountType;
	public String idImage;
	public String urlMovie;
	public String urlDownload;
	
	public Movie(){}

	public Movie(String title, String tag, String accountType, String idImage, String urlMovie, String urlDownload) {
		this.title = title;
		this.tag = tag;
		this.accountType = accountType;
		this.idImage = idImage;
		this.urlMovie = urlMovie;
		this.urlDownload = urlDownload;
	}

	// -- Aux Method
	public static List<Movie> getMoviesList(ChannelContentsResponseParcel channelContentsResponseParcel){
		
		List<Movie> movies = new ArrayList<Movie>();
		ChannelContentsParcel channelContentsParcel;
		
		Iterator<ChannelContentsParcel> it = channelContentsResponseParcel.getContents().iterator();
		while (it.hasNext()) {
			channelContentsParcel = it.next();
			movies.add(new Movie(
					channelContentsParcel.getName(),
					channelContentsParcel.getTag(),
					channelContentsParcel.getAccountType(),
					channelContentsParcel.getEpisodeImg(),
					channelContentsParcel.getEpisodeIdiOS(),
					channelContentsParcel.getDownloadUrl()));
		}
		
		return movies;
	}
}
