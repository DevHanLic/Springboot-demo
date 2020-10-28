package com.example.spring.demo;

public class SingLog {
    private static  final SingLog singLog=new SingLog();
    private SingLog() {};
    private static SingLog getSingLog(){
        return singLog;
    }

    public static void main(String[] args) {
        SingLog singLog = SingLog.getSingLog();
        SingLog singLog1 = SingLog.getSingLog();
        System.out.println(singLog == singLog1);
    }
}
