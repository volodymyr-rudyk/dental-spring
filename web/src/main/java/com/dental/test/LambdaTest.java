package com.dental.test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by vrudyk on 10/25/2015.
 */
public class LambdaTest {
	public static void main(String[] a) {
		System.out.println("Start");
		Random random = new Random(1000000);
		List<Integer> collect = Stream.generate(() -> {
			int i = random.nextInt();
			System.out.println(i);
			return i;
		}).filter(e -> e > 1000).limit(100000).collect(Collectors.toList());


		System.out.println("End");



		List<String> data = Arrays.asList("q", "w", "e", "r", "t", "y");
		String test = "PREFIX:";

		run(data, test::concat);
		run(data, String::toUpperCase);
		q().accept("lalala");

//		Consumer<String> a1 = s1 ->
	}

	private static void run(List<String> data, Function<String, String> function) {
		for (String s : data) {
			System.out.println(function.apply(s));
		}
	}

	private static void run(List<String> data, Supplier<String> function) {

		for (String s : data) {
			System.out.println(function.get());
		}

	}

	public static Consumer<String> q() {
		return (s -> System.out.println(s.concat("Hello")));
	}

}
