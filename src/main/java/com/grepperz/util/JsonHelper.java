package com.grepperz.util;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.grepperz.model.Entity;

public class JsonHelper {

	public static List<Entity> unmarshall(String jsonString) {
		if(jsonString == null || jsonString.length() == 0) return null;
		
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;
		List<Entity> entityList = new ArrayList<>();
		try {
		
			JSONParser jsonParser = new JSONParser();
			jsonArray = (JSONArray) jsonParser.parse(jsonString);
			
			for(int i=0;i<jsonArray.size();i++){
				
				jsonObject = (JSONObject)jsonArray.get(i);
				Entity entity = new Entity();
				convertToEntity(entity, jsonObject);
				entityList.add(entity);
			}
			
		}catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return entityList;
	}
	
	public String marshall(Object obj){
		
		if(obj == null)return null;
		
		StringWriter out = new StringWriter();
		try{
			JSONObject jsonObject = new JSONObject();
			jsonObject.writeJSONString(out);
		}catch(Exception e){
			
		}
		return out.toString();
	}
	
	private static void convertToEntity(Entity entity, JSONObject obj){
		
		if(entity == null) entity = new Entity();
		entity.setDescription((String)obj.get("description").toString());
		entity.setImageUrl((String)obj.get("image"));
		entity.setLink((String)obj.get("link"));
		entity.setPrice(Double.parseDouble((String)obj.get("price")));
		entity.setStore((String) obj.get("store"));
		entity.setTitle((String)obj.get("title"));
	}
}
