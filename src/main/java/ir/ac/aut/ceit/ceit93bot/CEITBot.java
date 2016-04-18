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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
        HttpGet getRequest = null;
        try {
            getRequest = new HttpGet(
                    "http://api.telegram.org/bot" + Config.getInstance().getHashId()
                            + "/sendMessage?" + "chat_id=" + chatId + "&" + "text=" + URLEncoder.encode(message,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        getRequest.addHeader("accept", "application/json");

        try {
            HttpResponse response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException(
                        "Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }

            InputStream inputStream = response.getEntity().getContent();
            while (inputStream.read() > 0);

            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
