package com.nju.edu.CodeAnalysis.service.impl;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

public class JSTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList l  =new LinkedList();
		l.add("1_1");
		JenkinsServiceImpl js = new JenkinsServiceImpl();
		js.multipleBuild(l);
		
	}

}
