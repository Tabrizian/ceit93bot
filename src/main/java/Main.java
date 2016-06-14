import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import model.Response;

import java.io.IOException;

/**
 * Created by iman on 6/13/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("https://api.telegram.org/bot186821781:AAHotxMYApN32CMRcZz1_lFOqX9ma6EC51c/getUpdates").build();
        com.squareup.okhttp.Response response = okHttpClient.newCall(request).execute();
        Response response1 = gson.fromJson(response.body().string(), Response.class);
        System.out.println(response1.result.get(0).message.text);
    }
}
