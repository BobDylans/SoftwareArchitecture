package com.Test03.CS3.server;

import com.Test03.CS3.common.Request;
import com.Test03.CS3.common.Response;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AddressBookServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // 监听指定端口

            while (true) {
                System.out.println("等待客户端连接...");
                Socket clientSocket = serverSocket.accept(); // 接受客户端连接

                System.out.println("客户端连接成功！");

                Thread clientThread = new Thread(() -> {
                    try {
                        ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
                        ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());

                        while (true) {
                            Request request = (Request) inputStream.readObject();
                            Response response = AddressBookService.processRequest(request);

                            outputStream.writeObject(response);
                            outputStream.flush();
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}