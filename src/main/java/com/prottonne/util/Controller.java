package com.prottonne.util;

import javax.servlet.http.HttpServletResponse;
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

    @GetMapping(path = "/download",
            produces = MediaType.IMAGE_PNG_VALUE
    )
    public void download(HttpServletResponse response) {

        httpUtil.download(response);

    }

}
