package br.com.restclientjersey;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * It loads configuration for accessing the service.
 * 
 * @author giuliana.bezerra
 *
 */
public class ConfigurationIO {
	private Properties properties = new Properties();
	private InputStream inputStream = null;
	private static ConfigurationIO singleton;

	public static ConfigurationIO getInstance() throws IOException {
		if (singleton == null)
			singleton = new ConfigurationIO();
		return singleton;
	}

	private ConfigurationIO() throws IOException {
		try {
			inputStream = new FileInputStream("/etc/config/restclientspring/authorization.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			throw new IOException("File not found: authorization.properties not found to load service credentials.", e);
		}
	}

	public String getUser() {
		return getProperty("user");
	}

	public String getPassword() {
		return getProperty("password");
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

}
