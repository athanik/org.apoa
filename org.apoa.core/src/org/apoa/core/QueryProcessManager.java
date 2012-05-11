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
	
	public QueryProcessManager(){
		wtfQuery = "java tutorial";
		
		url = urlGenerator.createUrl(toUtf8(wtfQuery));
		
		openInternalBrowser(url);
		
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
	
		return null;
	}

	   private void findConsole() {
		      ConsolePlugin plugin = ConsolePlugin.getDefault();
		      IConsoleManager conMan = plugin.getConsoleManager();
		      IConsole[] existing = conMan.getConsoles();
		      System.out.println("----------------------------");
		      int latest = existing.length-1;
		      IOConsole ic = (IOConsole)existing[latest];
		            System.out.println("Console name :" + ic.getName() + "\nConsole type: " + ic.getType() + "\n\n***********************************" +ic.getDocument().get());
		      //no console found, so create a new one
		   }
}
