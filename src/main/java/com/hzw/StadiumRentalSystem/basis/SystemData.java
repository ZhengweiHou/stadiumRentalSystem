package com.hzw.StadiumRentalSystem.basis;

import java.util.HashMap;
import java.util.LinkedList;

public class SystemData {
	public static double OPENTIME=7;// 开馆时间（7:00）
	public static double CLOSETIME=22;// 闭馆时间（22：00）
	public static double FINENESS=0.5;// 时间粒度（30分钟）
//	public static HashMap<Integer,Double> stateMapTime;
	public static LinkedList<Double> indexMapTime;
	static{
		// TODO 获取数据库中的系统数据
		
		
		for(int state=0;(OPENTIME+state*FINENESS)<=OPENTIME;){
//			stateMapTime.put(state, OPENTIME+state*FINENESS);
			indexMapTime.add(OPENTIME+state*FINENESS);
			state+=1;
		}
	}
	
 
	
	
}
