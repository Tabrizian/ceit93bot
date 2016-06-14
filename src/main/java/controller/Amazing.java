package controller;

import model.Configuration;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.ForwardMessage;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.bots.TelegramWebhookBot;

/**
 * Created by iman on 6/14/16.
 */
public class Amazing extends TelegramLongPollingBot {


    public void onUpdateReceived(Update update) {
        forwardMessageToAdmins(String.valueOf(update.getMessage().getChatId()), update.getMessage().getMessageId());
    }

    public String getBotUsername() {
        return Config.getInstance().getConfiguration().username;
    }

    public String getBotToken() {
        return Config.getInstance().getConfiguration().hashId;
    }

    public void sendMessageToAdmins(String message) {
        sendMessage("135707278", message); //Iman Tabrizian
        sendMessage("94393474", message); // Amir Salari
        sendMessage("104233964", message); // Emran Batman
        sendMessage("64793874", message); // Ammar Gilani
        sendMessage("92811076", message); // AliAkbar Badri
        sendMessage("98545242", message); // Amirhossesion Bavand
    }

    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public void forwrardMessage(String toChatId, String fromChatId, int messageId) {
        ForwardMessage forwardMessage = new ForwardMessage();
        forwardMessage.setFromChatId(fromChatId);
        forwardMessage.setChatId(toChatId);
        forwardMessage.setMessageId(messageId);
        try {
            forwardMessage(forwardMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void forwardMessageToAdmins(String fromChatId, int messageId) {
        forwrardMessage("135707278", fromChatId, messageId); //Iman Tabrizian
        forwrardMessage("94393474", fromChatId, messageId); // Amir Salari
        forwrardMessage("104233964", fromChatId, messageId); // Emran Batman
        forwrardMessage("64793874", fromChatId, messageId); // Ammar Gilani
        forwrardMessage("92811076", fromChatId, messageId); // AliAkbar Badri
        forwrardMessage("98545242", fromChatId, messageId); // Amirhossesion Bavand
    }
}
