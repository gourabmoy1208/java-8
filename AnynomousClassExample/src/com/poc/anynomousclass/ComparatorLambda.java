package com.poc.anynomousclass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class ComparatorLambda {

	public static void main(String[] args) {

		//Using anaynomous inner types
		Comparator<String> comparator = new Comparator<String>() {
			
			@Override
			public int compare(String var1, String var2) {
				return Integer.compare(var1.length(), var2.length());
			}
		};
		
		//using Lambda but autoboxing problem
		Comparator<String> comparatorLambda = (String s1,String s2) -> Integer.compare(s1.length(), s2.length());
				
				
		
		//using Lambda best approach preventing autoboxing
		ToIntFunction<String> toIntFunction = (String s) -> s.length();
		Comparator<String> comparatorLambdaBest = Comparator.comparingInt(toIntFunction);
				
				
				
		List<String> stars = Arrays.asList("****","***","*******","*","*****");

		//stars.sort(comparator);
		//stars.forEach(s -> System.out.println(s));
		
		stars.sort(comparatorLambda.reversed());
		stars.forEach(u -> System.out.println(u));
		
	//	stars.sort(comparatorLambdaBest);
		//stars.forEach(s -> System.out.println(s));
		
		
		
	}

}
