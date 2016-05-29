package com.hzw.StadiumRentalSystem.basis;

import java.util.HashMap;
import java.util.LinkedList;

public class SystemData {
	public static String OPENTIME="8:00";// 开馆时间（7:00）
	public static String CLOSETIME="22:00";// 闭馆时间（22：00）
	public static int FINENESS=30;// 时间粒度（30分钟）
//	public static HashMap<Integer,Double> stateMapTime;
	public static LinkedList<String> indexMapTime;
	static{
		// TODO 获取数据库中的系统数据
		String[] temp = OPENTIME.split(":");
		int oph = Integer.parseInt(temp[0]);
		int opm = Integer.parseInt(temp[1]);
		temp = CLOSETIME.split(":");
		int clh = Integer.parseInt(temp[0]);
		int clm = Integer.parseInt(temp[1]);
		
		
		indexMapTime = new LinkedList<String>();
		
		for(;oph<clh||oph==clh&&opm<=clm;){
			StringBuilder time = new StringBuilder();
			time.append(oph<10?"0"+oph:""+oph).append(":").append(opm<10?"0"+opm:""+opm);
			String temps = time.toString();
			indexMapTime.add(temps);
			opm+=FINENESS;
			if(opm>=60){
				opm-=60;
				oph+=1;
			}
		}
		
		
		
		
		
		
//		for(int state=0;(OPENTIME+state*FINENESS)<=OPENTIME;){
////			stateMapTime.put(state, OPENTIME+state*FINENESS);
//			indexMapTime.add(OPENTIME+state*FINENESS);
//			state+=1;
//		}
	}
	
 
	
	
}
