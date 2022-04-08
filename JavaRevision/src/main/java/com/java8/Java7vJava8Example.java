package com.java8;
import java.util.stream.IntStream;

/* Adding number from 1 to n */
public class Java7vJava8Example {

	public static void main(String[] args) {

     //Before java 8
	  
		int total1=0;
		for(int i=0;i<=50;i++)
		{
			total1 +=i;
		}
		System.out.println(" Total 1 : "+total1);
		
		//After Java 8
		System.out.println("--------------------------");
		int total2=IntStream.rangeClosed(0,50).sum();
		System.out.println("Total 2 : "+total2);
		

	}

}
