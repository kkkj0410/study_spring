package com.cos.security1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"","/"})
    public String index() {

        //머스태치 기본폴더 src/main/resources/
        // 기본 경로 : src/main/java/resources/templates/index.mustache
        // WebMvcConfig.java 적용 후 -> ~~~/index.html
        return "index";
    }

}
