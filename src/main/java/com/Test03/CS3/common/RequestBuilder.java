package com.Test03.CS3.common;

import com.Test03.CS3.common.Request;

public class RequestBuilder {
    public static Request build(String userInput) {
        String[] parts = userInput.split(",");
        String type = parts[0].trim();
        String[] parameters = new String[parts.length - 1];
        for (int i = 1; i < parts.length; i++) {
            parameters[i - 1] = parts[i].trim();
        }
        return new Request(type, parameters);
    }
}