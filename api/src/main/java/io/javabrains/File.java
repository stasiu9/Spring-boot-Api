package io.javabrains;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ch.qos.logback.core.subst.Token.Type;



public class File
{
	
	public static Data getData(String url) throws Exception
	{
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet= new HttpGet(url);
		httpGet.addHeader("accept","application/json");
		HttpResponse response= httpClient.execute(httpGet);
		String data=readData(response);
		Gson gson =new Gson();
		return gson.fromJson(data, Data.class);
				
	}
	public static String readData(HttpResponse httpResponse) throws Exception
	{
		BufferedReader bufferedReader=null;
		
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			
			StringBuffer buffer= new StringBuffer();
			char[] dataLength=new char[1024];
			int read;
			while((read=bufferedReader.read(dataLength))!=-1)
			{
				buffer.append(dataLength,0,read);
			}
			return buffer.toString();
		}catch(Exception e)
		{
			throw e;
		}
		finally
		{
			if(bufferedReader!=null)
				bufferedReader.close();
		}
	}
	
	public static List<Data> getDataList(String url) throws Exception
	{
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet= new HttpGet(url);
		httpGet.addHeader("accept","application/json");
		HttpResponse response= httpClient.execute(httpGet);
		String data=readData(response);
		Gson gson =new Gson();
		return gson.fromJson(data, new TypeToken<List<Data>>() {}.getType());
				
	}
	
	
}