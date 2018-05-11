package advprog.oriconbd.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import oriconbd.utilities.WebScrapper;

import java.io.IOException;

public class WebScrapperTest {
    private String expectedOut = "Top 10 Oricon BD as requested \n" +
            "(1) スター・ウォーズ/最後のジェダイ MovieNEX(初回版) - マーク・ハミル" +
            " - 2018-04-25 ウォルト・ディズニー・ジャパン\n" +
            "(2) ラブライブ!サンシャイン!! 2nd Season 5【特装限定版】 - アニメーション" +
            " - 2018-04-24 バンダイナムコアーツ\n" +
            "(3) SHOGO HAMADA ON THE ROAD 2015-2016“Journey of a Songwriter”" +
            " - 浜田省吾 - 2018-04-25 SME Records\n" +
            "(4) ラブライブ!サンシャイン!! Aqours 2nd LoveLive! HAPPY PARTY TRAIN TOUR Blu-ray Memorial BOX" +
            " - Aqours - 2018-04-25 ランティス\n" +
            "(5) THE IDOLM@STER SideM GREETING TOUR 2017 〜BEYOND THE DREAM〜 LIVE Blu-ray - アイドルマスタ" +
            "ーSideM - 2018-04-25 ランティス\n" +
            "(6) スター・ウォーズ/最後のジェダイ 4K UHD MovieNEX - マーク・ハミル - 2018-04-25 ウォルト・ディズニー・ジャパン\n" +
            "(7) A3! FIRST Blooming FESTIVAL【Blu-ray】 - - - 2018-04-25 ポニーキャニオン\n" +
            "(8) アイドリッシュセブン Blu-ray 3【特装限定版】 - アニメーション - 2018-04-24 バンダイナムコアーツ\n" +
            "(9) アウトレイジ 最終章 - ビートたけし - 2018-04-24 バンダイナムコアーツ\n" +
            "(10) アイドルマスター SideM 5(完全生産限定版) - アニメーション - 2018-04-25 アニプレックス";

    private String invalidOutput = "Invalid URL, Please check Your Input";
    private WebScrapper webScrapper;
    private String validURL = "https://www.oricon.co.jp/rank/bd/w/2018-05-07/";
    private String invalidURL = "https://www.oricon.co.jp/rank/bd/w/2018-05-08/";

    public WebScrapperTest() throws IOException {

    }

    @Before
    public void setUp() {
        webScrapper = new WebScrapper();
    }

    @Test
    public void testConstructorWebScrapperWork() {
        assertNotNull(webScrapper);
    }

    @Test
    public void testRankingValidURL() throws IOException {
        String validRankExp = webScrapper.webScrapperGetter(validURL);
        assertEquals(validRankExp,expectedOut);
    }

    @Test
    public void testRankingInvalidURL() throws IOException {
        String invalidRank = webScrapper.webScrapperGetter(invalidURL);
        assertEquals(invalidOutput,invalidRank);
    }
}
