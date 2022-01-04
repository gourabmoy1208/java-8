package com.poc.test.lambda;

public class TestInterfaces {

	public static void main(String[] args) {
		
		//Non Functional Interface implementation
		ImplementNonFunctionalInterface implementNonFunctionalInterface = new ImplementNonFunctionalInterface();
		implementNonFunctionalInterface.show();
		
		//Interface with only 1 abastract method using Lambda Expression
		FunctionalInterface1 interface1 = () -> System.out.println("Hello From Functional Interface");;
		interface1.show();
	}

}
