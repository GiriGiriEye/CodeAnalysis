package com.nju.edu.CodeAnalysis.utils;

import java.util.LinkedList;

public class PathNameUtil {
	public static LinkedList<String> convertPathName(LinkedList<String> projectPathList){
		for(int i = 0; i < projectPathList.size(); i++) {
			String str = projectPathList.get(i);
			str = str.replace("\\", "/");
			str = str.substring(str.lastIndexOf("/") + 1, str.length());
			projectPathList.set(i, str);
		}
		return projectPathList;
	}
}
