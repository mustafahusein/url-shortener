package com.mustafahusein.URLShortener;

public class Base62 {
    private static final String ALPHANUMERALS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private Base62() {
    }

    public static String toBase62(long base10) {
        String base62 = "";

        while (base10 > 0) {
            base62 = ALPHANUMERALS.charAt((int)(base10 % 62)) + base62;
            base10 /= 62;
        }

        return base62;
    }
}
