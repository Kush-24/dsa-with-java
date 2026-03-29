package com.kush.java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kush.pojo.User;

public class Java8 {
	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(3, 7, 8, 12, 15);
		List<String> list1 = Arrays.asList("welcome!", "this", "is", "simple", "problem");

		
//Question: Given a list of integers, count the number of elements greater than 10.
		long count = numbers.stream().filter(n -> n > 10).count();
		System.out.println(count);

		
//Question: filter a list of string and get only >4 length string
		List<String> nlist = list1.stream().filter(str -> str.length() > 4).collect(Collectors.toList());
		System.out.println(nlist);

		
//Question: Convert a list of strings to uppercase and collect them into a new list.
		list1.stream().map(String::toUpperCase).forEach(System.out::println);
		List<String> nlist2 = list1.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
		System.out.println(nlist2);

		
// Question: Find the first even number in a list of integers.
		Optional<Integer> feven=numbers.stream().filter(num -> num%2==0).findFirst();
		int fevenn=numbers.stream().filter(num -> num%2==0).findFirst().orElse(-1);
		System.out.println(feven+" "+fevenn);

		
//Question: Given a list of words, create a list of unique characters present in all the words.
	List<Character>	clist=list1.stream().flatMap(word -> word.chars().mapToObj(c ->(char) c))
		              .distinct().collect(Collectors.toList());
	System.out.println(clist);
	
	
//Question: Calculate the max from the list of integer
Optional<Integer> max1 = numbers.stream().max(Integer::compareTo);//max((a,b)->a.compareTo(b))
System.out.println(max1);


//Question: Calculate the product of all elements in a list of integers.
    int numprod=numbers.stream().reduce((a,b) -> a * b).orElse(1);
	System.out.println(numprod);

	
//Question: Group a list of object by its field.
	List<User> users = Arrays.asList(
		    new User(25,"Alice"),
		    new User(30,"Bob"),
		    new User(25,"Charlie")
		);
	Map<Integer, List<User>> map=users.stream().collect(Collectors.groupingBy(User::getId));
	System.out.println(map);

	
//Question: Given a list of strings, find the length of the longest string.
	int maxLen=list1.stream().reduce((s1,s2) -> s1.length() > s2.length() ? s1:s2).map(s->s.length()).orElse(0);
	System.out.println(maxLen);
	
//Question: Given a list of integers, find the sum of the squares of all even numbers.
int prodofeven=numbers.stream().filter(num->num%2==0).map(num -> num * num).reduce((a,b)->a+b).orElse(0);
System.out.println(prodofeven);

//Question: Given a list of strings, find the product of the lengths of all strings that contain the letter 'a'.
List<String> list2 = Arrays.asList("contains", "letter", "a", "or", "not","and");
Optional<Integer> productOfLengths=list2.stream().filter(s -> s.indexOf('a')!=-1).map(s-> s.length()).reduce((a,b)-> a*b);
productOfLengths.ifPresent(value -> System.out.println("Product of lengths: " + value));

	}

}
