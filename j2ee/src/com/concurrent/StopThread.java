package com.concurrent;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static volatile boolean stopRequest = false;//volatile保证对多个线程可见

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequest)
                    i++;
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequest = true;
    }
}
