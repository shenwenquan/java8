package com.grx.lambda_test;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by apple on 16/4/23.
 */
public class FileTest {

    public static void main(String[] args) {
        File dir = new File("/Users/apple/opt/");
        if (dir.isDirectory()) {
            System.out.println(dir.listFiles().length);

        }
        if (dir.isDirectory()) {
            System.out.println(dir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return acc(pathname);
                }
            }).length);

        }

        if(dir.isDirectory()){
            System.out.println( dir.listFiles(pathname -> acc(pathname)).length);
        }

        if(dir.isDirectory()){

            System.out.println(dir.listFiles(FileTest::acc).length);
        }

        if(dir.isDirectory()){

            System.out.println(dir.listFiles(new FileTest()::acc2).length);
        }


        String [] names ={"peter","tom","sam"};

        List<Runnable> runners =new ArrayList<>();

        for(String name:names){
            runners.add(()-> System.out.println(name));
        }


       ExecutorService es = Executors.newCachedThreadPool();

        es.submit(runners.get(0));
        es.submit(runners.get(1));
        es.submit(runners.get(2));
    }

    public static boolean acc(File path){

        return path.getName().startsWith("apache");
    }

    public boolean acc2(File path){
        return  path.getName().startsWith("apache");
    }
}