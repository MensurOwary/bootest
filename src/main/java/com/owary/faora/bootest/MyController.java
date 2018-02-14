package com.owary.faora.bootest;


//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

        @ResponseBody
        @RequestMapping("/")
        public String index(){
                return "Batman";
        }

        @RequestMapping(value="/search", method = RequestMethod.GET)
        public ModelAndView search(){
                ModelAndView mw = new ModelAndView("index");
                return mw;
        }

        @RequestMapping(value = "/search", method = RequestMethod.POST)
        public ModelAndView display(@RequestParam("keyword") String keyword){
                ModelAndView mw = new ModelAndView("index");
                RestTemplate rt = new RestTemplate();

                String URL = "https://api.unsplash.com/search/photos?query="+keyword+"&per_page=100&client_id=56d2603e6400d3cba0ed44aa599c97adab60313951ddc8af8c5e131d4cc2f2f4";
                ResponseEntity<String> obj = rt.getForEntity(URL, String.class);

                JSONObject joo = new JSONObject(obj.getBody());
                JSONArray ja = joo.getJSONArray("results");
                List<Image> list = new ArrayList<>();

                for(int i=0;i<ja.length();i++){
                        JSONObject temp = ja.getJSONObject(i);
                        JSONObject jaa = temp.getJSONObject("urls");

                        String raw = jaa.getString("raw");
                        String full = jaa.getString("full");
                        String regular = jaa.getString("regular");
                        String small= jaa.getString("small");

                        Image image = new Image(raw,full,regular,small);
                        list.add(image);
                }
                mw.addObject("list", list);
                mw.addObject("condition", true);
                return mw;
        }

}
