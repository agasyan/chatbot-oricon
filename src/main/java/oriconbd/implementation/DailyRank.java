package oriconbd.implementation;

import com.linecorp.bot.model.message.TextMessage;
import java.io.IOException;
import oriconbd.utilities.WebScrapper;



public class DailyRank {
    public DailyRank() {

    }
    /*
    public static void main(String[]args) throws IOException{
        DailyRank dailyRank = new DailyRank();
        System.out.println(dailyRank.run("2018-05-03"));
    }
    */

    private WebScrapper webScrapper = new WebScrapper();

    private static final String DAILY_URL_FORMAT = "https://www.oricon.co.jp/rank/bd/d/";

    public TextMessage run(String date) throws IOException {
        String webOutput = webScrapper.webScrapperGetter(DAILY_URL_FORMAT + date + "/");
        if (webOutput.contains("Invalid URL, Please check Your Input")) {
            webOutput = "Invalid URL/Date. Date should be "
                    + "in this format (YYYY-MM-DD) and  should be "
                    + "on 8 days before the date (today - 2 days)"
                    + "example now on 11 May so the available date"
                    + "on 2 May - 9 May";
        }
        return new TextMessage(webOutput);
    }
}
