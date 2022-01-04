package org.poc.lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ChainingLambdaExpressions {

	public static void main(String[] args) {

		Consumer<String> c1 = s -> System.out.println("c1 says :"+s);
		Consumer<String> c2 = s -> System.out.println("c2 says :"+s);
		c1.accept("Hello");
		c2.accept("Hello");
		Consumer<String> c3 = c1.andThen(c2);
		c3.accept("Hello");
		
		Predicate<String> isNull = s -> s==null;
		Predicate<String> isEmpty = s -> s == "";
		System.out.println(isNull.test(null));
		System.out.println(isEmpty.test(""));
		Predicate<String> testPre = isNull.negate().and(isEmpty.negate());
		System.out.println(testPre.test(null));
		System.out.println(testPre.test(""));
		System.out.println(testPre.test("Test"));
	}

}
