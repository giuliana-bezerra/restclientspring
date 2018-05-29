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
	private boolean noAuthorizationFile;

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
			// It loads default credentials for tests.
			noAuthorizationFile = true;
		}
	}

	public String getUser() {
		// Default credentials for tests.
		if (noAuthorizationFile)
			return "user";
		return getProperty("user");
	}

	public String getPassword() {
		// Default credentials for tests.
		if (noAuthorizationFile)
			return "password";
		return getProperty("password");
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

}
