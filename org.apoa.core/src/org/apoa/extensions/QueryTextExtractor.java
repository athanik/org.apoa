package org.apoa.extensions;

import org.eclipse.ui.console.IConsole;

/**
 * Encapsulates functionality for preparing a search string for a {@link QueryProcessor}.
 */
public interface QueryTextExtractor {
	
	/**
	 * @param consoles the currently available consoles
	 * @return <code>true</code> if at least one appropriate console has been found, <code>false</code> 
	 * otherwise.
	 */
	public boolean filterConsoles(IConsole [] consoles);
	public String parseConsole();
}
