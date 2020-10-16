package com.swu.ace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AceController {

    @GetMapping(value = "/ace")
    @ResponseBody
    public String ace() {
        return "hello ace";
    }

}
