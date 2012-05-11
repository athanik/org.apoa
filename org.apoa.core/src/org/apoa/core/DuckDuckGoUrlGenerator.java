package org.apoa.core;

import java.net.MalformedURLException;
import java.net.URL;

public class DuckDuckGoUrlGenerator implements URLGenerator{

	private final String BASE_URL = "http://duckduckgo.com/?q=";
	
	public DuckDuckGoUrlGenerator() {

	}
	
	@Override
	public URL createUrl(String message) {
		try {
			return new URL(BASE_URL+message);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
