package helper;

import org.telegram.telegrambots.api.objects.Message;

/**
 * Created by iman on 8/5/16.
 */
public class MessageHelper {
    public static boolean isStudyGroupMessage(Message message) {
        if(message.getText().startsWith("#")) {
            return true;
        } else {
            return false;
        }

    }
}
