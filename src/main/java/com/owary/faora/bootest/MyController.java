package com.owary.faora.bootest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

        @ResponseBody
        @RequestMapping("/")
        public String index(){
                return "I miss you now, Ulkar";
        }

}
