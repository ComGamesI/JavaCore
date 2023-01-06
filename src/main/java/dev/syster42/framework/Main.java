package dev.syster42.framework;

import dev.syster42.framework.utils.FileAPI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileAPI fileAPI = new FileAPI("test.txt");
        fileAPI.createFile();

        System.out.println(fileAPI.canExecute());
        fileAPI.writeInNextFreeLine("55");
        System.out.println();
        System.out.println(fileAPI.canRead());
        System.out.println(fileAPI.getFile().getAbsoluteFile());
        System.out.println(fileAPI.canWrite());
        System.out.println(fileAPI.exists());
        System.out.println(fileAPI.getFilename());
        System.out.println(fileAPI.getPath());
        System.out.println(fileAPI.isDirectory());
        System.out.println(fileAPI.isFile());
        System.out.println(fileAPI.isHidden());
        System.out.println(fileAPI.lastModified());
        System.out.println(fileAPI.length());
        System.out.println(fileAPI.readAll());
        System.out.println(fileAPI.readLine(1));
        System.out.println(fileAPI.renameFile("log.txt"));
        scanner.nextLine();
        fileAPI.writeOverrideAll("d");
        scanner.nextLine();
        fileAPI.deleteFile();


    }
}
