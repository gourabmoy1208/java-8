package com.poc.singleton;

public class SingletonSampleBlock {
	
	private static SingletonSampleBlock instance;
	private SingletonSampleBlock() {
	}
   public SingletonSampleBlock newInstance(){
	   
	   //Synchronized Block
		synchronized (this) {
			if(instance == null){
				instance =  new SingletonSampleBlock();
			}
		}
		return instance;
	}
}
