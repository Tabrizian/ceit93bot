package controller;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.util.ArrayList;

/**
 * Created by iman on 6/14/16.
 */
public class DefaultHttpClient {

    private static DefaultHttpClient instance;
    private OkHttpClient okHttpClient;

    private DefaultHttpClient() {
        okHttpClient = new OkHttpClient();
    }

    public static DefaultHttpClient getInstance() {
        if(instance == null) {
            instance = new DefaultHttpClient();
        }

        return instance;
    }


}
