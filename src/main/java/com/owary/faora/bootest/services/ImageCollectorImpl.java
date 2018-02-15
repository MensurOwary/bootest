package com.owary.faora.bootest.services;

import com.owary.faora.bootest.domain.Image;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ImageCollectorImpl implements ImageCollector {

            @Override
            public List<Image> getFlickrImages(String apiKey, Integer perPage, String keyword) {
                RestTemplate rt = new RestTemplate();

                HttpHeaders headers = new HttpHeaders();
                headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:58.0) Gecko/20100101 Firefox/58.0");
                HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

                String URL = getURL(apiKey,perPage,keyword,"flickr");

                ResponseEntity<String> obj = rt.exchange(URL, HttpMethod.GET, entity, String.class);

                String jsonp = obj.getBody();
                String convJSONP = jsonp.substring(jsonp.indexOf("(")+1,jsonp.lastIndexOf(")"));

                JSONObject joo = new JSONObject(convJSONP);
                JSONObject jo = joo.getJSONObject("photos");
                JSONArray ja = jo.getJSONArray("photo");
                List<Image> list = new ArrayList<>();

                for(int i=0;i<ja.length();i++){
                    JSONObject temp = ja.getJSONObject(i);

                    String farmId = String.valueOf(temp.getInt("farm"));
                    String serverId = temp.getString("server");
                    String id = temp.getString("id");
                    String secret = temp.getString("secret");

                    String regular = imageLink(farmId,serverId,id,secret);
                    String raw = regular.replaceAll(".jpg", "_b.jpg");

                    Image image = new Image(raw, null,regular,null);
                    list.add(image);
                }
                return list;
            }

            @Override
            public List<Image> getUnsplashImages(String apiKey, Integer perPage, String keyword) {
                RestTemplate rt = new RestTemplate();

                String URL = getURL(apiKey,perPage,keyword,"unsplash");
                ResponseEntity<String> obj = rt.getForEntity(URL, String.class);

                JSONObject joo = new JSONObject(obj.getBody());
                JSONArray ja = joo.getJSONArray("results");
                List<Image> list = new ArrayList<>();

                for(int i=0;i<ja.length();i++){
                    JSONObject temp = ja.getJSONObject(i);
                    JSONObject jaa = temp.getJSONObject("urls");

                    String raw = jaa.getString("raw");
                    String regular = jaa.getString("regular");

                    Image image = new Image(raw,null,regular,null);
                    list.add(image);
                }
                return list;
            }

            @Override
            public List<Image> collectImages(String apiKeyFlickr,String apiKeyUnsplash, Integer perPage, String keyword) {
                List<Image> flickrs = getFlickrImages(apiKeyFlickr,perPage,keyword);
                List<Image> unsplash = getUnsplashImages(apiKeyUnsplash,perPage,keyword);
                flickrs.addAll(unsplash);
                return flickrs;
            }

            @Override
            public String getURL(String apiKey, Integer perPage, String keyword, String vendor) {
                String URL = null;
                if(vendor.equals("flickr")){
                    URL = "https://api.flickr.com/services/rest?method=flickr.photos.search&api_key="+apiKey+"&per_page="+perPage+"&format=json&safe_search=1&sort=relevance&text="+keyword;
                }else if(vendor.equals(("unsplash"))){
                    URL = "https://api.unsplash.com/search/photos?query="+keyword+"&per_page="+perPage+"&client_id="+apiKey;
                }
                return URL;
            }

            public static String imageLink(String farmId,String serverId,String id,String secret){
                String URL = "https://farm"+farmId+".staticflickr.com/"+serverId+"/"+id+"_"+secret+".jpg";
                return URL;
            }
}
