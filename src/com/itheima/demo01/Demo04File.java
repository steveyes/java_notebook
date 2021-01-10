package com.itheima.demo01;

import java.io.File;

public class Demo04File {
    public static void main(String[] args) {
        show01();
    }

    private static void show01() {
        File f1 = new File("/data/www/working_on/day08/demo01/File/Demo06File.java");
        System.out.println(f1.exists());//true

        File f2 = new File("/data/www/working_on/day08/demo01/File");
        System.out.println(f2.exists());//false

        File f3 = new File("/data/www/working_on/day08/demo01/");//相对路径 C:\Users\itcast\IdeaProjects\shungyuan\shungyuan.iml
        System.out.println(f3.exists());//true

        File f4 = new File("/data/www/working_on/day08/");
        System.out.println(f4.exists());//false
    }
}
