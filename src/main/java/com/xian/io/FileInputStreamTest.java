package com.xian.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Description: 默认地址是在工程目录下，不是在编写文件同级目录下
 * @Author: Xian
 * @CreateDate: 2019/10/12  10:42
 * @Version: 0.0.1-SHAPSHOT
 */
public class FileInputStreamTest {
    public static void main(String args[]) {
        try {
//            FileInputStream rf = new  FileInputStream(".\\src\\main\\java\\com\\xian\\io\\1.txt");
            FileInputStream rf = new FileInputStream("hello.txt");
            int n = 1024;
            byte buffer[] = new byte[n];
            while ((rf.read(buffer, 0, n) != -1) && (n > 0)) {
                System.out.println(new String(buffer));
            }
            System.out.println("【读取完毕】");
            rf.close();
        } catch (IOException IOe) {
            System.out.println(IOe.toString());
        }

    }
}
