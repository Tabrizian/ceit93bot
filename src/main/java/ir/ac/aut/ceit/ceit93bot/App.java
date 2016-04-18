package ir.ac.aut.ceit.ceit93bot;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Server server = new Server();
        CEITBot ceitBot = new CEITBot();
        while (true) {
            System.out.println(server.getUpdates());
            if (server.getUpdates().size() > 0)
                for (Object message :
                        (JSONArray) ((JSONArray) server.getUpdates()).get(0)) {
                    ceitBot.sendMessageToAdmins((String) ((JSONObject) ((JSONObject) message).get("message")).get("text"));
                }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
