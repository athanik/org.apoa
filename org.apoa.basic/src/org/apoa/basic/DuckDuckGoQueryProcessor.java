package org.apoa.basic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

import org.apoa.extensions.QueryCallback;
import org.apoa.extensions.QueryProcessor;
import org.apoa.extensions.QueryResult;

/**
 * Basic query processor that's intended to work with a BrowserView. Doesn't
 * actually supply a list of results, just a URL.
 */
public class DuckDuckGoQueryProcessor implements QueryProcessor {

	private final String BASE_URL = "http://duckduckgo.com/?q=";

	@Override
	public void process(String data, QueryCallback callback) {
		try {
			callback.process(Collections.singletonList(new QueryResult(
					"DuckDuckGo Result", "", new URL(BASE_URL + data))));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block, refactor into abstract
			e.printStackTrace();
		}
	}

}
