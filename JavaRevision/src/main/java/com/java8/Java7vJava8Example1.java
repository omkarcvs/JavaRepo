package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* Removing doupplicate */
public class Java7vJava8Example1 {
	public static void main(String[] args) {
		List<String> names=Arrays.asList("Omkar","Ram","Shyam","Omkar");
		
		//Before java 8
		List<String> uniqueList1=new ArrayList<String>();
		for(String name:names)
		{
			if(!uniqueList1.contains(name))
			{
				uniqueList1.add(name);
			}
		}
		System.out.println("UniqueList 1 : "+uniqueList1);
		System.out.println("-------------------");
		
		//After Java 8
		
		List<String> uniqueList2=names.stream().distinct().collect(Collectors.toList());
		System.out.println("Unique List 2 : "+uniqueList2);
	}
}
