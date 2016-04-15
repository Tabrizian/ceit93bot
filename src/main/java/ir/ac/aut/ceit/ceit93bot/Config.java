package ir.ac.aut.ceit.ceit93bot;

import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Config {
	public String hashId;

	public static Config instance;

	private Config() {
		JSONParser parser = new JSONParser();
		 
		InputStreamReader inputStreamReader = new InputStreamReader(getClass().getResourceAsStream("/user.conf"));

		try {
			
			hashId = (String) ((JSONObject) parser.parse(inputStreamReader)).get("hashId");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}

		return instance;
	}
	
	public String getHashId() {
		return hashId;
	}

	public void setHashId(String hashId) {
		this.hashId = hashId;
	}
}
