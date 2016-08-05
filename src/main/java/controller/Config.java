package controller;

import com.google.gson.Gson;
import model.Configuration;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by iman on 6/14/16.
 */

public class Config {

    private static Config instance;
    private Configuration configuration;

    private Config() {

        InputStreamReader inputStreamReader = new InputStreamReader(getClass().getResourceAsStream("/user.conf"));

        Gson gson = new Gson();
        configuration = gson.fromJson(inputStreamReader, Configuration.class);

    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }

        return instance;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}