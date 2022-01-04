package org.poc.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapExample {

	public static void main(String[] args) {

		List<Integer> list1 = Arrays.asList(1,2,3,4,5,66,77);
		List<Integer> list2 = Arrays.asList(100,200,300,400);
		List<Integer> list3 = Arrays.asList(1000,2000,3000);
		
		List<List<Integer>> list= Arrays.asList(list1,list2,list3);
		
		System.out.println(list);
		
		Function<List<?>, Integer> mapper = l -> l.size();
		Function<List<Integer>, Stream<Integer>> flatMapper  = s -> s.stream();
 		//Lambda
	//	list.stream().map(l -> l.size()).forEach( i -> System.out.println(i));
		//Method Reference
		list.stream().map(List::size).forEach(System.out::println);
		
		//Stream does not override toString() method
		list.stream().map(flatMapper).forEach(System.out::println);
		
		list.stream().flatMap(flatMapper).forEach(System.out::println);
		
	}

}
