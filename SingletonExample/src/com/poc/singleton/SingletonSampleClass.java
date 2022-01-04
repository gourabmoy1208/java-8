package com.poc.singleton;

public class SingletonSampleClass {
	
	private static SingletonSampleClass instance;
	private SingletonSampleClass() {
	}
   public synchronized SingletonSampleClass newInstance(){
			if(instance == null){
				return new SingletonSampleClass();
			}
		
		return null;
	}
}
