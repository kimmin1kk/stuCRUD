package com.studentcrud.config;

public class Configuration {
    //싱글톤 (도중에 값을 바꿀 수 있게 하려면 ㅇㅇ 근데 final로 박는 순간 의미가 없어짐)
//    private static Configuration configuration = null;
//
//    private Configuration() {}
//
//    public static Configuration getInstance() {
//        if(configuration == null) {
//            configuration = new Configuration();
//        }
//        return configuration;
//    }

    public static final int MAX_SCORE = 100;
    public static final int MIN_SCORE = 0;



}
