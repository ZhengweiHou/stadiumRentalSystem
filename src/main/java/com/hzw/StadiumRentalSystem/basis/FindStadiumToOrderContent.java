package com.hzw.StadiumRentalSystem.basis;

import java.sql.Timestamp;
import java.util.List;

import com.hzw.StadiumRentalSystem.entity.Stadium;

public class FindStadiumToOrderContent {
	private static Timestamp destineDay;//预定日期
	
	private static String startTime;// 运动开始时间
	
	private static String endTime;// 运动结束时间	
	
	private static List<Stadium> stadiums;// 查询到的运动场

	public static Timestamp getDestineDay() {
		return destineDay;
	}

	public static String getStartTime() {
		return startTime;
	}

	public static String getEndTime() {
		return endTime;
	}

	public static List<Stadium> getStadiums() {
		return stadiums;
	}

	public static void setDestineDay(Timestamp destineDay) {
		FindStadiumToOrderContent.destineDay = destineDay;
	}

	public static void setStartTime(String startTime) {
		FindStadiumToOrderContent.startTime = startTime;
	}

	public static void setEndTime(String endTime) {
		FindStadiumToOrderContent.endTime = endTime;
	}

	public static void setStadiums(List<Stadium> stadiums) {
		FindStadiumToOrderContent.stadiums = stadiums;
	}
	
	
	
	
}
