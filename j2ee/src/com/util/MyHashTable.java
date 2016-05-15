package com.util;

import java.util.Arrays;

/**
 * Created by yinxuesong on 2016/4/23.
 */
public class MyHashTable {
    private Entry[] buckets;

    @Override
    public Object clone() {
        try {
            MyHashTable result = (MyHashTable) super.clone();
            result.buckets = buckets.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "MyHashTable{" +
                "buckets=" + Arrays.toString(buckets) +
                '}';
    }

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
