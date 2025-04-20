package UrlShortner;

public class UrlMapping {
    private long id;
    private String longUrl;
    private String shortCode;
    private long createdAt;
    private long expiresAt;
    private int clickCount;

    public UrlMapping(long id, String longUrl, String shortCode, long createdAt, long expiresAt) {
        this.id = id;
        this.longUrl = longUrl;
        this.shortCode = shortCode;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.clickCount = 0;
    }

    public boolean isExpired() {
        return expiresAt > 0 && System.currentTimeMillis() > expiresAt;
    }

    public void incrementClick() {
        this.clickCount++;
    }

    public int getClickCount() {
        return this.clickCount;
    }

    public long getId() {
        return id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public String getShortCode() {
        return shortCode;
    }
}
