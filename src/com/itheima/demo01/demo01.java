package com.itheima.demo01;

import java.io.File;

public class demo01 {

    public static void main(String[] args) {
        getAllFiles(new File("/home/runzhi/repo/c_example"));
    }


    public static void getAllFiles(File dir) {
        File[] files = dir.listFiles((pathname) -> pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".c"));
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                getAllFiles(file);
            } else {
                System.out.println(file);
            }
        }
    }
}
