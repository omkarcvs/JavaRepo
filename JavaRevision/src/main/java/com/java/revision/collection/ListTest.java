package com.java.revision.collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {

		List<Integer> l=new ArrayList();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		
		l.stream().forEach((i)->System.out.println(i));

	}

}
