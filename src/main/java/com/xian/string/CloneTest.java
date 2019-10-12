package com.xian.string;

import java.io.*;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/10/10  17:36
 * @Version: 0.0.1-SHAPSHOT
 */
public class CloneTest {
    public static void main(String args[]) {


        Address addr = new Address();
        addr.setAdd("杭州市");
        Student stu1 = new Student();
        stu1.setNumber(123);
        stu1.setAddr(addr);
        // 浅拷贝
//        Student stu2 = (Student)stu1.clone();
//        Student stu2 = new Student();
//        BeanUtils.copyProperties(stu1, stu2);
        // 深度拷贝
        String s = "abcdef";
        s.hashCode();
        Student stu2 = ObjCloner.cloneObj(stu1);
        stu1.hashCode();
        System.out.println("学生1:" + stu1.getNumber() + ",地址:" + stu1.getAddr().getAdd() + ",hashCode:" + stu1.hashCode());
        System.out.println("学生2:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd() + ",hashCode:" + stu2.hashCode());

        addr.setAdd("西湖区");

        System.out.println("学生1:" + stu1.getNumber() + ",地址:" + stu1.getAddr().getAdd() + ",hashCode:" + stu1.hashCode());
        System.out.println("学生2:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd() + ",hashCode:" + stu2.hashCode());
    }
}

class Address implements Cloneable, Serializable {
    private static final long serialVersionUID = -1033732588335640820L;

    private String add;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}

class Student implements Cloneable, Serializable{
    private static final long serialVersionUID = -7257300448359408841L;
    private int number;

    private Address addr;

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Object clone() {
        Student stu = null;
        try{
            //浅复制
            stu = (Student)super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return stu;
    }
}

class ObjCloner {

    public static  <T>T cloneObj(T obj){

        T retVal = null;

        try{

            // 将对象写入流中

            // 字节数组输出流在内存中创建一个字节数组缓冲区
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // 普通的输出流只能写入字节或者字符，不能直接写入对象，而ObjectOutputStream却可以将对象写入流当中
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);


            // 从流中读出对象

            // 将输入流放置在内存中的缓冲区域
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            // 将缓冲区内的数据放入对象流中
            ObjectInputStream ois = new ObjectInputStream(bais);

            retVal = (T)ois.readObject();

        }catch(Exception e){
            e.printStackTrace();
        }

        return retVal;
    }

}