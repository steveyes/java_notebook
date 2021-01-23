package basic;

import java.io.File;

public class GetAllFiles {
    public static void main(String[] args) {
        getAllFilesV2(new File("/home/runzhi/repo/c_example/"), ".c");
        getAllFilesV1(new File("/home/runzhi/repo/notebook/"), ".jpg");
    }

    public static void getAllFilesV2(File dir, String ext_name) {
        File[] files = dir.listFiles((pathname) -> pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(ext_name));
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                getAllFilesV2(file, ext_name);
            } else {
                System.out.println(file);
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
