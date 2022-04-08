package com.java8;

public class RunnableLambdaExample {

	public static void main(String[] args) {
		
		//Before java 8
		Runnable t1= new Runnable() {
			public void run() {
				System.out.println("Thread 1");
			}
		};
		
		new Thread(t1).start();
		System.out.println("-----------------");
		//After Java 8
		
		Runnable t2=()-> System.out.println("Thread 2");		
		new Thread(t2).start();
		
		Runnable t3=()-> {System.out.println("Thread 3");
						  System.out.println("Thread 3.1");};	
		new Thread(t3).start();
		

	}

}
