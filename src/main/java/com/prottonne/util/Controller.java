package com.prottonne.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private HttpUtil httpUtil;

    @GetMapping(path = "/get",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String get() {

        return httpUtil.get();
    }

}
