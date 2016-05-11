package com.test;

/**
 * Created by yinxuesong on 2016/5/11.
 */
public class ObserverTest {
    public static void main(String[] args){
        ConcretSubject cs = new ConcretSubject();

        IObserver io = new IObserver();
        cs.addObserver(io);

        System.out.println(io.getMyState());
        cs.set(3000);
        System.out.println(io.getMyState());
    }
}
