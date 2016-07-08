package com.test;

import com.jdbc.DBQueryThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MysqlJDBCTest {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 50; i++) {
            exec.execute(new DBQueryThread());
        }
        exec.shutdown();
    }

}
