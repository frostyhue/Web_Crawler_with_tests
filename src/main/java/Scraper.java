public class Scraper {
    private String url;
    private Spider spider;

    Scraper(String url, String word){
        this.spider = new Spider();
        this.url = spider.search(url, word);
    }

    public String getUrl() {
        return url;
    }
}
