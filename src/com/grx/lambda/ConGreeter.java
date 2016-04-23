package com.grx.lambda;

/**
 * Created by apple on 16/4/21.
 */
public class ConGreeter extends Greeter {
    @Override
    public void greet() {
        Thread t = new Thread(super::greet);
        t.start();
    }
}
