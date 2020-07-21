package com.itrigger.ace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AceController {

    private static final Logger logger = LoggerFactory.getLogger(AceController.class);

    @RequestMapping(value = "/ace", method = RequestMethod.GET)
    @ResponseBody
    public String ace() {
        logger.info("method ace");
        return "hello ace";
    }

}
