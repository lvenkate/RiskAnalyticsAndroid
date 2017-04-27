package com.quickplay.commons;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QPPropertiesHelper {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	public String getPropertyFromFile(String fileName, String propertyName) {
		Properties prop = new Properties();
		// String propFileName = "config.properties";
		String propFileName = fileName;
		try {
			InputStream inputStream = getClass().getClassLoader()
					.getResourceAsStream(propFileName);
			prop.load(inputStream);
			if (inputStream == null) {
				throw new FileNotFoundException("property file '"
						+ propFileName + "' not found in the classpath");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Exception at getUserIdFromDeviceId", e);
			e.printStackTrace();
		}
		return prop.getProperty(propertyName);
	}

}
