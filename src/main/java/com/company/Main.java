package com.company;

import java.io.IOException;
import static com.company.Client.startClient;

public class Main {

    public static void main(String[] args) {
        try {
            startClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
