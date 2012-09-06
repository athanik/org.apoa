package org.apoa.basic;

import org.apoa.extensions.QueryTextExtractor;
import org.apoa.extensions.util.AbstractTextExtractor;
import org.eclipse.ui.console.IConsole;

/**
 * A very basic extract, looks for specific keywords inside the first 
 * (presumed active) console.
 */
public class BasicTextExtractor extends AbstractTextExtractor implements QueryTextExtractor {

	private static final String [] SEARCH_PHRASES = {"\nRoot cause:","\nCaused by:"};
	private static final String MAIN_EXCEPTION_PHRASE = "Exception in thread";
	
	public BasicTextExtractor() {
	}

	@Override
	public boolean filterConsoles(IConsole[] consoles) {
		boolean resSup = super.filterConsoles(consoles);
		if(!resSup) {
			return false;
		}
		this.consoles = this.consoles.subList(0, 1);
		return true;
	}

	
	@Override
	public String parseConsole() {
		
		//find "root cause" strings, those are usually
		//related to the library that the developer is using
		String consoleContents = getConsoleContents(0);
		String result = "";
		for(String phrase : SEARCH_PHRASES) {
			int index = consoleContents.lastIndexOf(phrase);
			if(!(index < 0)) {
				index++;
				int lineEnd = consoleContents.substring(index).indexOf('\n');
				result = consoleContents.substring(index,index+lineEnd).trim();
				break;
			}
		}
		
		//find the top exception
		int indexMain = consoleContents.lastIndexOf(MAIN_EXCEPTION_PHRASE);
		String consoleExceptionLine = consoleContents.substring(indexMain,consoleContents.substring(indexMain).indexOf("\n")).replaceAll("\\\".*?\\\"", "");
		
		//return both strings, if applicable,
		//trim() since consoleExceptionLine may be empty
		return (consoleExceptionLine + " "+result).trim();
	}

}
