package com.grepperz.web.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


public class WebClient{
	
	static DefaultHttpClient client = new DefaultHttpClient();
	
	public static String doGet(String uri){
		
		try{
			HttpGet request = new HttpGet(uri);
			HttpResponse response = client.execute(request);
			return getResponse(response);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	private static String getResponse(HttpResponse response) {

		StringBuilder textView = new StringBuilder();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));

			String line = "";
			while ((line = rd.readLine()) != null) {
				textView.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textView.toString();
	}
	
}
