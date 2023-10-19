package com.Test03.CS2;



import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class AddressBookServer {
    private static Map<String, Contact> addressBook = new HashMap<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // 监听的端口号

            System.out.println("服务器已启动，等待客户端连接...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("客户端已连接。");

                Thread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientThread extends Thread {
        private Socket clientSocket;

        public ClientThread(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());

                while (true) {
                    String request = (String) inputStream.readObject();
                    String[] requestParts = request.split(",");

                    String response;

                    if (requestParts[0].equals("ADD")) {
                        String name = requestParts[1];
                        String address = requestParts[2];
                        String phoneNumber = requestParts[3];

                        Contact contact = new Contact(name, address, phoneNumber);
                        addressBook.put(name, contact);

                        response = "联系人添加成功。";
                    } else if (requestParts[0].equals("UPDATE")) {
                        String name = requestParts[1];
                        String address = requestParts[2];
                        String phoneNumber = requestParts[3];

                        if (addressBook.containsKey(name)) {
                            Contact contact = addressBook.get(name);
                            contact.setAddress(address);
                            contact.setPhoneNumber(phoneNumber);

                            response = "联系人更新成功。";
                        } else {
                            response = "联系人不存在。";
                        }
                    } else if (requestParts[0].equals("DELETE")) {
                        String name = requestParts[1];

                        if (addressBook.containsKey(name)) {
                            addressBook.remove(name);
                            response = "联系人删除成功。";
                        } else {
                            response = "联系人不存在。";
                        }
                    } else if (requestParts[0].equals("GETLIST")) {
                        StringBuilder contactsList = new StringBuilder();

                        for (Contact contact : addressBook.values()) {
                            contactsList.append(contact.toString()).append("\n");
                        }

                        response = contactsList.toString();
                    } else {
                        response = "无效的请求。";
                    }

                    outputStream.writeObject(response);
                    outputStream.flush();
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}