import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Server {

	private HttpClient httpClient;
	private Thread listeningThread;

	public Server() {
		httpClient = new DefaultHttpClient();

		listeningThread = new Thread(new Runnable() {

			public void run() {
				while (true) {
					Thread.sleep(500);
					try {
						HttpGet getRequest = new HttpGet(
								"http://api.telegram.org/bot" + Config.getInstance().getHashId() + "/getMe");
						getRequest.addHeader("accept", "application/json");

						HttpResponse response = httpClient.execute(getRequest);

						if (response.getStatusLine().getStatusCode() != 200) {
							throw new RuntimeException(
									"Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
						}

						BufferedReader br = new BufferedReader(
								new InputStreamReader((response.getEntity().getContent())));

						String output;
						System.out.println("Output from Server .... \n");
						while ((output = br.readLine()) != null) {
							System.out.println(output);
						}

						httpClient.getConnectionManager().shutdown();

					} catch (ClientProtocolException e) {

						e.printStackTrace();

					} catch (IOException e) {

						e.printStackTrace();
					}
				}
			}
		});
	}

	public void start() {
		listeningThread.start();
	}
}
