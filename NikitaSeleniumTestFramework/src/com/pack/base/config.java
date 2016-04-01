package com.pack.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Holds SI test framework configuration
 */
public class config {

	private  String PROPS_FILE_NAME;
	private  Properties props = new Properties();
	private  boolean propsLoaded = false;
	public config (String filename){
		this.PROPS_FILE_NAME =filename;	 
	}
	/**
	 * Loads properties file
	 */
	public  void loadProps() {
		URL propsFileUrl = null;
		try {
			// try to find props file in classpath
			propsFileUrl = config.class.getClassLoader().getResource(
					PROPS_FILE_NAME);
		} catch (Exception e) {
			throw new RuntimeException("Error loading properties file: "
					+ PROPS_FILE_NAME, e);
		}

		File propsFile = new File(propsFileUrl.getFile());
		try {
			// clear old props
			props.clear();
			// load new props
			props.load(new FileReader(propsFile));
			propsLoaded = true;
		} catch (IOException ioe) {
			throw new RuntimeException("Error reading properties file: "
					+ PROPS_FILE_NAME, ioe);
		}
	}

	/**
	 * 
	 * @param propName
	 * @return prop value
	 */
	public  String getProp(String propName) {
		if (!propsLoaded) {
			loadProps();
		}
		if (!props.containsKey(propName)) {
			throw new RuntimeException("Prop '" + propName
					+ "' not found in config.");
		}
		return props.getProperty(propName);
	}

	// prop name constants
	public static final String LOGIN_url = "LOGIN_url";
	public static final String USER = "u_name";
	public static final String PASSWORD = "pwd";
	public static final String BROWSER_DRIVER = "browser_driver";
	public static final String COMPOSE = "compose_button_xpath";
}
