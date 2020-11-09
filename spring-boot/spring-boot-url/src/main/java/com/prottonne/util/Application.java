package com.prottonne.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@SpringBootApplication
public class Application {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${my.url}")
    private String myUrl;

    private final String parmName = "postId";
    private final Integer parmValue = 1;

    @RequestMapping("/")
    String getMethod() throws MalformedURLException, ProtocolException, IOException {
        
        final String fullUrl = myUrl + "?" + parmName + "=" + parmValue;
        logger.info("check fullUrl {}", fullUrl);
        
        URL url = new URL(fullUrl);
        logger.info("check path {}", url.getPath());

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(RequestMethod.GET.name());
        connection.connect();

        if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {

            logger.info("Ok");
            return "Ok";

        } else {
            
            logger.info("Not Ok");
            return "Not Ok";
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
