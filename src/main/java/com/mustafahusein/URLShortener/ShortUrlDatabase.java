package com.mustafahusein.URLShortener;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ShortUrlDatabase {
    private static Map<String, URL> database;
    private static AtomicLong id;

    static {
        database = new ConcurrentHashMap<>();
        id = new AtomicLong(0);
    }

    private ShortUrlDatabase() {
    }

    public static String insert(String longUrl) throws MalformedURLException {
        URL url = new URL(longUrl);
        String key = Base62.toBase62(id.incrementAndGet());
        database.put(key, url);
        return key;
    }

    public static URL get(String key) {
        return database.get(key);
    }
}
