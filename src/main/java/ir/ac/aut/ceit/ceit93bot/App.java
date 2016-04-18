package ir.ac.aut.ceit.ceit93bot;

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

            for (Object message :
                    server.getUpdates()) {
                ceitBot.sendMessageToAdmins((String) ((JSONObject) message).get("text"));

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
