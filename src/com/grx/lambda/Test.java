package com.grx.lambda;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * Created by apple on 16/4/21.
 */
public class Test {

    public static void main(String[] args) throws Exception {

        String[] words = Arrays.asList("a", "aaaabb", "cdef").toArray(new String[]{});

        //要把lambda表达式想像成函数,而不是一个对象,并记住它可以被转变成一个函数式接口

        Arrays.sort(words, (first, second) -> Integer.compare(first.length(), second.length()));

        for (String word : words) {
            System.out.println("" + word);
        }

        System.out.println("==============================================");


        BiFunction<String,String,Integer> comp= (first, second) -> Integer.compare(first.length(), second.length());

        System.out.println("==============================================");


        //方法引用
        Arrays.sort(words,String::compareToIgnoreCase);

//        Arrays.sort(words,(x,y)->x.compareToIgnoreCase(y));

        for (String word : words) {
            System.out.println("" + word);
        }

        new ConGreeter().greet();

        System.out.println("==============================================");

        //构造器引用
        List<String> labels =Arrays.asList("aa", "bb", "cc");

        Stream<Button> stream =labels.stream().map(Button::new);

//        List<Button> buttons = stream.collect(Collectors.toList());
//        System.out.println(buttons);

        Button[] butArr=   stream.toArray(Button[]::new);
        for(Button b:butArr){
            System.out.println(b);
        }
        System.out.println("==============================================");

        //闭包,变量作用域

         new Closure().repeatMessage("hello",1);

        TimeUnit.SECONDS.sleep(1);

        System.out.println("==============================================");

        //默认方法
        System.out.println( new Student().getName());
    }
}
