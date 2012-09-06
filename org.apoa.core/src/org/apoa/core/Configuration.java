package org.apoa.core;

import org.apoa.extensions.QueryTextExtractor;
import org.apoa.extensions.ResultView;

/**
 * Stores a configuration block for a solution finding flow
 * for APOA.
 */
public class Configuration {
	
	private String name;
	
	private String description;
	
	private String queryExtractor;
	
	private String queryProcessor;
	
	private String resultView;
	
	public Configuration() {
	}
	

	public Configuration(String name, String description,
			String queryExtractor, String queryProcessor, String resultView) {
		super();
		this.name = name;
		this.description = description;
		this.queryExtractor = queryExtractor;
		this.queryProcessor = queryProcessor;
		this.resultView = resultView;
	}

	/**
	 * @return the name for the configuration
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return an optional description
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the ID of the {@link QueryTextExtractor} extension
	 */
	public String getQueryExtractor() {
		return queryExtractor;
	}

	public void setQueryExtractor(String queryExtractor) {
		this.queryExtractor = queryExtractor;
	}

	/**
	 * @return the ID of the {@link QueryProcessor} extension
	 */
	public String getQueryProcessor() {
		return queryProcessor;
	}

	public void setQueryProcessor(String queryProcessor) {
		this.queryProcessor = queryProcessor;
	}

	/**
	 * @return the ID of the {@link ResultView} extension
	 */
	public String getResultView() {
		return resultView;
	}

	public void setResultView(String resultView) {
		this.resultView = resultView;
	}
	
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+": "+name+"|"+description+"|"+queryExtractor+"|"+queryProcessor+"|"+resultView;
	}
	
	
}
