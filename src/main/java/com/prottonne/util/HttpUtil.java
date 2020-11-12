package com.prottonne.util;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class HttpUtil {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${http.util.url}")
    private String httpUtilUrl;

    @Value("${http.util.photo}")
    private String httpUtilPhoto;

    private static final String OK = "Ok";
    private static final String NOT_OK = "Not Ok";

    protected String get() {

        final String paramName = "postId";
        final Integer paramValue = 1;

        HttpURLConnection connection = null;

        try {

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

    protected void download(HttpServletResponse response) {

        final String filePath = "600/92c952";

        HttpURLConnection connection = null;

        try {

            final String fullUrl = httpUtilPhoto + "/" + filePath;
            logger.info("check fullUrl {}", fullUrl);

            URL url = new URL(fullUrl);
            logger.info("check path {}", url.getPath());

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(RequestMethod.GET.name());
            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {

                byte[] image = IOUtils.toByteArray(connection.getInputStream());

                if (image.length > 0) {

                    try ( OutputStream out = response.getOutputStream()) {

                        response.setContentLength(image.length);
                        response.setContentType(MediaType.IMAGE_PNG_VALUE);
                        response.setHeader("Content-disposition", "attachment; filename=image.png");
                        response.setStatus(HttpServletResponse.SC_OK);

                        out.write(image);

                    }

                    logger.info(OK);

                }

            }

        } catch (Exception ex) {
            logger.error(NOT_OK, ex);
        } finally {
            if (null != connection) {
                connection.disconnect();
            }
        }

        logger.info(NOT_OK);

    }

}
