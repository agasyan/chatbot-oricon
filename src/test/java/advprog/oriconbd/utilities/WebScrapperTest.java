package advprog.oriconbd.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import oriconbd.utilities.WebScrapper;

public class WebScrapperTest {

    private WebScrapper webScrapper;

    @Before
    public void setUp() {
        webScrapper = new WebScrapper();
    }

    @Test
    public void testConstructorWebScrapperWork() {
        assertNotNull(webScrapper);
    }

    @Test
    public void testRankingValidUrl() throws IOException {
        String validUrl = "https://www.oricon.co.jp/rank/bd/w/2018-05-07/";
        String validRankExp = webScrapper.webScrapperGetter(validUrl);
        String expectedOut = "Top 10 Oricon BD as requested \n"
                + "(1) スター・ウォーズ/最後のジェダイ MovieNEX(初回版) - マーク・ハミル"
                + " - 2018-04-25\n"
                + "(2) ラブライブ!サンシャイン!! 2nd Season 5【特装限定版】 - アニメーション"
                + " - 2018-04-24\n"
                + "(3) SHOGO HAMADA ON THE ROAD 2015-2016“Journey of a Songwriter”"
                + " - 浜田省吾 - 2018-04-25\n"
                + "(4) ラブライブ!サンシャイン!! Aqours 2nd LoveLive! HAPPY PARTY TRAIN"
                + " TOUR Blu-ray Memorial BOX"
                + " - Aqours - 2018-04-25\n"
                + "(5) THE IDOLM@STER SideM GREETING TOUR 2017 〜BEYOND THE DREAM〜"
                + " LIVE Blu-ray - アイドルマスタ"
                + "ーSideM - 2018-04-25\n"
                + "(6) スター・ウォーズ/最後のジェダイ 4K UHD MovieNEX - マーク・ハミル - 2018-04-25\n"
                + "(7) A3! FIRST Blooming FESTIVAL【Blu-ray】 - - - 2018-04-25\n"
                + "(8) アイドリッシュセブン Blu-ray 3【特装限定版】 - アニメーション - 2018-04-24\n"
                + "(9) アウトレイジ 最終章 - ビートたけし - 2018-04-24\n"
                + "(10) アイドルマスター SideM 5(完全生産限定版) - アニメーション - 2018-04-25";
        assertEquals(validRankExp, expectedOut);
    }

    @Test
    public void testRankingInvalidUrl() throws IOException {
        String invalidUrl = "https://www.oricon.co.jp/rank/bd/w/2018-05-08/";
        String invalidRank = webScrapper.webScrapperGetter(invalidUrl);
        String invalidOutput = "Invalid URL, Please check Your Input";
        assertEquals(invalidOutput, invalidRank);
    }
}
