package com.poc.anynomousclass;

public class LambdaInsteadofAnynomous {
	
	public static void main(String[] args){
		
		Age age = s -> "age is : "+s;
		System.out.println(age.getAge("32"));;
	}

}
