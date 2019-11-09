package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileProperties {

    private String login;
    private String password;
    private String host;

    public FileProperties() {
        try {
            InputStream input = new FileInputStream("config.properties");
            Properties properties = new Properties();
            properties.load(input);
            this.login = properties.getProperty("login");
            this.password = properties.getProperty("password");
            this.host = properties.getProperty("host");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getHost(){
        return host;
    }


}
