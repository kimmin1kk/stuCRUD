package com.studentcrud.config;

public class Configuration { //싱글톤
    private static Configuration configuration = null;

    private Configuration() {}

    public static Configuration getInstance() {
        if(configuration == null) {
            configuration = new Configuration();
        }
        return configuration;
    }
}
