package org.poc.streams;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstPredicates {

	public static void main(String[] args) {


		Stream<String> stream1 =  Stream.of("One","two","three","four","five");
		Stream<String> stream2 =  Stream.of("One","two","three","four","five");
		
		
		
		Predicate<String> filter1 = s -> s.length()>3;
		
		stream1.filter(filter1)
				.forEach(s ->System.out.println(s));
		
		
		//Chaining predicate
		
		Predicate<String> filter2 = Predicate.isEqual("One");
		Predicate<String> filter3 = filter1.or(filter2);
		
		
		stream2.filter(filter1)
		.forEach(s ->System.out.println(s));
	}

}
