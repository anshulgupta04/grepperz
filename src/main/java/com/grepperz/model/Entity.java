package com.grepperz.model;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Entity {

	private long pid;
	private String title;
	private double price;
	private Date date;
	private String imageUrl;
	private String description;
	private String link;
	private String store;

	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	
	public Map<String,String> toMap(){
		
		Map<String, String> map = new HashMap<>();
		try {
			Class clz = this.getClass();
			for (Field f : clz.getDeclaredFields()) {
				map.put(f.getName(), (String) f.get(f.getName()));
			}
		} catch (Exception e) {
		}
		return map;
	}
}
