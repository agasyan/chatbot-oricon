package oriconbd.utilities;

import java.io.IOException;
import java.util.stream.Collectors;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class WebScrapper {

    public static void main(String[]args) throws IOException {
        WebScrapper webScrapper = new WebScrapper();
        System.out.println(webScrapper.webScrapperGetter("https://www.oricon.co.jp/rank/bd/w/2018-05-07/"));
    }


    public WebScrapper() {

    }

    public String webScrapperGetter(String url) throws IOException {
        try {
            Document document = Jsoup.connect(url).get();
            Elements bdMovie = document.select("section.box-rank-entry");
            return  "Top 10 Oricon BD as requested \n"
                    + bdMovie.stream().map(this::bluRayOutputManager)
                    .collect(Collectors.joining("\n"));
        } catch (HttpStatusException e) {
            return "Invalid URL, Please check Your Input";
        }
    }

    private String bluRayOutputManager(Element rawBdRank) {
        String rankingBd = rawBdRank.select("p.num").text();
        Element informationBd = rawBdRank.selectFirst("div.wrap-text");
        String movieTitle = informationBd.select("h2.title").text();
        String movieArtist = informationBd.select("p.name").text();
        String movieReleaseDate = dateConvert(informationBd.selectFirst("li").text());
        return String.format("(%s) %s - %s - %s", rankingBd,
            movieTitle,movieArtist,movieReleaseDate);
    }

    private String dateConvert(String rawDate) {
        return  rawDate.replace("発売日： ","")
                .replace("年", "-")
                .replace("月", "-")
                .replace("日", "");
    }
}


