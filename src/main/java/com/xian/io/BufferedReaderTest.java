package com.xian.io;

import java.io.*;

/**
 * @Description:  计算机访问外部设备非常耗时。访问外存的频率越高，造成CPU闲置的概率就越大。
 * 为了减少访问外存的次数，应该在一次对外设的访问中，读写更多的数据。
 * 为此，除了程序和流节点间交换数据必需的读写机制外，还应该增加缓冲机制。
 * 缓冲流就是每一个数据流分配一个缓冲区，一个缓冲区就是一个临时存储数据的内存。这样可以减少访问硬盘的次数,提高传输效率
 * @Author: Xian
 * @CreateDate: 2019/10/12  11:31
 * @Version: 0.0.1-SHAPSHOT
 */
public class BufferedReaderTest {
    public static void main(String args[]) throws IOException {
        InputStreamReader sin = new InputStreamReader(System.in);
        BufferedReader bin = new BufferedReader(sin);
        System.out.println("【请输入】:");
        FileWriter out = new FileWriter("BufferedReaderTest.txt");
        BufferedWriter bout = new BufferedWriter(out);
        String s;
        try {
            while ((s = bin.readLine()).length() > 0) {
                bout.write(s, 0, s.length());
            }
        } finally {
            bin.close();
            bout.close();
        }

    }
}
