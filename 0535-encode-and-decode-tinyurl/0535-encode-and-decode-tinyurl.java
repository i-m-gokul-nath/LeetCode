import java.util.HashMap;

public class Codec {
    private HashMap<String, String> urls;
    private static final String BASE_HOST = "http://tinyurl.com/";
    private int counter;

    public Codec() {
        urls = new HashMap<>();
        counter = 0;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortKey = BASE_HOST + String.valueOf(counter++);
        urls.put(shortKey, longUrl);
        return shortKey;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urls.getOrDefault(shortUrl, "");
    }
}
