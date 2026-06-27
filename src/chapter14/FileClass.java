package chapter14;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileClass {
    public static void main(String[] args) {
        System.out.print(FileSystems.getDefault().getSeparator());

        File zooFile1 = new File("/home/tiger/data/stripes.txt");
        System.out.println("getPath: " + zooFile1.getPath()); // /home/tiger/data/stripes.txt
        System.out.println("getName: " + zooFile1.getName());
        System.out.println("getParent: " + zooFile1.getParent());
        System.out.println("mkdirs: " + zooFile1.mkdirs());
        System.out.println("isAbsolute: " + zooFile1.isAbsolute());
        System.out.println("getAbsolutePath: " + zooFile1.getAbsolutePath());
        System.out.println("delete: " + zooFile1.delete());
        System.out.println("exists: " + zooFile1.exists());
        System.out.println("isDirectory: " + zooFile1.isDirectory());
        System.out.println("isFile: " + zooFile1.isFile());
        System.out.println("lastModified: " + zooFile1.lastModified());
        System.out.println("lengh: " + zooFile1.length());
        System.out.println("listFiles: " + zooFile1.listFiles());
        System.out.println("mkdir: " + zooFile1.mkdir());
        System.out.println("rename: " + zooFile1.renameTo(new File("/home/tiger/data/stripes2.txt")));



        Path zooPath2 = Path.of("/home/tiger/data/stripes.txt");
        //alternando
        File f = zooPath2.toFile();
        Path p = zooFile1.toPath();


    }
}
