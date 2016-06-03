package com.Observe;

import java.util.Observer;

class WatcherTest {
    public static void main(String[] args) {
        Watched watched = new Watched();
        Observer watcher = new Watcher(watched);
        watched.setData("hello");
        watched.setData("nihao");
        watched.setData("goods");

    }

}