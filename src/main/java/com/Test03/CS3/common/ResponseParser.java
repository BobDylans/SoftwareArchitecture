package com.Test03.CS3.common;

import com.Test03.CS3.common.Response;

public class ResponseParser {
    public static void parse(Response response) {
        System.out.println("结果：" + response.getResult());
        System.out.println("数据：");
        for (String data : response.getData()) {
            System.out.println(data);
        }
    }
}