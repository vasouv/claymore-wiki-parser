package vs;

public class ClaymoreInfo {
    public final String pictureUrl;
    public final String name;
    public final String symbolUrl;

    public ClaymoreInfo(String pictureUrl, String name, String symbolUrl) {
        this.pictureUrl = pictureUrl;
        this.name = name;
        this.symbolUrl = symbolUrl;
    }

    @Override
    public String toString() {
        return "ClaymoreInfo [name=" + name + ", pictureUrl=" + pictureUrl + ", symbolUrl=" + symbolUrl + "]";
    }

}
