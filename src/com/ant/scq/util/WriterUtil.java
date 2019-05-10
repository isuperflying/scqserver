package com.ant.scq.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class WriterUtil {
	public static void writeStr(String str) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(str);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}