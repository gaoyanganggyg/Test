package com.mail.test;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class T1 {
	public static void main(String[] args) throws EmailException {
		SimpleEmail simpleEmail = new SimpleEmail();
		simpleEmail.setHostName("smtp.163.com");
		simpleEmail.setAuthentication("", "");
		simpleEmail.addTo("shaanqin@126.com", "ÉÂÇÚ");
		simpleEmail.setFrom("gaoyangangde@163.com", "ÉÂÇÚ1");
		simpleEmail.setSubject("²âÊÔ");
		simpleEmail.setCharset("UTF-8");
		simpleEmail.setMsg("²âÊÔ111111111");
		String temp = simpleEmail.send();
		System.out.println(temp);
	}

}
