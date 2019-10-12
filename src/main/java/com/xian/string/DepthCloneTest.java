package com.xian.string;

import java.io.*;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/10/11  8:49
 * @Version: 0.0.1-SHAPSHOT
 */
public class DepthCloneTest {
    public static void main(String[] args) {

        User user = new User();
        user.setUsername("张三");

        Dog dog = new Dog();
        dog.setDogName("小狗1");

        user.setDog(dog);

        User user2 = ObjCloner.cloneObj(user);

        System.out.println("user username : "+user.getUsername());
        System.out.println("user dogname : " + user.getDog().getDogName());
        System.out.println("user2 username : "+user2.getUsername());
        System.out.println("user2 dogname : " + user2.getDog().getDogName());

        System.out.println(" -------------------------------------");

        user2.setUsername("李四");
        user2.getDog().setDogName("小狗2");;

        System.out.println("user username : "+user.getUsername());
        System.out.println("user dogname : " + user.getDog().getDogName());
        System.out.println("user2 username : "+user2.getUsername());
        System.out.println("user2 dogname : " + user2.getDog().getDogName());
    }
}


class Dog implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dogName;

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

}

class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private String username;

    private Dog dog;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

}

