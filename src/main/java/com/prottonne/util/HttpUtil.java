package com.prottonne.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class HttpUtil {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${http.util.url}")
    private String httpUtilUrl;

    private static final String OK = "Ok";
    private static final String NOT_OK = "Not Ok";

    protected String get(String paramName, Integer paramValue) {

        try {
            if (0 == paramValue) {
                logger.info("Not Ok, paramValue={}", paramValue);
                return NOT_OK;
            }

            final String str = httpUtilUrl + "?" + paramName + "=" + paramValue;
            logger.info("check fullUrl {}", str);

            String urlWhiteListed = "https://jsonplaceholder.typicode.com/";

            if (!str.startsWith(urlWhiteListed)) {
                throw new IOException();
            }

            URL url2 = new URL(str);
            HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();

            conn2.setRequestMethod(RequestMethod.GET.name());
            conn2.connect();

            if (HttpURLConnection.HTTP_OK == conn2.getResponseCode()) {

                logger.info(OK);
                return OK;

            } else {

                logger.info(NOT_OK);
                return NOT_OK;
            }
        } catch (MalformedURLException | ProtocolException ex) {
            logger.error(NOT_OK, ex);
        } catch (IOException ex) {
            logger.error(NOT_OK, ex);
        }

        logger.info(NOT_OK);
        return NOT_OK;

    }

}
