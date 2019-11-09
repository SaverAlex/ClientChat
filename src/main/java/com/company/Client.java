package com.company;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static Socket socket = null;
    public static Gson gson = new Gson();
    public static String login;

    public static void startClient() throws IOException {
        FileProperties fileProperties = new FileProperties();
        socket = new Socket(fileProperties.getHost(), 1777);
        login = fileProperties.getLogin();

        // Авторизация
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        JsonData jsonData = new JsonData(fileProperties.getLogin(), fileProperties.getPassword());
        printWriter.println(gson.toJson(jsonData));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        OutputStream outputStream = new OutputStream();
        outputStream.printWriter = printWriter;
        Thread myThread = new Thread(outputStream);
        myThread.start();
        InputStream inputStream = new InputStream();
        inputStream.bufferedReader = bufferedReader;
        Thread myThread2 = new Thread(inputStream);
        myThread2.start();
    }
}
