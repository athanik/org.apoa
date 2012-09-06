package org.apoa.basic;

import java.net.MalformedURLException;
import java.net.URL;

import org.apoa.extensions.QueryCallback;
import org.apoa.extensions.QueryProcessor;

public class DuckDuckGoQueryProcessor implements QueryProcessor {

	private final String BASE_URL = "http://duckduckgo.com/?q=";
	
	@Override
	public void process(String data, QueryCallback callback) {
		try {
			URL query = new URL(BASE_URL+data);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block, refactor into abstract
			e.printStackTrace();
		}
	}

}
