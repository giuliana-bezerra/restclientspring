package br.com.restclientspring;

/**
 * This object encapsulates a request to a service.
 * 
 * @author giuliana.bezerra
 */
public class Request {
	private String serverURL;
	private String resourcePath;

	public String getServerURL() {
		return serverURL;
	}

	public void setServerURL(String serverURL) {
		this.serverURL = serverURL;
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public String getURL() {
		return serverURL + "/" + (resourcePath == null ? "" : resourcePath);
	}

}
