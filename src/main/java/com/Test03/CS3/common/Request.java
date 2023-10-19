package com.Test03.CS3.common;

import java.io.Serializable;

public class Request implements Serializable {
    private String type;
    private String[] parameters;

    public Request(String type, String[] parameters) {
        this.type = type;
        this.parameters = parameters;
    }

    public String getType() {
        return type;
    }

    public String[] getParameters() {
        return parameters;
    }
}