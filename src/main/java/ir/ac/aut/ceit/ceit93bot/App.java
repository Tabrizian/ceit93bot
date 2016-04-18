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
            try {

                while (server.getUpdates().size() > 0) {
                    JSONObject message = (JSONObject) ((JSONArray) server.getUpdates().get(0)).get(0);
                    ceitBot.sendMessageToAdmins((String) ((JSONObject) message.get("message")).get("text"));
                    server.getUpdates().remove(0);
                }

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
