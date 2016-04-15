package ir.ac.aut.ceit.ceit93bot;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

public class Server {

	private HttpClient httpClient;
	private Handler updateHandler;
	

	public Server() {
		httpClient = new DefaultHttpClient();

		new Thread(new Handler(httpClient)).start();
	}
	
	

}
