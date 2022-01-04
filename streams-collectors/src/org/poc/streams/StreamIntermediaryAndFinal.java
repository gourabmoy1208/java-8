package org.poc.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamIntermediaryAndFinal {

	public static void main(String[] args) {
		Stream<String> stream1 =  Stream.of("One","two","three","four","five");
		Stream<String> stream2 =  Stream.of("One","two","three","four","five");
		
		
		
		Predicate<String> filter1 = s -> s.length()>3;
		
		/*stream1.filter(filter1)
				.forEach(s ->System.out.println(s));
		*/
		
		//Chaining predicate
		
		Predicate<String> filter2 = Predicate.isEqual("One");
		Predicate<String> filter3 = filter1.or(filter2);
		List<String> list = new ArrayList<String>();
		
		//Intermediary operation, doesn't do anything
		stream1.peek(System.out::println).filter(filter1).peek(list::add);
		System.out.println("Done :");
		System.out.println("Size of the List : "+list.size());
		
		
		//Final operation, process the data for which stream is connected to.
		stream2.peek(System.out::println).filter(filter1).forEach(list::add);
		System.out.println("Done :");
		System.out.println("Size of the List : "+list.size());
	}

}
