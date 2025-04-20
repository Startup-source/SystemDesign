package UrlShortner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class UrlShortenerService {
    private static final String BASE_URL = "http://short.ly/";
    private AtomicLong counter = new AtomicLong(100000);
    private Map<String, UrlMapping> codeToUrl = new HashMap<>();
    private Map<String, UrlMapping> longUrlToCode = new HashMap<>();

    public String shortenUrl(String longUrl, String customAlias, Integer expiryInMinutes) {

        if (customAlias != null && codeToUrl.containsKey(customAlias)) {
            throw new IllegalArgumentException("Custom alias already in use!");
        }

        if(customAlias == null && longUrlToCode.containsKey(longUrl)) {
            return BASE_URL + longUrlToCode.get(longUrl).getShortCode();
        }

        long id = counter.incrementAndGet();
        String shortCode = customAlias != null ? customAlias : Base62Encoder.encode(id);
        long expiresAt = expiryInMinutes != null ? System.currentTimeMillis() + expiryInMinutes *60 * 1000 : 0;
        UrlMapping mapping = new UrlMapping(id, longUrl, shortCode, System.currentTimeMillis(), expiresAt);
        codeToUrl.put(shortCode, mapping);
        longUrlToCode.put(longUrl, mapping);

        return BASE_URL+shortCode;
    }

    public String getOriginalUrl(String shortCode) {
        UrlMapping mapping = codeToUrl.get(shortCode);
        if (mapping == null) return null;
        if (mapping.isExpired()) {
            codeToUrl.remove(shortCode);
            return null;
        }
        mapping.incrementClick();
        return mapping.getLongUrl();
    }

    public int getClickCount(String shortCode) {
        UrlMapping mapping = codeToUrl.get(shortCode);
        return mapping != null ? mapping.getClickCount() : 0;
    }
}
