package com.nju.edu.CodeAnalysis.service.impl;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

public class JSTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int length = 17/4;
		
		LinkedList<String> l1 = new LinkedList<String>();
		LinkedList<String> l2 = new LinkedList<String>();
		LinkedList<String> l3 = new LinkedList<String>();
		LinkedList<String> l4 = new LinkedList<String>();
		
		LinkedList<String> projectPathList = new LinkedList<String>();
		projectPathList.add("1");
		projectPathList.add("2");
		projectPathList.add("3");
		projectPathList.add("4");
		projectPathList.add("5");
		projectPathList.add("6");
		projectPathList.add("7");
		projectPathList.add("8");
		projectPathList.add("9");
		projectPathList.add("10");
		projectPathList.add("11");
		projectPathList.add("12");
		projectPathList.add("13");
		projectPathList.add("14");
		projectPathList.add("15");
		projectPathList.add("16");
		projectPathList.add("17");
		
		ArrayList<LinkedList<String>> listOflist = new ArrayList<LinkedList<String>>();
		listOflist .add(l1);
		listOflist .add(l2);
		listOflist .add(l3);
		listOflist .add(l4);
		
		for(int i = 0; i < projectPathList.size() ; i++) {
//			for(int j = 0 ; j < listOflist.size(); j++) {
				listOflist.get(i%4).add(projectPathList.get(i));
//				projectPathList.remove(i * 4 + j);
//			}
		}
		
		System.out.println(listOflist.get(0).toString());
		System.out.println(listOflist.get(1).toString());
		System.out.println(listOflist.get(2).toString());
		System.out.println(listOflist.get(3).toString());
//		System.out.println(projectPathList.toString());
	}

}
