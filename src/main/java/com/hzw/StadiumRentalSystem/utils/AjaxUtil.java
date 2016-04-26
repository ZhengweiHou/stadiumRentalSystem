package com.hzw.StadiumRentalSystem.utils;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import com.alibaba.fastjson.JSON;
/**
 * 创建时间：2015-2-13 下午3:26:03
 * 
 * @author andy
 * @version 2.2 描述： ajax 输出信息
 */

public class AjaxUtil {

	// ajax返回text
	public static void ajaxResponse(String text) {
		try {
			ServletActionContext.getResponse().setContentType(
					"text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(text);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ajaxJSON返回
	public static void ajaxJSONResponse(Object object) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object,
					"yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType(
					"text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}