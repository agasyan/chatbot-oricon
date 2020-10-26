package advprog.oriconbd.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.linecorp.bot.model.message.TextMessage;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import oriconbd.implementation.DailyRank;

public class DailyRankTest {
    private DailyRank dailyRank;

    @Before
    public void setUp() {
        dailyRank = new DailyRank();
    }

    @Test
    public void testConstructorDailyRankWork() {
        assertNotNull(dailyRank);
    }

    @Test
    public void testDailyOutValidDate() throws IOException {
        String dateTwelveMay = "2018-05-12";
        TextMessage validDateOutput = dailyRank.run(dateTwelveMay);
        String dailyTwelveMay = "Top 10 Oricon BD as requested \n"
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
        assertEquals(dailyTwelveMay,validDateOutput.getText());
    }

    @Test
    public void testDailyOutInvalidDate() throws IOException {
        String invalidDate = "2018-04-30";
        TextMessage invalidDateOutput = dailyRank.run(invalidDate);
        String invalidExpected = "Invalid URL/Date. Date should be "
                + "in this format (YYYY-MM-DD) and  should be "
                + "on 8 days before the date (today - 2 days)"
                + "example now on 11 May so the available date"
                + "on 2 May - 9 May";
        assertEquals(invalidDateOutput.getText(), invalidExpected);
    }
}
