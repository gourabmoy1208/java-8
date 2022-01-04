package org.poc.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilteringListUsingLambda {

	public static void main(String[] args) {

		List<String> stringList = new ArrayList<>();
		stringList.add("One");
		stringList.add("Two");
		stringList.add("Three");
		stringList.add("Four");
		stringList.add("Five");
		//1. Lambda expression to remove elements and then print list
        Predicate<String> filter = (String s) -> s.startsWith("T");
		stringList.removeIf(filter);
		Consumer<String> action = (String s) -> System.out.println(s);
		stringList.forEach(action);
	
		//2. Lambda expression to remove elements and then print list Simplified
		stringList.removeIf(s -> s.startsWith("T"));
		stringList.forEach(s -> System.out.println(s));
	}

}
