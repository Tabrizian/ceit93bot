import controller.Ceit93Bot;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;

import java.io.IOException;

/**
 * Created by iman on 6/13/16.
 */
public class Main {
    public static void main(String[] args) throws IOException, TelegramApiException {

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        telegramBotsApi.registerBot(new Ceit93Bot());
    }
}
