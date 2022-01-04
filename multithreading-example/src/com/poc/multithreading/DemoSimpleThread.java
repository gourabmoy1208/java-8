package com.poc.multithreading;

public class DemoSimpleThread {

	public static void main(String[] args) {
		Runnable runnable = () -> {
			System.out.println("I am Running : "+Thread.currentThread().getName());
		};
		
		Thread t = new Thread(runnable);
		t.setName("My thread");
		t.start();
		//t.run(); -> It will invoke the thread from which is is getting executed , will call the main method
		
		
	}

}
