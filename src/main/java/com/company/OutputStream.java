package com.company;

import java.io.PrintWriter;
import java.util.Scanner;

public class OutputStream implements Runnable{
    public PrintWriter printWriter;

    @Override
    public void run() {
        //System.out.println("** Запуск потока отправки сообщений **");
        write();
    }
    private void write(){
        String message;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            message = scanner.nextLine();
            printWriter.println(Client.gson.toJson(new JsonData(Client.login, message)));
        }
        printWriter.close();
    }
}
