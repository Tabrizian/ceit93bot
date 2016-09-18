package controller;


import org.telegram.telegrambots.api.objects.Message;

/**
 * Created by iman on 7/18/16.
 */
public interface Filterable {
    boolean filter(Message message);
}
