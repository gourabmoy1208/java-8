package org.poc.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class ReductionExample {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(-10,-10);
		
		BinaryOperator<Integer> operation = (i1,i2) -> (i1+i2);
		
		BinaryOperator<Integer> maxOperation = (i1,i2) -> i1>i2 ?i1:i2;
		int sum = list.stream().reduce(0, operation);
		int max = list.stream().reduce(0, maxOperation);
		System.out.println(sum);
		
		System.out.println(max);

		Optional<Integer> optionalValue = list.stream().reduce( maxOperation);
		System.out.println(optionalValue);
		System.out.println(optionalValue.get());
	}

}
