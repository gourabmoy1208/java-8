package org.poc.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FilteringObjectsUsingLambda {

	public static void main(String[] args) {
		
		List<UserModel> userList = new ArrayList<>();
		userList.add(new UserModel("Gourab", "Sodepur"));
		userList.add(new UserModel("Sumanta", "Mukundapur"));
		userList.add(new UserModel("Niladri", "Baguiati"));
		
		List<String> names = new ArrayList<>();
		Function<UserModel, String> toStringList = (UserModel user) -> user.getName();
		
		for (UserModel user : userList) {
			String name = toStringList.apply(user);
			names.add(name);
		}
		userList.forEach((UserModel user) -> System.out.println(user));
		names.forEach((String name) -> System.out.println(name));

	}

}
