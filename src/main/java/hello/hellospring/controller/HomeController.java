package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // "/" Mapping 없을 시 index.html로
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
