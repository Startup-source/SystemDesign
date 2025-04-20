package UrlShortner;

public class UrlShortenerApp {
    public static void main(String[] arg) {
        UrlShortenerService shortenerService = new UrlShortenerService();

        String shortUrl = shortenerService.shortenUrl("https://longsite/xyz", null, null);
        System.out.println("Short URL 1: "+ shortUrl);

        String shortUrl2 = shortenerService.shortenUrl("https://custom.com/page", "myalias", null);
        System.out.println("Short URL 2: "+ shortUrl2);

        String shortUrl3 = shortenerService.shortenUrl("https://temp.com/resources", null, 1);
        System.out.println("Short URL 3 (expires): "+shortUrl3);

        String originalUrl = shortenerService.getOriginalUrl("myalias");
        System.out.println("Redirected to: "+ originalUrl);

        System.out.println("Clicks on 'myalias': "+ shortenerService.getClickCount("myalias"));
    }
}
