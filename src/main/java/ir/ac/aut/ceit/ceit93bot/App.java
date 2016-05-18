package ir.ac.aut.ceit.ceit93bot;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Server server = new Server();
        CeitBot ceitBot = new CeitBot();
        ArrayList<String> subjects = new ArrayList<>();
        ArrayList<ArrayList<Long>> associatedUserIds = new ArrayList<>();
        while (true) {
            try {
                while (server.getUpdates().size() > 0) {
                    boolean send = true;

                    JSONObject update = (JSONObject) ((JSONArray) server.getUpdates().get(0)).get(0);
                    JSONObject message = (JSONObject) update.get("message");
                    JSONArray entities = (JSONArray) message.get("entities");
                    String messageText = (String) message.get("text");
                    Long chatId = (Long) ((JSONObject) message.get("chat")).get("id");
                    if (messageText.startsWith("--")) {
                        int requestSubject = -1;
                        for (int i = 0; i < subjects.size(); i++) {
                            if (messageText.contains("--" + subjects.get(i))) {
                                requestSubject = i;
                                break;
                            }
                        }

                        if (requestSubject == -1) {
                            ArrayList<Long> userIds = new ArrayList<>();
                            associatedUserIds.add(userIds);
                            String firstLine = messageText.split("\n")[0];
                            subjects.add(firstLine.substring(2, firstLine.length()));
                            userIds.add(chatId);
                            requestSubject = subjects.size() - 1;
                        } else {
                            associatedUserIds.get(requestSubject).add(chatId);
                        }

                        for (Long userId:
                             associatedUserIds.get(requestSubject)) {
                            ceitBot.forwrardMessage(userId, chatId, (Long) message.get("message_id"));
                        }
                    } else {


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
                            long fromChatId = (long) ((JSONObject) message.get("chat")).get("id");
                            long messageId = (long) (message.get("message_id"));
                            ceitBot.forwardMessageToAdmins(fromChatId, messageId);

                        }
                        server.getUpdates().remove(0);
                    }

                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


}
