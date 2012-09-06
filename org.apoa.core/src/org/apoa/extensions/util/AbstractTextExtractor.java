package org.apoa.extensions.util;

import java.util.ArrayList;
import java.util.List;

import org.apoa.extensions.QueryTextExtractor;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IOConsole;

/**
 * Utility class for implementing {@link QueryTextExtractor}s.
 * <p>Contains basic filtering facilities, so that you only 
 * need to deal with {@link IOConsole}s
 */
public abstract class AbstractTextExtractor implements QueryTextExtractor {

	protected List<IOConsole> consoles;
	
	@Override
	public boolean filterConsoles(IConsole[] consoles) {
		this.consoles = new ArrayList<IOConsole>();
		if(consoles == null || consoles.length == 0) {
			return false;
		}
		
		for(IConsole console : consoles) {
			if(console instanceof IOConsole) {
				this.consoles.add((IOConsole) console);
			}
		}
		
		return !this.consoles.isEmpty();
	}
	
	
	/**
	 * @param index the list index inside {@link AbstractTextExtractor#consoles}
	 * @return the full content string of the given console
	 */
	protected String getConsoleContents(int index) {
		return consoles.get(index).getDocument().get();
	}

}
