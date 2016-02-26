package com.hybrid;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionTest {
	static Log log = LogFactory.getLog(CollectionTest.class);
	List<String> color;
	Map<String, String> language;
	Set<String> locale;
		
	public List<String> getColor() {
		return color;
	}

	public void setColor(List<String> color) {
		this.color = color;
	}

	public void printColor(){
		for (String c : color) {
			log.info(c);
		}
	}
			
	public Map<String, String> getLanguage() {
		return language;
	}

	public void setLanguage(Map<String, String> language) {
		this.language = language;
	}

	public void printLanguage(){
		Set<Map.Entry<String,String>> entry = language.entrySet();
		for (Entry<String, String> entry2 : entry) {
			log.info(entry2.getKey() + " " + entry2.getValue());
		}
	}
	
	
	public Set<String> getLocale() {
		return locale;
	}

	public void setLocale(Set<String> locale) {
		this.locale = locale;
	}
	
	public void printLocale(){
		for (String string : locale) {
			log.info(string);
		}
	}
	

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans1.xml");
		
		CollectionTest ct = ctx.getBean(CollectionTest.class);
		ct.printColor();
		ct.printLanguage();
		ct.printLocale();
		ctx.close();
	}
}
