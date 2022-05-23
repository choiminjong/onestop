package com.nexon.onestop.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value={"/",""})
    public String home() {
        return "home";
    }

    @GetMapping(value="/mypage")
    public String mypage(){
        return "mypage";
    }

}