package com.swu.ace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AceController {

    private static final Logger logger = LoggerFactory.getLogger(AceController.class);

    @GetMapping(value = "/ace")
    @ResponseBody
    public String ace() {
        logger.info("method ace");
        return "hello ace";
    }

}
