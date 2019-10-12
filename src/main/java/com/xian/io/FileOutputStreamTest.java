package com.xian.io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description: 将数据保存到文件中, 会将原来的进行覆盖
 * @Author: Xian
 * @CreateDate: 2019/10/12  11:06
 * @Version: 0.0.1-SHAPSHOT
 */
public class FileOutputStreamTest {
    public static void main(String args[]) {
        try {
            System.out.println("please Input from  Keyboard");
            int count, n = 512;
            byte buffer[] = new byte[n];
            count = System.in.read(buffer);
            FileOutputStream wf = new FileOutputStream("write.txt", true);
            wf.write(buffer, 0, count);
            wf.close(); // 当流写操作结束时，调用close方法关闭流。
            System.out.println("Save to the write.txt");
        } catch (IOException IOe) {
            System.out.println("File Write Error!");
        }
    }
}
