package ir.ac.aut.ceit.ceit93bot;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.json.simple.JSONArray;

public class Handler implements Runnable {

	private HttpClient httpClient;
	private JSONArray updates;

	public Handler(HttpClient httpClient) {
		this.httpClient = httpClient;
	}

	public void run() {
		while (true) {
			try {
				HttpGet getRequest = new HttpGet(
						"http://api.telegram.org/bot" + Config.getInstance().getHashId() + "/getUpdates");
				getRequest.addHeader("accept", "application/json");

				HttpResponse response = httpClient.execute(getRequest);

				if (response.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException(
							"Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
				}

				updates = (JSONArray) response.getEntity();

			} catch (ClientProtocolException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

}
