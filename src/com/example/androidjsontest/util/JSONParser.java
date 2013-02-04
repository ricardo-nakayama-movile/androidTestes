package com.example.androidjsontest.util;

import java.io.IOException;

import android.util.Log;

import com.example.androidjsontest.parcel.ChannelContentsResponseParcel;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser {

	// metodo que pega o conteudo de uma url
	public static String getUrlResponse(String url) {

		String response = "";

		try {
			response = HttpUtil.doHttpGet(url);
		} catch (Exception e) {
			Log.e("INFO", "erro ao conectar com servidor");
			e.printStackTrace();
		}
		return response;
	}

	// metodo que faz a conversao entre json e um objeto do tipo channelContentsResponse
	// IMPORTANTE: esta deserializacao eh feita de uma string json para um UNICO conteudoContentsResponse,
	// se fosse necessario uma lista, seria chamado new TypeReference<List<ChannelContentsResponse>>() {}
	// ou seja, ele retornará o valor do segundo argumento
	// como o metodo readValue possui varias assinaturas, pode ser utilizado alem da string json, objeto json, inputStream, etc
	public static ChannelContentsResponseParcel getChannelContentsObjFromJson(String json) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
				  
		return objectMapper.readValue(json, new TypeReference<ChannelContentsResponseParcel>() {});
	}
}