import java.util.HashMap;

public class Codec {
    private HashMap<String, String> longToShort;
    private HashMap<String, String> shortToLong;
    private static final String BASE_HOST = "http://tinyurl.com/";
    private int counter;

    public Codec() {
        longToShort = new HashMap<>();
        shortToLong = new HashMap<>();
        counter = 0;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return BASE_HOST + longToShort.get(longUrl);
        }

        String shortKey = String.valueOf(counter++);
        longToShort.put(longUrl, shortKey);
        shortToLong.put(shortKey, longUrl);

        return BASE_HOST + shortKey;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String shortKey = shortUrl.replace(BASE_HOST, "");
        return shortToLong.getOrDefault(shortKey, "");
    }
}
