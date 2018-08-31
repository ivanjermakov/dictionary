package com.gmai.ivnajermakov1.dictionary.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebUtil {
	
	public static String pageContent(URL url) throws IOException {
		return new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next();
	}
	
	public static String readableHtml(String html) {
		Document document = Jsoup.parse(html);
		return document.select("body p").text();
	}
	
}
