package ir.ac.aut.ceit.ceit93bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Config {
	public String hashId;

	public static Config instance;

	private Config() {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(getClass().getResourceAsStream("/user.conf")));

		try {
			hashId = br.readLine();
		} catch (IOException e) {
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
