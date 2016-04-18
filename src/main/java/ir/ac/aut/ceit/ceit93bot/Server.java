package ir.ac.aut.ceit.ceit93bot;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;

public class Server {

	private HttpClient httpClient;
	private Handler updateHandler;

	public Server() {
		httpClient = new DefaultHttpClient();
		updateHandler = new Handler(httpClient);
		new Thread(updateHandler).start();

	}

	public JSONArray getUpdates() {
		return updateHandler.getUpdates();
	}

	public HttpClient getHttpClient() {
		return httpClient;
	}
}
