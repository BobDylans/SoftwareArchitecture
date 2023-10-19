package com.Test03.CS3.server;

import com.Test03.CS3.common.Request;
import com.Test03.CS3.common.Response;


import java.util.ArrayList;
import java.util.List;

public class AddressBookService {
    private static List<String> contactList = new ArrayList<>();

    public static Response processRequest(Request request) {
        String type = request.getType();
        String[] parameters = request.getParameters();

        switch (type) {
            case "ADD":
                if (parameters.length == 1) {
                    String contact = parameters[0];
                    if (!contactList.contains(contact)) {
                        contactList.add(contact);
                        return new Response("SUCCESS", null);
                    } else {
                        return new Response("ERROR", new String[]{"联系人已存在"});
                    }
                } else {
                    return new Response("ERROR", new String[]{"参数错误"});
                }

            case "UPDATE":
                if (parameters.length == 2) {
                    String oldContact = parameters[0];
                    String newContact = parameters[1];
                    if (contactList.contains(oldContact)) {
                        int index = contactList.indexOf(oldContact);
                        contactList.set(index, newContact);
                        return new Response("SUCCESS", null);
                    } else {
                        return new Response("ERROR", new String[]{"联系人不存在"});
                    }
                } else {
                    return new Response("ERROR", new String[]{"参数错误"});
                }

            case "DELETE":
                if (parameters.length == 1) {
                    String contact = parameters[0];
                    if (contactList.contains(contact)) {
                        contactList.remove(contact);
                        return new Response("SUCCESS", null);
                    } else {
                        return new Response("ERROR", new String[]{"联系人不存在"});
                    }
                } else {
                    return new Response("ERROR", new String[]{"参数错误"});
                }

            case "GET_ALL":
                return new Response("SUCCESS", contactList.toArray(new String[0]));

            default:
                return new Response("ERROR", new String[]{"无效的请求类型"});
        }
    }
}