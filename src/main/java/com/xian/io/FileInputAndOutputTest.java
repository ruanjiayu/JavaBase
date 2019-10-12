package com.xian.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description: 将一个文件中的内容复制到其他地方
 * @Author: Xian
 * @CreateDate: 2019/10/12  11:14
 * @Version: 0.0.1-SHAPSHOT
 */
public class FileInputAndOutputTest {
    public static void main(String args[]) {
        try {
            File inFile = new File("hello.txt");
            // 注意如果是全英文，那么会导致一件事，他会将其转换成全小写模式，也就会导致进行覆盖原来的文件。如果说Hello2.txt文件。
            // 那么在输出的文件名字就是Hello2.txt
            File outFile = new File("Hello.txt");
            FileInputStream finS = new FileInputStream(inFile);
            FileOutputStream foutS = new FileOutputStream(outFile);
            int c;
            while ((c = finS.read()) != -1) {
                foutS.write(c);
            }
            finS.close();
            foutS.close();
        } catch (IOException e) {
            System.err.println("FileStreamsTest: " + e);
        }
    }

}
