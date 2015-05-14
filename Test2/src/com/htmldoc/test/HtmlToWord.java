package com.htmldoc.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.Stack;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HtmlToWord {
	public static void main(String[] args) {
		// getHtmlDetail("http://blog.csdn.net/ns_code/article/details/18547959",
		// "article_details");
		urlTest("http://blog.csdn.net/ns_code/article/details/18547959");
	}

	private static String getHtmlDetail(String url, String tag) {
		try {
			Document doc = Jsoup.parse(new URL(url), 500000);

			Element element = doc.getElementById(tag);

			System.out.println(element.html());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	private static void urlTest(String url) {
		
		
		
		Connection connection = Jsoup
				.connect(url)
				.userAgent(
						"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0; BIDUBrowser 2.x)");
		try {
			String body = connection.execute().body();
			Document document = Jsoup.parse(body);
			Elements elements = document.getElementsByTag("img");
			for (Element element : elements) {
				String tag = element.attr("src");
				if (tag.matches("http://img.blog.csdn.net/.*$")){
					System.out.println(element.attr("src"));
					InputStream isInputStream = new URL(element.attr("src")).openStream();
					saveImg(isInputStream);
				}
					
					
			}

			// Element element = document.getElementById("article_details");
			// System.out.println(element.html());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		//
		// try {
		// System.out.println(connection.execute().body());
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	private static void saveImg(InputStream is) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		byte[] total = null;
		byte[] buffer = new byte[1024];
		int len = 0;
		try {
			while ((len = is.read()) != -1) {
				bos.write(buffer, 0, len);
			}
			total = bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("E:/as"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			fos.write(total);
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
