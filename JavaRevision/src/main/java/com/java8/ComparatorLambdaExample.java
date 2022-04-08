package com.java8;

import java.util.Comparator;

/*Comparing of two integer */
public class ComparatorLambdaExample {

	public static void main(String[] args) {
		
		//Before java 8
		
		Comparator<Integer> c1=new Comparator<Integer>() {
			public int compare(Integer x,Integer y)
			{
				return x.compareTo(y);
			}
		};
		
		System.out.println("C1 : "+c1.compare(15,15));
		System.out.println("-------------------------------");
		//After
		Comparator<Integer> c2=(x,y)-> x.compareTo(y);
		System.out.println("C2 : "+c2.compare(15,15));

	}

}
