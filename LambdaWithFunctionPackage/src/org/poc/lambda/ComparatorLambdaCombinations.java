package org.poc.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambdaCombinations {

	public static void main(String[] args) {
		
			UserModel user1 = new UserModel("Gourab", "33");
			UserModel user2 = new UserModel("Sumanta", "33");
			UserModel user3 = new UserModel("Aneek", "32");
			UserModel user4 = new UserModel("Gourab", "32");
			UserModel user5 = new UserModel("Niladri", "33");
			
			List<UserModel> friendsList = Arrays.asList(user1,user2,user3,user4,user5);
			//Static method comparing creates instances of comparator interface
			Comparator<UserModel> compareName = Comparator.comparing((UserModel u) -> u.getName());
			friendsList.sort(compareName);
			//print friends in alphabetical order
			System.out.println(friendsList);
			//Static method comparing creates instances of comparator interface
			Comparator<UserModel> compareAge = Comparator.comparing((UserModel u) -> u.getAddress());
			friendsList.sort(compareAge);
			
			friendsList.sort(compareName.thenComparing(compareAge));
			friendsList.forEach(u -> System.out.println(u));
			
	}

}
