package advprog.oriconbd.implementation;

import com.linecorp.bot.model.message.TextMessage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import oriconbd.implementation.WeeklyRank;

import java.io.IOException;

public class WeeklyRankTest {
    private WeeklyRank weeklyRank;

    @Before
    public void setUp() {
        weeklyRank = new WeeklyRank();
    }

    @Test
    public void testConstructorWeeklyRankWork(){
        assertNotNull(weeklyRank);
    }

    @Test
    public void testWeeklyRankValidDate() throws IOException {
        String validDate = "2018-05-07";
        TextMessage validUrlOutput = weeklyRank.run(validDate);
        String expectedOutput = "Top 10 Oricon BD as requested \n"
                + "(1) スター・ウォーズ/最後のジェダイ MovieNEX(初回版) - マーク・ハミル"
                +" - 2018-04-25\n"
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
                + "(10) アイドルマスター SideM 5(完全生産限定版) - アニメーション - 2018-04-25";
        assertEquals(validUrlOutput.getText(),expectedOutput);
    }

    @Test
    public void weeklyInvalidDate() throws IOException {
        String invalidDate = "2018-05-08";
        TextMessage invalidDateOutput = weeklyRank.run(invalidDate) ;
        String invalidWeeklyOutput = "Invalid URL/Date. Date should be "
                + "in this format (YYYY-MM-DD) and  should be "
                + "on Monday.";
        assertEquals(invalidDateOutput.getText(),invalidWeeklyOutput);
    }
}
