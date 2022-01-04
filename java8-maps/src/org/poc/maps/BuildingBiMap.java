package org.poc.maps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.poc.maps.model.Person;



public class BuildingBiMap {

	public static void main(String[] args) {
	
		List<Person>  persons = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(BuildingBiMap.class.getResourceAsStream("Person")));
		
		Stream<String> stream = bufferedReader.lines();	
		
        stream.map(line -> 
			    	{
			    	String[] a = line.split(" ");
			    	Person p = new Person(a[0], Integer.parseInt(a[1]),a[2]);
			    	persons.add(p);
			    	return p;}).forEach(s -> System.out.println(s));
        
        List<Person> list1 = persons.subList(0, 5);
        List<Person> list2 = persons.subList(0, persons.size());
      
        Map<Integer, List<Person>>  map1= getMapByAge(list1);
        System.out.println("MAP 1");
        map1.forEach((i,p) -> System.out.println(i +" >>" + p));
        Map<Integer, List<Person>>  map2= getMapByAge(list2);
        System.out.println("MAP 2");
        map2.forEach((i,p) -> System.out.println(i +" >>" +p));
        
	}
	private static Map<Integer, List<Person>> getMapByAge(List<Person> list){
		
		    Map<Integer,List<Person>>  mapPerson = list.stream().collect(Collectors.groupingBy(p -> p.getAge()));
		    return mapPerson;
		
	}

}
