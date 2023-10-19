package com.Test03.CS3.Client;

import com.Test03.CS3.common.Request;
import com.Test03.CS3.common.RequestBuilder;
import com.Test03.CS3.common.Response;
import com.Test03.CS3.common.ResponseParser;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class AddressBookClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234); // 连接到服务器的主机名和端口号

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            String userInput;

            do {
                System.out.println("请输入请求：");
                userInput = scanner.nextLine();

                Request request = RequestBuilder.build(userInput);
                outputStream.writeObject(request);
                outputStream.flush();

                Response response = (Response) inputStream.readObject();
                System.out.println("服务器响应：");
                ResponseParser.parse(response);

            } while (!userInput.equals("QUIT"));

            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}