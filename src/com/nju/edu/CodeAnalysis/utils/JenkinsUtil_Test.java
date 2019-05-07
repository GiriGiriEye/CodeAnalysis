package com.nju.edu.CodeAnalysis.utils;

import java.util.LinkedList;

public class JenkinsUtil_Test {
	public static void main(String[] args) {
//		JenkinsUtil.build("sonartest1", "F:\\soft\\ee-workspace\\testpro");
//		JenkinsUtil.getFreeJob();
//		System.out.println(EncryptUtil.encodeByMD5("admin"));
		LinkedList<String> l = new LinkedList<String>();
		l.add("C:/sonar/operating system_1_151250001");
		System.out.println(PathNameUtil.convertPathName(l).get(0));
	}
}
