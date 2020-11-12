package com.prottonne.util;

import java.net.HttpURLConnection;
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

        HttpURLConnection connection = null;

        try {
            if (0 == paramValue) {
                logger.info("Not Ok, paramValue={}", paramValue);
                return NOT_OK;
            }

            final String fullUrl = httpUtilUrl + "?" + paramName + "=" + paramValue;
            logger.info("check fullUrl {}", fullUrl);

            URL url = new URL(fullUrl);
            logger.info("check path {}", url.getPath());

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(RequestMethod.GET.name());
            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {

                logger.info(OK);
                return OK;

            } else {

                logger.info(NOT_OK);
                return NOT_OK;
            }
        } catch (Exception ex) {
            logger.error(NOT_OK, ex);
        } finally {
            if (null != connection) {
                connection.disconnect();
            }
        }

        logger.info(NOT_OK);
        return NOT_OK;

    }

}
