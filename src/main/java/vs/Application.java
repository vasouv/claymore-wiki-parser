
package vs;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Application {

    final static String CLAYMORE_WIKI_URL = "https://claymore.fandom.com/wiki/Claymore";

    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect(CLAYMORE_WIKI_URL).get();

        WikiParser wikiParser = new WikiParser();

        // get the wiki tables
        Elements wikitables = document.getElementsByClass("wikitable");

        // first wiki table - clarice's time
        Element clariceTime = wikitables.first();

        Elements tableRows = clariceTime.getElementsByTag("tr");

        for (Element row : tableRows) {

            ClaymoreInfo claymoreInfo = wikiParser.getClaymoreInformationFromRow(row);
            if (claymoreInfo != null) {
                System.out.println(claymoreInfo.name);
            }

        }

    }

}
