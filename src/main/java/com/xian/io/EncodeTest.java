package com.xian.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/10/12  13:45
 * @Version: 0.0.1-SHAPSHOT
 */
public class EncodeTest {
    private static void readBuff(byte[] buff) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(buff);
        int data;
        while ((data = in.read()) != -1) {
            System.out.print(data + "  ");
        }
        System.out.println();
        in.close();
    }

    public static void main(String args[]) throws IOException {
        System.out.println("内存中采用unicode字符编码：");
        char c = '好';
        int lowBit = c & 0xFF;
        int highBit = (c & 0xFF00) >> 8;
        System.out.println("" + lowBit + "   " + highBit);
        String s = "好";
        System.out.println("本地操作系统默认字符编码：");
        readBuff(s.getBytes());
        System.out.println("采用GBK字符编码：");
        readBuff(s.getBytes("GBK"));
        System.out.println("采用UTF-8字符编码：");
        readBuff(s.getBytes("UTF-8"));
    }
}
