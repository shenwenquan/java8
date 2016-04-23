package com.grx.lambda;

/**
 * Created by apple on 16/4/23.
 */
public class Closure {
    public  void repeatMessage(String text ,int count){

        //在lambda表达式中,text,和count为自由变量
        Runnable r = ()->{
          for(int i=0;i<count;i++){
              System.out.println(text);
              Thread.yield();
          }
            System.out.println(this.toString());
        };
        new Thread(r).start();
    }

    @Override
    public String toString() {
        return "Closure{......}";
    }
}
