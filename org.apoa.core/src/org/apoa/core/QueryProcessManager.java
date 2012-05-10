package org.apoa.core;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IOConsole;

public class QueryProcessManager {
	private String wtfQuery;
	
	public QueryProcessManager(){
//		wtfQuery = parseConsoleLog();
		findConsole();
		
	}

	private String parseConsoleLog() {
		getConsoleLog();
		return null;
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