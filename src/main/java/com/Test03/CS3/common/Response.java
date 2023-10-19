package com.Test03.CS3.common;

import java.io.Serializable;

public class Response implements Serializable {
    private String result;
    private String[] data;

    public Response(String result, String[] data) {
        this.result = result;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public String[] getData() {
        return data;
    }
}