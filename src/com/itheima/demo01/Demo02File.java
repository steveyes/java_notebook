package com.itheima.demo01;

import java.io.File;

public class Demo02File {
    public static void main(String[] args) {
//        show01();
//        show02("c:\\", "a.txt");//c:\a.txt
//        show02("d:\\","a.txt");//d:\a.txt
        show03();
    }

    private static void show03() {
        File parent = new File("c:\\");
        File file = new File(parent, "hello.java");
        System.out.println(file);//c:\hello.java
    }

    private static void show02(String parent, String child) {
        File file = new File(parent, child);
        System.out.println(file);//c:\a.txt
    }

    private static void show01() {
        File f1 = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan\\a.txt");
        System.out.println(f1);

        File f2 = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan");
        System.out.println(f2);

        File f3 = new File("b.txt");
        System.out.println(f3);

    }
}
