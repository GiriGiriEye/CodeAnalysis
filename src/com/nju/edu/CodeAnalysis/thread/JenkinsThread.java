package com.nju.edu.CodeAnalysis.thread;

import java.util.LinkedList;
import java.util.List;

import com.nju.edu.CodeAnalysis.utils.JenkinsUtil;

/**
 * 扩展Thread类，用于并行做jenkins构建
 * @author zhr
 *
 */
public class JenkinsThread extends Thread {
	
	private String jobName;
	 
	private LinkedList<String> projectPathList;
	
	public JenkinsThread() {
		
	}
	
	public JenkinsThread(String jobName, List<String> projectPathList) {
		this.jobName = jobName;
		this.projectPathList = (LinkedList<String>)projectPathList;
	}
	
	/**
	 * 重写run方法，轮询检测job是否空闲，空闲则做build
	 */
	@Override
	public void run() {
		System.out.println("一个Jenkins线程开始运行");
		while(true) {
			if(JenkinsUtil.isJobFree(jobName)) {
				if(!projectPathList.isEmpty()) {
					JenkinsUtil.build(jobName, projectPathList.getFirst());
					projectPathList.removeFirst();
				}
				else if(projectPathList.isEmpty()) {
					break;
				}
			}
		}
		System.out.println("一个Jenkins线程结束了");
	}
}
