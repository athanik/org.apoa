package org.apoa.extensions;

import java.net.URL;

/**
 * Encapsulates a single result from a search engine, run by {@link QueryProcessor}.
 */
public class QueryResult {

	private String name;
	
	private String description;

	private URL url;
	
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name of the resulting website/resource
	 */
	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return any additional text that should accompany the result
	 */
	public String getDescription() {
		return description;
	}

	public void setURL(URL url) {
		this.url = url;
	}

	/**
	 * @return the Uniform Resource Locator for the result
	 */
	public URL getURL() {
		return url;
	}

}
