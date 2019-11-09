package com.company;

import java.io.BufferedReader;
import java.io.IOException;

public class InputStream implements Runnable {

    public BufferedReader bufferedReader;

    public void read () throws IOException {
        String message;
        while ((message = bufferedReader.readLine()) != null) {
            System.out.println(message);
        }
        bufferedReader.close();
        System.out.println("** Сервер не отвечает **");
        Client.socket.close();
    }

    @Override
    public void run() {
        try {
            //System.out.println("** Запуск потока чтения сообщений **");
            read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
