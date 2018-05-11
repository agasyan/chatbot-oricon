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
        String dateThirdMay = "2018-05-03";
        TextMessage validDateOutput = dailyRank.run(dateThirdMay);
        String dailyThirdMay = "Top 10 Oricon BD as requested \n"
                + "(1) スター・ウォーズ/最後のジェダイ MovieNEX(初回版) - マーク・ハミル - 2018-04-25\n"
                + "(2) ヴァイオレット・エヴァーガーデン�A - アニメーション - 2018-05-02\n"
                + "(3) オリエント急行殺人事件 2枚組ブルーレイ&DVD - ケネス・ブラナー - 2018-05-02\n"
                + "(4) 斉木楠雄のΨ難 豪華版ブルーレイ&DVDセット【初回生産限定】 - 山崎賢人 - 2018-05-02\n"
                + "(5) マイティ・ソー バトルロイヤル MovieNEX - クリス・ヘムズワース - 2018-03-07\n"
                + "(6) ラブライブ!サンシャイン!! 2nd Season 5【特装限定版】 - アニメーション - 2018-04-24\n"
                + "(7) アウトレイジ 最終章 - ビートたけし - 2018-04-24\n"
                + "(8) SHOGO HAMADA ON THE ROAD 2015-2016“Journey of a Songwriter”"
                + " - 浜田省吾 - 2018-04-25\n"
                + "(9) キングスマン:ゴールデン・サークル 2枚組ブルーレイ&DVD - タロン・エガートン"
                + " - 2018-04-06\n"
                + "(10) ミックス。 豪華版Blu-ray - 新垣結衣,瑛太 - 2018-05-02";
        assertEquals(validDateOutput.getText(), dailyThirdMay);
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
