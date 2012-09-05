package org.apoa.core;

import java.net.URL;
import java.net.URLEncoder;

import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IOConsole;

public class QueryProcessManager {
	private String wtfQuery;
	private URL url;
	private URLGenerator urlGenerator = new DuckDuckGoUrlGenerator();
	
	private static final String [] SEARCH_PHRASES = {"\nRoot cause:","\nCaused by:"};
	private static final String MAIN_EXCEPTION_PHRASE = "Exception in thread";
	public QueryProcessManager(){
		
		String consoleContents = getConsoleLog();
		wtfQuery = parseConsole(consoleContents);
		
		url = urlGenerator.createUrl(toUtf8(wtfQuery));
		
		openInternalBrowser(url);
	}

	private String parseConsole(String consoleContents) {
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
		
		
		int indexMain = consoleContents.lastIndexOf(MAIN_EXCEPTION_PHRASE);
		String consoleExceptionLine = consoleContents.substring(indexMain,consoleContents.substring(indexMain).indexOf("\n")).replaceAll("\\\".*?\\\"", "");
		
		//extract the main exception
		return consoleExceptionLine + " "+result;
	}

	private String toUtf8(String string) {
		try {
			return URLEncoder.encode(string, "UTF-8");
		} catch (Exception e) {

		}
		return "";
	}		

private void openInternalBrowser(URL url) {
	try {
		IWebBrowser browser = Activator.getDefault().getWorkbench().getBrowserSupport().createBrowser("APOA_BROWSER");
		browser.openURL(url);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}



	   private String getConsoleLog() {
		      ConsolePlugin plugin = ConsolePlugin.getDefault();
		      IConsoleManager conMan = plugin.getConsoleManager();
		      IConsole[] existing = conMan.getConsoles();
//		      System.out.println("----------------------------");
		      int latest = existing.length-1;
		      IOConsole ic = (IOConsole)existing[latest];
//		            System.out.println("Console name :" + ic.getName() + "\nConsole type: " + ic.getType() + "\n\n***********************************" +ic.getDocument().get());
		      return ic.getDocument().get();
		            //no console found, so create a new one
		   }
}
