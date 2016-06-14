import org.telegram.telegrambots.api.methods.ForwardMessage;
import org.telegram.telegrambots.api.methods.send.SendMessage;

/**
 * Created by iman on 6/14/16.
 */
public class CeitBot {
    private static CeitBot instance;

    private CeitBot() {

    }

    public static CeitBot getInstance() {

        if(instance == null) {
            instance = new CeitBot();
        }

        return instance;

    }


}
