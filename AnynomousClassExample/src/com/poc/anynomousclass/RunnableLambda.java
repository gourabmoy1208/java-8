package com.poc.anynomousclass;

public class RunnableLambda {

	public static void main(String[] args) throws InterruptedException {

		//Anynomous inner class
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<3;i++){
					System.out.println("Hello From Thread : "+Thread.currentThread().getName());
				}
				
			}
		};
		
		//Lambda
		Runnable runnableLambda = () -> {
			for(int i=0;i<3;i++){
				System.out.println("Hello From Thread : "+Thread.currentThread().getName());
			}
		};

		Thread t = new Thread(runnable);
		Thread tl = new Thread(runnableLambda);
		t.start();
		t.join();
		tl.start();
		tl.join();
	}

}
