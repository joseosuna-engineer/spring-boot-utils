package com.prottonne.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private HttpUtil httpUtil;

    @RequestMapping(path = "/get/{paramName}/{paramValue}",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String get(
            @PathVariable(value = "paramName") String paramName,
            @PathVariable(value = "paramValue") Integer paramValue) {

        return httpUtil.get(paramName, paramValue);
    }

}
