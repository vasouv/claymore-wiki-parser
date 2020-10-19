package vs;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WikiParser {

    /**
     * <h1>Creates ClaymoreInfo from wikitable row.</h1>
     * <p>
     * Extracts the character's information, picture url, name and symbol url. If
     * the name is unknown, it's disregarded.
     * </p>
     * <p>
     * If the row contains table headers, it's disregarded as well.
     * </p>
     * <p>
     * The symbol url can be unknown.
     * </p>
     * 
     * @param row table row element
     * @return ClaymoreInfo with picture url, name and symbol url.
     */
    public ClaymoreInfo getClaymoreInformationFromRow(Element row) {
        Elements tds = row.getElementsByTag("td");

        // bypassing the header row which has no td
        if (tds.isEmpty()) {
            return null;
        }

        Elements pictureElement = tds.get(0).getElementsByTag("a");
        Elements nameElement = tds.get(1).getElementsByTag("a");
        Elements symbolElement = tds.get(2).getElementsByTag("a");

        String name = nameElement.isEmpty() ? "unknown" : nameElement.first().text();
        String href = pictureElement.isEmpty() ? "unknown" : pictureElement.first().attr("href");
        String symbol = symbolElement.isEmpty() ? "unknown" : symbolElement.first().attr("href");

        // disregarding the unknown characters which have no info
        if (name.equals("unknown")) {
            return null;
        }

        return new ClaymoreInfo(href, name, symbol);
    }

}
