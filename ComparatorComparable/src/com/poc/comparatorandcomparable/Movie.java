package com.poc.comparatorandcomparable;

public class Movie implements Comparable<Movie>{

	private String name;
	private double rating;
	private int releaseYear;
	
	
	public Movie(String name, double rating, int releaseYear) {
		super();
		this.name = name;
		this.rating = rating;
		this.releaseYear = releaseYear;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	@Override
	public String toString() {
		return "Movie [name=" + name + ", rating=" + rating + ", releaseYear=" + releaseYear + "]";
	}

	@Override
	public int compareTo(Movie movie) {
		
		return this.getName().compareTo(movie.getName());
	}
	
	
}
