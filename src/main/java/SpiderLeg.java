import java.util.LinkedList;

public class SpiderLeg {
    private LinkedList<String> urls;

    SpiderLeg(){
        urls = new LinkedList<String>();
    }

    public LinkedList<String> getUrls() {
        return urls;
    }
}
