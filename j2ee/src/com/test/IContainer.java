package com.test;

import com.util.MyHashTable;

import java.util.*;

/**
 * Created by yinxuesong on 2016/4/23.
 */
public class IContainer {
    public static void  main(String[] args){
        Set<String> set = new HashSet<String>();
        set.add("hello");
        set.add("123");
        set.add("hhh");

        set.remove("hello");
        Iterator i = set.iterator();
        while(i.hasNext())
            System.out.println(i.next());

    }
}
