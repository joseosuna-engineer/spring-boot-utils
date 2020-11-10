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

    protected String get(String paramName, Integer paramValue) {

        HttpURLConnection connection = null;

        try {
            if (0 == paramValue) {
                logger.info("Not Ok, paramValue={}", paramValue);
                return "Not Ok";
            }

            final String fullUrl = httpUtilUrl + "?" + paramName + "=" + paramValue;
            logger.info("check fullUrl {}", fullUrl);

            URL url = new URL(fullUrl);
            logger.info("check path {}", url.getPath());

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(RequestMethod.GET.name());
            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {

                logger.info("Ok");
                return "Ok";

            } else {

                logger.info("Not Ok");
                return "Not Ok";
            }
        } catch (MalformedURLException ex) {
            logger.error("Not Ok", ex);
        } catch (ProtocolException ex) {
            logger.error("Not Ok", ex);
        } catch (IOException ex) {
            logger.error("Not Ok", ex);
        } finally {
            if (null != connection) {
                connection.disconnect();
            }
        }

        logger.info("Not Ok");
        return "Not Ok";

    }

}
