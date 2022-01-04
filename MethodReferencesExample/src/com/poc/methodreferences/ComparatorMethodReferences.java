package com.poc.methodreferences;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class ComparatorMethodReferences {

	public static void main(String[] args) {
		List<String> numberList = 
				Arrays.asList("one","two","three","four","five","six","seven");
	
		Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2); 
		//sorted in alphabetical order
		numberList.sort(comparator);
		/*for (String string : numberList) {
			System.out.println(string);
		}
*/
		//sort the string from shortest to longest string
		Comparator<String> comparatorInt = (s1,s2) -> Integer.compare(s1.length(), s2.length());
		numberList.sort(comparatorInt);
		//System.out.println(numberList);

		//Reverse the comparison
		Comparator<String> compare = (s1,s2) -> Integer.compare(s1.length(), s2.length());
		numberList.sort(compare.reversed());
		System.out.println(numberList);
		
		//using static comparing method from Comparator interface using Functions
		
		//Function<String, Integer> toInteger = s -> s.length();
		Function<String, Integer> toInteger =String::length;
		
		//static methods creates Lambda without writing it
		Comparator<String> coparatorFunc = Comparator.comparing(toInteger);
		
		//To prevent autoboxing
		
		ToIntFunction<String> toIntFunction = String::length;
		Comparator<String> coparatorFuncInt = Comparator.comparingInt(toIntFunction);
		
		numberList.sort(coparatorFuncInt);
		System.out.println(numberList);
		
		//reverse comparison

		//numberList.sort(coparatorFuncInt.reversed());
		//System.out.println(numberList);
		
		
	}

}

