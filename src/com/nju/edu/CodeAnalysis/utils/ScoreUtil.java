package com.nju.edu.CodeAnalysis.utils;

import com.nju.edu.CodeAnalysis.bean.AnalysisBean;

public class ScoreUtil {
	public static AnalysisBean grade(AnalysisBean bean) {
		double vulnerabilities = Double.parseDouble(bean.getVulnerabilities());
		double bugs = Double.parseDouble(bean.getBugs());
		double codeSmells = Double.parseDouble("");
		return null;
	}
}
