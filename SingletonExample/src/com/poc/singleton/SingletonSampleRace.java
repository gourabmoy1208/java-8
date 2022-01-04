package com.poc.singleton;

public class SingletonSampleRace {
	
	private static SingletonSampleRace instance;
	private SingletonSampleRace() {
	}
   public SingletonSampleRace newInstance(){
			if(instance == null){
				instance =  new SingletonSampleRace();
			}
		return instance;
	}
}
