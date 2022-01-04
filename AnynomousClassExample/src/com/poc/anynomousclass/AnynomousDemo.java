package com.poc.anynomousclass;

//Main Class
public class AnynomousDemo {

	public static void main(String[] args) {
		
		//Anynomous or Inner Class which can implement/extend only one Interface/class at a time
		// Myclass is hidden inner class of Age interface
        // whose name is not written but an object to it
        // is created.
         Age age = new Age() {
			
			@Override
			public String getAge(String age) {
				return "age is 32";
			}
		};
		System.out.println(age.getAge("32"));
	}

}
