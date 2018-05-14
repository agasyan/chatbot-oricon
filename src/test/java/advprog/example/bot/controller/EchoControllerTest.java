package advprog.example.bot.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import advprog.example.bot.EventTestUtil;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(properties = "line.bot.handler.enabled=false")
@ExtendWith(SpringExtension.class)
public class EchoControllerTest {

    static {
        System.setProperty("line.bot.channelSecret", "SECRET");
        System.setProperty("line.bot.channelToken", "TOKEN");
    }

    @Autowired
    private EchoController echoController;

    @Test
    void testContextLoads() {
        assertNotNull(echoController);
    }

    @Test
    void testHandleTextMessageEventEcho() throws IOException {
        MessageEvent<TextMessageContent> event =
                EventTestUtil.createDummyTextMessage("/echo test echo");

        TextMessage reply = echoController.handleTextMessageEvent(event);

        assertEquals("test echo", reply.getText());
    }

    @Test
    void testHandleTextMessageEventWrongCommand() throws IOException {
        MessageEvent<TextMessageContent> event =
                EventTestUtil.createDummyTextMessage("Starbust Stream");

        TextMessage reply = echoController.handleTextMessageEvent(event);
        String wrongMessageExpected = "Wrong Command\n"
                + "Command List:\n"
                + "/oriconHelp\n"
                + "/author\n"
                + "/oricon bluray (daily/weekly) _date_\n"
                + "/echo <<message>>";
        assertEquals(wrongMessageExpected, reply.getText());
    }

    @Test
    void testHandleTextMessageEventHelp() throws IOException {
        MessageEvent<TextMessageContent> event =
                EventTestUtil.createDummyTextMessage("/oriconHelp");

        TextMessage reply = echoController.handleTextMessageEvent(event);

        String helpExpected = "Help with Bot:\n"
                + "/oricon bluray have 2 commands:\n"
                + "1. /oricon bluray weekly:\n"
                + "    Input spesification:\n"
                + "    /orican bluray weekly <<date>>\n"
                + "    date should be on monday and at 6 Week Range from date today"
                + "2. /oricon bluray daily:\n"
                + "    Input spesification:\n"
                + "    /orican bluray daily <<date>>\n"
                + "    date should be on 8 days Range from date 2 days ago to 10 days ago";
        assertEquals(helpExpected, reply.getText());
    }

    @Test
    void testHandleTextMessageEventAuthor() throws IOException {
        MessageEvent<TextMessageContent> event =
                EventTestUtil.createDummyTextMessage("/author");

        TextMessage reply = echoController.handleTextMessageEvent(event);

        String authorExpected = "Agas Yanpratama\n"
                + "1606918396\n"
                + "Advanced Programming - A\n"
                + "Tugas Akhir Adprog 2018 - 1";
        assertEquals(authorExpected, reply.getText());
    }

    @Test
    void testHandleTextMessageEventOriconBlurayDaily() throws IOException {
        MessageEvent<TextMessageContent> event =
                EventTestUtil.createDummyTextMessage("/oricon bluray daily 2018-05-12");

        TextMessage reply = echoController.handleTextMessageEvent(event);

        String dailyExpected = "Top 10 Oricon BD as requested \n"
                + "(1) 劇場版「Fate/stay night[Heaven’s Feel]�T.presage flower」(完全生産限定版)"
                + " - アニメーション - 2018-05-09\n"
                + "(2) スター・ウォーズ/最後のジェダイ MovieNEX(初回版) - マーク・ハミル - 2018-04-25\n"
                + "(3) 劇場版「Fate/stay night[Heaven’s Feel]�T.presage flower」(通常版)"
                + " - アニメーション - 2018-05-09\n"
                + "(4) ナラタージュ Blu-ray 豪華版 - 松本潤 - 2018-05-09\n"
                + "(5) Little Glee Monster Arena Tour 2018 -juice !!!!!- at YOKOHAMA ARENA"
                + " - Little Glee Monster - 2018-05-09\n"
                + "(6) カードキャプターさくら クリアカード編 Vol.1＜初回仕様版＞ - アニメーション - 2018-05-09\n"
                + "(7) ワイルド・スピード ICE BREAK - ヴィン・ディーゼル - 2018-05-09\n"
                + "(8) キャプテン・アメリカ/ザ・ファースト・アベンジャー MovieNEX - クリス・エヴァンス - 2018-04-04\n"
                + "(9) シビル・ウォー/キャプテン・アメリカ MovieNEX - クリス・エヴァンス - 2016-09-16\n"
                + "(10) マイティ・ソー バトルロイヤル MovieNEX - クリス・ヘムズワース - 2018-03-07";
        assertEquals(dailyExpected, reply.getText());
    }

    @Test
    void testHandleTextMessageEventOriconBlurayWeekly() throws IOException {
        MessageEvent<TextMessageContent> event =
                EventTestUtil.createDummyTextMessage("/oricon bluray weekly 2018-05-07");

        TextMessage reply = echoController.handleTextMessageEvent(event);
        String weeklyExpected = "Top 10 Oricon BD as requested \n"
                + "(1) スター・ウォーズ/最後のジェダイ MovieNEX(初回版) - マーク・ハミル"
                + " - 2018-04-25\n"
                + "(2) ラブライブ!サンシャイン!! 2nd Season 5【特装限定版】 - アニメーション"
                + " - 2018-04-24\n"
                + "(3) SHOGO HAMADA ON THE ROAD 2015-2016“Journey of a Songwriter” -"
                + " 浜田省吾 - 2018-04-25\n"
                + "(4) ラブライブ!サンシャイン!! Aqours 2nd LoveLive! HAPPY PARTY TRAIN TOUR "
                + "Blu-ray Memorial BOX - Aqours - 2018-04-25\n"
                + "(5) THE IDOLM@STER SideM GREETING TOUR 2017 〜BEYOND THE DREAM〜 LIVE Blu-ray"
                + " - アイドルマスターSideM - 2018-04-25\n"
                + "(6) スター・ウォーズ/最後のジェダイ 4K UHD MovieNEX - マーク・ハミル - 2018-04-25\n"
                + "(7) A3! FIRST Blooming FESTIVAL【Blu-ray】 - - - 2018-04-25\n"
                + "(8) アイドリッシュセブン Blu-ray 3【特装限定版】 - アニメーション - 2018-04-24\n"
                + "(9) アウトレイジ 最終章 - ビートたけし - 2018-04-24\n"
                + "(10) アイドルマスター SideM 5(完全生産限定版) - アニメーション - 2018-04-25";;
        assertEquals(weeklyExpected, reply.getText());
    }

    @Test
    void testHandleDefaultMessage() {
        Event event = mock(Event.class);

        echoController.handleDefaultMessage(event);

        verify(event, atLeastOnce()).getSource();
        verify(event, atLeastOnce()).getTimestamp();
    }
}