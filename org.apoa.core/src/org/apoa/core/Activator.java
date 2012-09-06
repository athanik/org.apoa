package org.apoa.core;

import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
	
	public static final String QUERY_EXTRACTOR_EXTENSION_ID  = "org.apoa.queryTextExtractor";
	
	public static final String QUERY_PROCESSOR_EXTENSION_ID = "org.apoa.queryProcessor";
	
	private static final String QUERY_RESULTVIEW_EXTENSION_ID = "org.apoa.resultView";

	public static final String CONFIG_EXTENSION_ID = "org.apoa.searchConfiguration";
	
	// The plug-in ID
	public static final String PLUGIN_ID = "org.apoa.core"; //$NON-NLS-1$


	// The shared instance
	private static Activator plugin;

	private APOAConfig config;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		

		
		//initialize config
		config = APOAConfig.get();
		
		parseExtension(CONFIG_EXTENSION_ID, new ConfigRunner("name") {
			@Override
			public void run(String nameValue, IConfigurationElement confElement) throws Exception {
				String description = confElement.getAttribute("description");
				config.getConfigs().put(
						nameValue,
						new Configuration(nameValue,
								(description != null ? description : ""),
								confElement.getAttribute("queryExtractor"),
								confElement.getAttribute("queryProcessor"),
								confElement.getAttribute("resultView")));
			}
		});
		
		parseExtension(QUERY_EXTRACTOR_EXTENSION_ID, config.getExtractors());
		parseExtension(QUERY_PROCESSOR_EXTENSION_ID, config.getProcessors());
		parseExtension(QUERY_RESULTVIEW_EXTENSION_ID, config.getResultViews());


	}
	
	private <T> void parseExtension(String extensionID,final Map<String,T> storeMap) {
		parseExtension(extensionID, new ConfigRunner("name") {
			@SuppressWarnings("unchecked")
			@Override
			public void run(String nameValue, IConfigurationElement confElement) throws Exception {
				System.out.println(nameValue);
				T extractorInstance = (T) confElement
						.createExecutableExtension("class");
				storeMap.put(nameValue, extractorInstance);
				
			}
		});
	}
	
	
	private void parseExtension(String extensionID, ConfigRunner runner) {
		IConfigurationElement[] pluginConfig = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(extensionID);
		for (IConfigurationElement confElement : pluginConfig) {
			String nameValue = null;
			try {
				nameValue = confElement.getAttribute(runner.getNameAttribute());
				runner.run(nameValue, confElement);
				
			} catch (Exception e) {
				e.printStackTrace();
//TODO: create own StatusAdapter
//				StatusManager
//						.getManager()
//						.handle(
//								new StatusInfo(
//										IStatus.ERROR,
//										"iGROM: Failed to initialize "
//												+ (extractorName != null ? "language \""
//														+ extractorName + "\""
//														: "an unknown language")
//												+ "."));
			}

		}
	}
	
	private abstract static class ConfigRunner {
		
		private String nameAttribute;
		
		public ConfigRunner(String nameAttribute) {
			this.nameAttribute = nameAttribute;
		}
		
		public String getNameAttribute() {
			return nameAttribute;
		}
		
		public abstract void run(String nameValue, IConfigurationElement confElement) throws Exception;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		APOAConfig.deInit();
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
