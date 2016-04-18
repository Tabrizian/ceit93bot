package ir.ac.aut.ceit.ceit93bot;

import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Handler implements Runnable {

    private HttpClient httpClient;
    private JSONArray updates = new JSONArray();
    private JSONParser parser = new JSONParser();
    private long offset = -1;

    public Handler(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                HttpGet getRequest = new HttpGet(
                        "http://api.telegram.org/bot" + Config.getInstance().getHashId() + "/getUpdates?offset=" + offset);
                getRequest.addHeader("accept", "application/json");

                HttpResponse response = httpClient.execute(getRequest);

                if (response.getStatusLine().getStatusCode() != 200) {
                    throw new RuntimeException(
                            "Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
                }

                try {

                    Object result = parser.parse(new InputStreamReader(response.getEntity().getContent()));
                    if (result != null) {
                        JSONArray array = (JSONArray) ((JSONObject) result).get("result");
                        if (array.size() != 0 && array != null) {
                            setUpdates(array);
                            offset = (Long) ((JSONObject) array.get(array.size() - 1)).get("update_id") + 1;
                        }
                    }

                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } catch (ClientProtocolException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray getUpdates() {
        while (updates == null) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return updates;
    }

    public void setUpdates(JSONArray updates) {
        this.updates.add(updates);
    }

    public void removeUpdate(Object object) {
        updates.remove(object);
    }

}
