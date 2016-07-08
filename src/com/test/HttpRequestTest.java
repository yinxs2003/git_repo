package com.test;

import com.rest.HttpRequest;
import org.apache.log4j.Logger;

public class HttpRequestTest {
    private static Logger logger = Logger.getLogger(HttpRequest.class);

    public static void main(String[] args){
        String url = "http://172.27.12.68:8091/o2oportal/pubmng/query";
        String param = "ownerName=super&shopName=hantest";
        String returnString = HttpRequest.sendGet(url,param);
        logger.info(returnString);

    }
}
