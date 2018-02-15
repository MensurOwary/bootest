package com.owary.faora.bootest.controller;

import com.owary.faora.bootest.domain.Image;
import com.owary.faora.bootest.services.ImageCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ImageCollector imageCollector;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView search(){
        ModelAndView mw = new ModelAndView("main");
        return mw;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView display(@RequestParam("keyword") String keyword, @RequestParam("perPage") String perPage){
        ModelAndView mw = new ModelAndView("main");

        String unsplash  = "56d2603e6400d3cba0ed44aa599c97adab60313951ddc8af8c5e131d4cc2f2f4";
        String flickr = "e963789d72a5c47d9f646519a4eebc84";

        Integer count = null;

        try {
            count = Integer.parseInt(perPage);
            count = count/2+10;
        }catch(NumberFormatException e){
            count = 10;
        }

        List<Image> list = imageCollector.collectImages(flickr, unsplash,count,keyword);

        mw.addObject("list", list);
        mw.addObject("condition", true);
        return mw;
    }


}
