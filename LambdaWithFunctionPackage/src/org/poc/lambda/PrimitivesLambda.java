package org.poc.lambda;

import java.util.function.DoubleToIntFunction;
import java.util.function.IntSupplier;

public class PrimitivesLambda {

	public static void main(String[] args) {
		IntSupplier supplier = () -> 10;
		System.out.println(supplier.getAsInt());
		DoubleToIntFunction doubleToIntFunction = (double d) -> (int)Math.floor(d);
		System.out.println(doubleToIntFunction.applyAsInt(10.00));

	}

}
