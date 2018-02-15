package com.owary.faora.bootest.services;

import com.owary.faora.bootest.domain.Image;

import java.util.List;

public interface ImageCollector {

    List<Image> getFlickrImages(String apiKey, Integer perPage, String keyword);
    List<Image> getUnsplashImages(String apiKey, Integer perPage, String keyword);
    List<Image> collectImages(String apiKeyFlickr,String apiKeyUnsplash, Integer perPage, String keyword);
    String getURL(String apiKey, Integer perPage, String keyword,String vendor);


}
