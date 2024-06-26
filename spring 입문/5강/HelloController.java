package hello.hellospring.controller;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
    
        model.addAttribute("data", "spring!!");
        //key : "data", value : "spring!!"
        
        return "hello";
        //return이 있는 곳으로 이동(templates->("hello").html
    }
}
