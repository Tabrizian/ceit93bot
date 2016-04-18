package ir.ac.aut.ceit.ceit93bot;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.DefaultedHttpParams;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.io.InputStream;

public class CEITBot {

    private HttpClient httpClient;

    public CEITBot() {
        this.httpClient = new DefaultHttpClient();
    }

    public void sendMessageToAdmins(String message) {
        sendMessage(135707278, message);
        sendMessage(94393474, message);
    }

    public void sendMessage(int chatId, String message) {
        HttpGet getRequest = new HttpGet(
                "http://api.telegram.org/bot" + Config.getInstance().getHashId()
                        + "/sendMessage?" + "chat_id=" + chatId + "&" + "text=" + message);
        getRequest.addHeader("accept", "application/json");

        try {
            HttpResponse response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException(
                        "Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }

            InputStream inputStream = response.getEntity().getContent();
            while (inputStream.read() > 0);

            System.out.println("Success");
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
