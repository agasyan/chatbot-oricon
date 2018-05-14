package oriconbd.implementation;

import com.linecorp.bot.model.message.TextMessage;

import java.io.IOException;

import oriconbd.utilities.WebScrapper;


public class WeeklyRank implements RankCommand{
    /**
     * Constructor WeeklyRank.
     */
    public WeeklyRank() {

    }

    /**
     * WebScrapper untuk mengambil data dari website oricon.
     */
    private WebScrapper webScrapper = new WebScrapper();
    /*
    public static void main(String[]args) throws IOException {
        WeeklyRank weeklyRank = new WeeklyRank();
        System.out.println(weeklyRank.run("2018-05-07"));
    }
    */

    /**
     * Weekly URL Format dalam mengambil data di website oricon.
     */
    private static final String WEEKLY_URL_FORMAT = "https://www.oricon.co.jp/rank/bd/w/";

    /**
     * run untuk mengambil ranking pada minggu tersebut.
     * @param date tanggal yang ingin dicari
     * @return ranking pada minggu tersebut
     * @throws IOException ketika membaca input.
     */
    public TextMessage run(String date) throws IOException {
        String webOutput = webScrapper.webScrapperGetter(WEEKLY_URL_FORMAT + date + "/");
        if (webOutput.contains("Invalid URL, Please check Your Input")) {
            webOutput = "Invalid URL/Date. Date should be "
                    + "in this format (YYYY-MM-DD) and  should be "
                    + "on Monday.";
        }
        return new TextMessage(webOutput);
    }
}
