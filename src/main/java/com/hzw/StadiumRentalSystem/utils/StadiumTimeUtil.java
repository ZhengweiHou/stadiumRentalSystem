package com.hzw.StadiumRentalSystem.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 分时段操作工具
 * @author HZW_922
 *
 */
public class StadiumTimeUtil {

	/**
	 * 根据时间段标识数，生成时间段key值集合 ----生成位数数值从0开始,（十进制数转换成二进制位数）
	 * 
	 * @param n
	 *            时间段标识数字
	 * @param list
	 *            时间段key值集合
	 * @throws Exception
	 */

	public static List<Integer> decimalToBits(int n) throws Exception {
		if (n > 0) {
			List<Integer> list = new LinkedList<Integer>();
			decimalToBits(n, list);
			return list;
		} else if (n < 0) {
			throw new Exception("错误信息：时间段标识数[" + n + "]小于零！");
		}
		return null;
	}

	private static void decimalToBits(int n, List<Integer> list) {
		if (n > 0) {
			int i = 0;
			while (((int) Math.pow(2, i)) <= n) {
				i++;
			}
			list.add(--i);
			decimalToBits(n - (1 << i), list);
		}
	}

	/**
	 * 根据时间段key值集合，生成时间段标识数字 ----指定位数，生成相应二进制数的十进制的值,（二进制位数转换成十进制数）
	 * 
	 * @param list
	 * @return
	 */
	public static int bitsToDecimal(List<Integer> list) {
		int i = 0;
		if (list != null && !list.isEmpty())
			for (Integer integer : list) {
				i += 1 << integer;
			}
		return i;

	}

	/**
	 * 判断所选时间段表示数在目标时间段表示数中是否有重复时间段 ----比较两个十进制数的二进制数为1的位是否有重复
	 * 
	 * @param beCompared	
	 * @param compared
	 * @return 不重复返回false，重复返回true
	 */
	public static Boolean bitsIsRepeat(int beCompared, int compared) {
		if (beCompared != (beCompared & ~compared))
			return true;
		else
			return false;
	}

}
