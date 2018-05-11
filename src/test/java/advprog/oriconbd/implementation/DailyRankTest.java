package advprog.oriconbd.implementation;

import com.linecorp.bot.model.message.TextMessage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import oriconbd.implementation.DailyRank;
import oriconbd.implementation.WeeklyRank;


public class DailyRankTest {
    private DailyRank dailyRank;

    @Before


    @Test
    public void testDailyOutValidDate(){
        String dailyNineMay = "TOP 10 Oricon BD as requested\n+"
                + "(1) 劇場版「Fate/stay night[Heaven’s Feel]�T.presage flower」"
                + "(完全生産限定版) - アニメーション - 2018-05-09\n"
                + "(2) ナラタージュ Blu-ray 豪華版 - 松本潤 - 2018-05-09\n"
                + "(3) 仮面ライダー平成ジェネレーションズFINAL ビルド&エグゼイドwith"
                + "レジェンドライダー コレクターズパック - 犬飼貴丈 - 2018-05-09\n"
                + "(4) CNBLUE 2017 ARENA LIVE TOUR 〜Starting Over〜 "
                + "@YOKOHAMA ARENA - CNBLUE - 2018-05-09\n"
                + "(5) Little Glee Monster Arena Tour 2018 -juice !!!!!- "
                + "at YOKOHAMA ARENA - Little Glee Monster - 2018-05-09\n"
                + "(6) 劇場版「Fate/stay night[Heaven’s Feel]�T.presage flower」"
                + "(通常版) - アニメーション - 2018-05-09\n"
                + "(7) カードキャプターさくら クリアカード編 Vol.1＜初回仕様版＞ "
                + "- アニメーション - 2018-05-09\n"
                + "(8) スター・ウォーズ/最後のジェダイ MovieNEX(初回版) - "
                + "マーク・ハミル - 2018-04-25\n"
                + "(9) 超英雄祭 KAMEN RIDER×SUPER SENTAI LIVE&SHOW 2018 "
                + "- - - 2018-05-09\n"
                + "(10) ワイルド・スピード ICE BREAK - ヴィン・ディーゼル - 2018-05-09";
    }

    @Test
    public void testInputDate(){
        //TODO IMPLEMENT THIS
    }
}
