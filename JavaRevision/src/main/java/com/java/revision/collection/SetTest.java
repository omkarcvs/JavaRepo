package com.java.revision.collection;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> s=new HashSet();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		
		s.stream().forEach((i)->System.out.println(i));

	}

}
