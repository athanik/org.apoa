package org.apoa.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IOConsole;

public class QueryProcessManager {
//	private String wtfQuery;
	
	public QueryProcessManager(){
//		wtfQuery = parseConsoleLog();
		findConsole();
		openBrowser();
		
	}

	private void openBrowser() {
		try {
			IWorkbenchBrowserSupport browserSupport = PlatformUI.getWorkbench().getBrowserSupport();
			browserSupport.getExternalBrowser().openURL(new URL("http://www.eniro.se"));
		} catch (PartInitException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

//	private String parseConsoleLog() {
//		getConsoleLog();
//		return null;
//	}

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
