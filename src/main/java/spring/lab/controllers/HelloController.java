package spring.lab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/about-me")
    public String aboutMe() {
        return "about-me";
    }
}
