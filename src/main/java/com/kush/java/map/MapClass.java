package com.kush.java.map;

import com.kush.pojo.User;
import java.util.HashMap;
import java.util.Map;

public class MapClass {
public static void main(String[] args) {
	User user1=new User(1, "user1");
	User user2=new User(2,"user2");

	Map<User,Integer> map=new HashMap<>();
	map.put(user1,4);
	map.put(user2,7);
	if(map.containsKey(new User(2,"user2"))) {
		System.out.println("contains..");
	}
	System.out.println(map);
}
}
