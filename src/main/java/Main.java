import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import controller.Amazing;
import model.Response;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;

import java.io.IOException;

/**
 * Created by iman on 6/13/16.
 */
public class Main {
    public static void main(String[] args) throws IOException, TelegramApiException {

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        telegramBotsApi.registerBot(new Amazing());
    }
}
