package org.apoa.core;

import java.util.HashMap;
import java.util.Map;

import org.apoa.extensions.QueryProcessor;
import org.apoa.extensions.QueryTextExtractor;
import org.apoa.extensions.ResultView;

public class APOAConfig {
	
	//singleton handling
	private static APOAConfig instance;
	
	private APOAConfig() {
		extractors = new HashMap<String, QueryTextExtractor>();
		processors = new HashMap<String, QueryProcessor>();
		resultViews = new HashMap<String, ResultView>();
		configs = new HashMap<String, Configuration>();
	}
	
	/**
	 * @return the singleton {@link APOAConfig} instance
	 */
	public static APOAConfig get() {
		if(instance == null) {
			instance = new APOAConfig();
		}
		
		return instance;
	}
	
	/**
	 * Deinitialize the singleton (used when stopping the bundle).
	 */
	protected static void deInit() {
		instance = null;
	}
	
	
	//class functionality
	private Map<String,QueryTextExtractor> extractors;
	
	private Map<String,QueryProcessor> processors;
	
	private Map<String,ResultView> resultViews;
	
	private Map<String,Configuration> configs;
	
	protected Map<String, QueryTextExtractor> getExtractors() {
		return extractors;
	}
	
	public QueryTextExtractor getExtractor(String id) {
		return extractors.get(id);
	}
	
	protected Map<String, QueryProcessor> getProcessors() {
		return processors;
	}
	
	public QueryProcessor getProcessor(String id) {
		return processors.get(id);
	}
	
	public Map<String, ResultView> getResultViews() {
		return resultViews;
	}
	
	public ResultView getResultViews(String id) {
		return resultViews.get(id);
	}
	
	protected Map<String, Configuration> getConfigs() {
		return configs;
	}
	
	public Configuration getConfig(String id) {
		return configs.get(id);
	}

}
