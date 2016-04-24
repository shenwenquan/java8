package com.grx.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by apple on 16/4/23.
 */
public class Test {

    public static void main(String[] args) throws IOException {

        String contents = new String(Files.readAllBytes(Paths.get("word.txt")), UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]"));
        System.out.println(words);

        long begin = 0;
        long count = 0;
        long end = 0;

        begin = System.currentTimeMillis();
        count = words.stream().filter(w -> w.length() > 3).count();
        end = System.currentTimeMillis();
        System.out.println("use:" + (end - begin) + " count:" + count);


        begin = System.currentTimeMillis();
        count = Stream.of(contents.split("[\\P{L}]")).filter(w -> w.length() > 3).count();
        end = System.currentTimeMillis();
        System.out.println("use:" + (end - begin) + " count:" + count);


        begin = System.currentTimeMillis();
        count = Arrays.stream(contents.split("[\\P{L}]")).filter(w -> w.length() > 3).count();
        end = System.currentTimeMillis();
        System.out.println("use:" + (end - begin) + " count:" + count);





    }
}
