package com.poc.test.lambda;


public interface FunctionalInterface1 {
	public void show();
	default void test(){System.out.println("Hello from FunctionalInterface1 :  "); }
}
