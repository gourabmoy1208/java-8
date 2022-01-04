package org.poc.lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class TestFunctionPackageWithLambda {
	
	public static void main(String[] args){
		
		//Supplier Functional Interface using Lambda
		Supplier<String> supplier = () -> {
			
			System.out.println("Inside Supplier");
			return "Hello From Supplier";
		};
		//Invoking Lambda function
		System.out.println(supplier.get());
		
		//Consumer Functional Interface using Lambda
	    Consumer<String> consumer = (String string) -> {
	    	System.out.println("Block code from Consumer");
	    	System.out.println(string);
	    };
	    //Invoking Lambda function
	    consumer.accept("Hello From Consumer");
	}

}
