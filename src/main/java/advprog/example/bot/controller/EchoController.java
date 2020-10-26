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
public class EchoController {

    private static final Logger LOGGER = Logger.getLogger(EchoController.class.getName());

    @EventMapping
        public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) throws
            IOException {
        LOGGER.fine(String.format("TextMessageContent(timestamp='%s',content='%s')",
                event.getTimestamp(), event.getMessage()));

        TextMessageContent content = event.getMessage();
        String contentText = content.getText();
        String[] contentSplit = contentText.split(" ");
        if (contentSplit[0].equals("/echo")) {
            String replyText = contentText.replace("/echo", "");
            return new TextMessage(replyText.substring(1));
        } else if (contentSplit[0].equals("/oricon") && contentSplit.length == 4
                && contentSplit[1].equals("bluray")) {
            String date = contentSplit[3];
            if (contentSplit[2].equals("weekly")) {
                WeeklyRank weeklyRank = new WeeklyRank();
                return weeklyRank.run(date);
            } else if (contentSplit[2].equals("daily")) {
                DailyRank dailyRank = new DailyRank();
                return dailyRank.run(date);
            }
        } else if (contentSplit[0].equals("/oriconHelp")) {
            String help = "Help with Bot:\n"
                    + "/oricon bluray have 2 commands:\n"
                    + "1. /oricon bluray weekly:\n"
                    + "    Input spesification:\n"
                    + "    /orican bluray weekly <<date>>\n"
                    + "    date should be on monday and at 6 Week Range from date today\n"
                    + "2. /oricon bluray daily:\n"
                    + "    Input spesification:\n"
                    + "    /orican bluray daily <<date>>\n"
                    + "    date should be on 8 days Range from date 2 days ago to 10 days ago";
            return new TextMessage(help);
        } else if (contentSplit[0].equals("/author")) {
            String author = "Agas Yanpratama\n"
                    + "1606918396\n"
                    + "Advanced Programming - A\n"
                    + "Tugas Akhir Adprog 2018 - 1";
            return new TextMessage(author);
        }
        return new TextMessage("Wrong Command\n"
                + "Command List:\n"
                + "/oriconHelp\n"
                + "/author\n"
                + "/oricon bluray (daily/weekly) _date_\n"
                + "/echo <<message>>");
    }

    @EventMapping
    public void handleDefaultMessage(Event event) {
        LOGGER.fine(String.format("Event(timestamp='%s',source='%s')",
                event.getTimestamp(), event.getSource()));
    }
}
