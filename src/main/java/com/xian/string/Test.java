package com.xian.string;

import java.lang.ref.WeakReference;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/10/10  15:48
 * @Version: 0.0.1-SHAPSHOT
 */
public class Test {

    public static void main(String[] args) {

        WeakReference<String> sr = new WeakReference<String>(new String("hello"));

        System.out.println(sr.get());
        System.gc();                //通知JVM的gc进行垃圾回收
        System.out.println(sr.get());
    }
}
