package org.apoa.core.handlers;

import org.apoa.core.QueryProcessManager;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ApoaMenuHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public ApoaMenuHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
//		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
//		MessageDialog.openInformation(
//				window.getShell(),
//				"Awesome Plug-in of Awesomeness",
//				"Launch Apoa Query");
		
		// Start the search.
		
		new QueryProcessManager();
		
		return null;
	}
}
