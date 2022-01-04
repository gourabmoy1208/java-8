package com.poc.comparatorandcomparable;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparatorTest {

	public static void main(String[] args) {

		ArrayList<Movie> list = new ArrayList<Movie>();
		list.add(new Movie("Force Awakens", 8.3, 2015));
		list.add(new Movie("Star Wars", 8.7, 1977));
		list.add(new Movie("Empire Strikes Back", 8.8, 1980));
		list.add(new Movie("Return of the Jedi", 8.4, 1983));

		Comparator<Movie> sortedMovie = Comparator.comparing(Movie::getName).thenComparing(Movie::getRating)
				.thenComparing(Movie::getReleaseYear);
		list.sort(sortedMovie);
		list.forEach(
				movie -> System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getReleaseYear()));

	}

}
