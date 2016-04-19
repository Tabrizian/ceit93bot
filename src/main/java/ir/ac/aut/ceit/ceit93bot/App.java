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
                    boolean send = true;

                    JSONObject update = (JSONObject) ((JSONArray) server.getUpdates().get(0)).get(0);
                    JSONObject message = (JSONObject) update.get("message");
                    JSONArray entities = (JSONArray) message.get("entities");
                    JSONObject user = (JSONObject) message.get("user");
                    if (entities != null)
                        for (Object entity :
                                entities) {
                            if (((JSONObject) entity).get("type").equals("bot_command")) {
                                send = false;
                                if (((String) message.get("text")).equals("/sendmessage")) {
                                    JSONObject chat = (JSONObject) message.get("chat");
                                    Long id = (Long) chat.get("id");
                                    ceitBot.sendMessage(id, "باتشکر از پیام شما، پیام شما برای ما ارسال شد.");
                                }
                            }
                        }
                    if (send) {
                        if(user != null) {
                            ceitBot.sendMessageToAdmins("From :" + (String) user.get("first_name"));
                            String lastName = (String) user.get("last_name");
                            if (lastName != null)
                                ceitBot.sendMessageToAdmins((String) user.get("last_name"));
                            ceitBot.sendMessageToAdmins((String) message.get("text"));
                        }
                    }
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
