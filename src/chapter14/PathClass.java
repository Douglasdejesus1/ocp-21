package chapter14;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.SQLOutput;
import java.util.stream.Stream;

public class PathClass implements Serializable {
    public static void main(String[] args) throws IOException {
        Path zooPath1 = Path.of("/home/tiger/data/stripes.txt");
        Path zooPath2 = Paths.get("/home", "tiger", "data", "stripes2.txt");
        Path zooPath3 = Paths.get("/home", "tiger", "data", "stripes3.txt");
        //  teste(zooPath1, zooPath2, zooPath3);
        nio(zooPath1);
        nio(zooPath2);
        nio(zooPath3);
    }

    static void teste(Path... path) throws IOException {
        Path zooPath1 = path[0];
        Path zooPath2 = path[1];
        Path zooPath3 = path[2];
        System.out.println(Files.exists(zooPath1));
        System.out.println(zooPath1.toAbsolutePath()); // /home/tiger/data/stripes.txt

        System.out.println("getFileName: " + zooPath1.getFileName());
        System.out.println("getParent: " + zooPath1.getParent());
        System.out.println("isAbsolute: " + zooPath1.isAbsolute());
        System.out.println("toAbsolutePath: " + zooPath1.toAbsolutePath());
        System.out.println("deleteIfExists: " + Files.deleteIfExists(zooPath1));
        System.out.println("exists: " + Files.exists(zooPath1));
        System.out.println("isDirectory: " + Files.isDirectory(zooPath1));
        System.out.println("isFile: " + Files.isRegularFile(zooPath1));
        System.out.println("createFile: " + Files.createFile(zooPath1));
        System.out.println("lastModified: " + Files.getLastModifiedTime(zooPath1));
        System.out.println("size: " + Files.size(zooPath1));
        System.out.println("list: " + Files.list(zooPath1.getParent()));
        System.out.println("createDirectories: " + Files.createDirectories(zooPath1.getFileName()));
        //System.out.println("createDirectorie: " + Files.createDirectory(zooPath3.getFileName()));
        //System.out.println("move: "  + Files.move(zooPath1, zooPath2));
    }

    public static void nio(Path path) throws IOException {
        if (Files.exists(path)) {
            System.out.println("Absolute path: " + path.toAbsolutePath());
            System.out.println("Is Directory: " + Files.isDirectory(path));
            System.out.println("Parent Path: " + path.getParent());
            if (Files.isRegularFile(path)) {
                System.out.println("File Size: " + Files.size(path) + " bytes");
                System.out.println("Last Modified: " + Files.getLastModifiedTime(path));
            } else {
                try (Stream<Path> stream = Files.list(path)) {
                    stream.forEach(p -> System.out.println(" - " + p.getFileName()));
                }
            }
        }
    }
}

class NioOptions {
    public static void main(String[] args) throws IOException {
        Path zooPath1 = Path.of("/home/tiger/data/stripes.txt");
        Path zooPathAtalho = Path.of("/home/tiger/data/stripes_atalho");
        // System.out.println("createSymbolicLink: " + Files.createSymbolicLink(zooPathAtalho, zooPath1));
        System.out.println("is Symbolic Link: " + Files.isSymbolicLink(zooPath1));
        System.out.println("is Symbolic Link: " + Files.isSymbolicLink(zooPathAtalho));
        System.out.println("is File no Symbolic Link: " + Files.exists(zooPath1, LinkOption.NOFOLLOW_LINKS));
        System.out.println("is File no Symbolic Link: " + Files.exists(zooPathAtalho, LinkOption.NOFOLLOW_LINKS));

    }
}

class InteractionPath {
    public static void main(String[] args) throws IOException {
        Path zooPath1 = Path.of("/home/tiger/data/stripes.txt");
        Path absolutePath = zooPath1.getParent().normalize().toAbsolutePath();
        Path normalizePath = zooPath1.getParent().normalize();
        Path patentPath = zooPath1.getParent();
        System.out.println("Absolute: " + absolutePath);
        var p1 = Path.of("./armadillo/../shells.txt");
        System.out.println(p1.
                normalize()); // shells.txt
        var p2 = Path.of("/cats/../panther/food");
        System.out.println(p2.
                normalize()); // /panther/food
        var p3 = Path.of("../../fish.txt");
        System.out.println(p3.
                normalize()); // ../../fish.txt
        System.out.println("Normalize: " + normalizePath);
        System.out.println("Parent: " + patentPath);
        Path path = Path.of("/land/hippo/harry.happy");
        System.out.println("The Path is: " +
                path);
        for (int i = 0; i <
                path.getNameCount(); i++)
            System.out.println("   Element " + i + " is: " +
                    path.getName(i));

        Path path1 = Path.of("/cats/../panther");
        Path path2 = Path.of("food");
        System.out.println(path1.resolve(path2)); //CONCATENA CAMINHOS
        Path path3 = Path.of("/turkey/food");
        System.out.println(path3.
                resolve("/tiger/cage")); //RESOLVE SUBSTITUI O CAMINHO
        var path4 = Path.of("fish.txt");
        var path5 = Path.of("friendly/birds.txt");
        System.out.println(path4.
                relativize(path5));
        System.out.println(path5.
                relativize(path4));
    }
}

class MakingFiles {
    public static void main(String[] args) throws IOException {
        //Files.createDirectories(Path.of("/bison/field/pasture/green"));
        // Files.createDirectory(Path.of("/bison/field/pastures"));
        //Files.createDirectories(Path.of("/bison/field/pasture/green"));
        System.out.println(Files.isRegularFile(Path.of("/bison/field/pasture/green/myfile.txt")));
        Path target = Path.of("/bison/field/pasture/green/myfile.txt");
        Path outro = Path.of("/bison/field/pasture/green/outro.txt");
        Path link = Path.of("/bison/field/pasture/green/myfile-link.txt");
        //Files.createSymbolicLink(link, target);
        System.out.println(Files.isSymbolicLink(link));
        //Files.delete(Path.of("/bison/field/pasture/green"));
       // Files.delete(Path.of("/bison/field/pasture"));
       // Files.copy(Path.of("/bison/field/pasture/green"), Path.of("/bison/field/pastures2"));
        //Files.move(Path.of("/bison/field/pasture/green"), Path.of("/bison/field/pastures3"));
        System.out.println(Files.isSameFile(link, target));
        System.out.println(Files.isSameFile(outro, target));
        System.out.println(Files.mismatch(outro, target));
        System.out.println(Files.mismatch(link, target));
    }

}