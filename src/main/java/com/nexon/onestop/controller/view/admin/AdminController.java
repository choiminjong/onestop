package com.nexon.onestop.controller.view.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/config")
    public String admin(){
        return "admin/config";
    }
}
