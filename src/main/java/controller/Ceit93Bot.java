package controller;

import helper.MessageHelper;
import org.apache.commons.logging.Log;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.ForwardMessage;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

/**
 * Created by iman on 6/14/16.
 */
public class Ceit93Bot extends TelegramLongPollingBot implements Filterable {

    public void onUpdateReceived(Update update) {
        if(update.getMessage().isReply()) {
            if(update.getMessage().getChatId() == 135707278) {
                Integer id = update.getMessage().getReplyToMessage().getForwardFrom().getId();
                sendMessage(String.valueOf(id), update.getMessage());
            }
        } else {
            forwardMessageToAdmins(update.getMessage());
        }

    }

    public String getBotUsername() {
        return Config.getInstance().getConfiguration().username;
    }

    public String getBotToken() {
        return Config.getInstance().getConfiguration().hashId;
    }

    public void sendMessageToAdmins(Message message) {
        sendMessage("135707278", message); //Iman Tabrizian
        sendMessage("94393474", message); // Amir Salari
        sendMessage("104233964", message); // Emran Batman
        sendMessage("92811076", message); // AliAkbar Badri
        sendMessage("98545242", message); // Amirhossesion Bavand
    }

    public void sendMessage(String chatId, Message message) {
        try {
            sendMessage(new SendMessage().setText(message.getText()).setChatId(chatId));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public void forwrardMessage(Message message, String toChatId) {
        ForwardMessage forwardMessage = new ForwardMessage();
        forwardMessage.setFromChatId(String.valueOf(message.getChatId()));
        forwardMessage.setChatId(toChatId);
        forwardMessage.setMessageId(message.getMessageId());
        try {
            forwardMessage(forwardMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void forwardMessageToAdmins(Message message) {
        forwrardMessage(message, "135707278"); //Iman Tabrizian
        forwrardMessage(message, "94393474"); // Amir Salari
        forwrardMessage(message, "104233964"); // Emran Batman
        forwrardMessage(message, "64793874"); // Ammar Gilani
        forwrardMessage(message, "92811076"); // AliAkbar Badri
        forwrardMessage(message, "98545242"); // Amirhossesion Bavand
    }

    public boolean filter(Message message) {
        if (message.isCommand()) {
            return true;
        }

        return false;
    }
}
