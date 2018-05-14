package advprog.example.bot.controller;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

import java.io.IOException;
import java.util.logging.Logger;

import oriconbd.implementation.DailyRank;
import oriconbd.implementation.WeeklyRank;

@LineMessageHandler
public class OriconController {
    private static final Logger LOGGER = Logger.getLogger(
            OriconController.class.getName());

    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event)
        throws IOException {
        LOGGER.fine(String.format("TextMessageContent(timestamp='%s', content='%s')",
                event.getTimestamp(), event.getMessage()));
        TextMessageContent content = event.getMessage();
        String contentText = content.getText();
        String[] stringSplit = contentText.split(" ");
        if (stringSplit[0].contains("/oricon") && stringSplit.length == 4
                && stringSplit[1].contains("/bluray")) {
            String date = stringSplit[3];
            if (stringSplit[2].contains("weekly")) {
                WeeklyRank weeklyRank = new WeeklyRank();
                return weeklyRank.run(date);
            } else if (stringSplit[2].contains("daily")) {
                DailyRank dailyRank = new DailyRank();
                return dailyRank.run(date);
            }
        }
        return new TextMessage("Wrong Input sorry example "
                + "input:'/oricon bluray weekly 2018-05-09'");
    }

    @EventMapping
    public void handleDefaultMessage(Event event) {
        LOGGER.fine(String.format("Event(timestamp='%s',source='%s')",
                event.getTimestamp(), event.getSource()));
    }
}
