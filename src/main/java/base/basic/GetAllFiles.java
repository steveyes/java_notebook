package base.basic;

import java.io.File;
import java.io.FileFilter;

public class GetAllFiles {
    public static void main(String[] args) {
        getAllFilesV3(new File("/home/runzhi/repo/c_example/"), ".c");
//        getAllFilesV2(new File("/home/runzhi/repo/golang_example"), ".go");
//        getAllFilesV1(new File("/home/runzhi/repo/notebook/"), ".jpg");
    }

    public static void getAllFilesV3(File dir, String ext_name) {
        // Anonymous new FileFilter() was replaced with lambda compared to getAllFilesV2
        File[] files = dir.listFiles(pathname -> pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(ext_name));
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                getAllFilesV3(file, ext_name);
            } else {
                System.out.println(file);
            }
        }
    }

    public static void getAllFilesV2(File dir, String ext_name) {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(ext_name) || pathname.isDirectory();
            }
        });
        assert files != null;
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("filename: " + file.getAbsolutePath());
            } else {
                getAllFilesV2(file, ext_name);
            }
        }
    }


    public static void getAllFilesV1(File dir, String ext_name) {
        File[] files = dir.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                getAllFilesV1(file, ext_name);
            } else if (file.getName().toLowerCase().endsWith(ext_name)) {
                System.out.println(file);
            }
        }
    }
}
