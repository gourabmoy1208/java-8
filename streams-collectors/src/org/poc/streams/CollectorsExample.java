package org.poc.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.poc.streams.model.Person;

public class CollectorsExample {

	public static void main(String[] args) throws IOException {
		
		List<Person>  persons = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(CollectorsExample.class.getResourceAsStream("Person")));
		
		Stream<String> stream = bufferedReader.lines();	
		
        stream.map(line -> 
			    	{
			    	String[] a = line.split(" ");
			    	Person p = new Person(a[0], Integer.parseInt(a[1]));
			    	persons.add(p);
			    	return p;}).forEach(s -> System.out.println(s));
        
        
        
        //Stream can not be operated more than once
        Optional<Person> minPerson = persons.stream().filter((Person p) -> p.getAge()> 20).min(Comparator.comparing(Person::getAge));
        Optional<Person> maxPerson = persons.stream().filter((Person p) -> p.getAge()> 20).max(Comparator.comparing(Person::getAge));
        System.out.println("Min Person : "+minPerson);
        
        System.out.println("Max Person : "+maxPerson);
        //Collecting the stream
        Map<Integer, List<Person>> mapPerson = persons.stream().collect(Collectors.groupingBy(Person::getAge));
        
        System.out.println(mapPerson);
        
        //downstream collector
        Map<Integer, Long> mapPerson1 = persons.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
        
        System.out.println(mapPerson1);
        
        
        //downstream collector group by name
        Map<Integer, List<String>> mapPerson2 = persons.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName,Collectors.toList())));
        System.out.println(mapPerson2);
        
        //downstream collector group by name
        Map<Integer, List<String>> mapPerson3 = persons.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName,Collectors.toList())));
        System.out.println("mapPerson3 : "+mapPerson3);
        
        
        //downstream collector group by Tree set
        Map<Integer, Set<String>> mapPerson4 = persons.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName,Collectors.toCollection(TreeSet::new))));
        System.out.println("mapPerson4 : "+mapPerson4);
        
        
        
        
        //downstream collector group by String
        Map<Integer, String> mapPerson5 = persons.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName,Collectors.joining(","))));
        System.out.println("mapPerson5 : "+mapPerson5);
        
	}

}
