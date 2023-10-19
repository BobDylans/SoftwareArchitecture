package com.Test03.CS2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class AddressBookClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234); // 连接到服务器的主机名和端口号

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            Scanner scanner = new Scanner(System.in);
            String userInput;

            do {
                System.out.println("请输入请求：");
                userInput = scanner.nextLine();

                outputStream.writeObject(userInput);
                outputStream.flush();

                String response = (String) inputStream.readObject();
                System.out.println("服务器响应：");
                System.out.println(response);

            } while (!userInput.equals("QUIT"));

            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}