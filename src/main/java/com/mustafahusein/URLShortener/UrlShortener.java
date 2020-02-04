package com.mustafahusein.URLShortener;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class UrlShortener {

    private static final String PREFIX = "localhost:8080/s/";

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> shortenURL(@RequestParam("longUrl") String longUrl) throws MalformedURLException {
        String key = ShortUrlDatabase.insert(longUrl);
        return new ResponseEntity<>(PREFIX + key, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/s/{key}", method = RequestMethod.GET)
    public RedirectView redirectToLongUrl(@PathVariable("key") String key) {
        URL longUrl = ShortUrlDatabase.get(key);
        if(longUrl == null) throw new ResourceNotFoundException();
        return new RedirectView(longUrl.toString());
    }
}
