package com.itheima.demo01;

import java.io.File;

public class Demo06File {
    public static void main(String[] args) {
        show02();
    }

    private static void show02() {
        File file = new File("/data/www");
        File[] files = file.listFiles();
        assert files != null;
        for (File f : files) {
            System.out.println(f);
        }
    }

    private static void show01() {
        File file = new File("/data/www");
        String[] arr = file.list();
        assert arr != null;
        for (String fileName : arr) {
            System.out.println(fileName);
        }
    }
}
