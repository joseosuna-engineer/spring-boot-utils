package com.prottonne.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private HttpUtil httpUtil;

    @GetMapping(path = "/get/{paramName}/{paramValue}",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String get(
            @PathVariable(value = "paramName") String paramName,
            @PathVariable(value = "paramValue") Integer paramValue) {

        return httpUtil.get(paramName, paramValue);
    }

}
