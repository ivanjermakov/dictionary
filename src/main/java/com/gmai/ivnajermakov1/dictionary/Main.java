package com.gmai.ivnajermakov1.dictionary;

import com.gmai.ivnajermakov1.dictionary.content.WikipediaContentGenerator;
import com.gmai.ivnajermakov1.dictionary.core.Dictionary;
import com.gmai.ivnajermakov1.dictionary.util.Texts;
import com.gmai.ivnajermakov1.dictionary.util.Threads;

public class Main {
	
	private static final String RESOURCES_FOLDER = "src/main/resources/";
	
	public static void main(String[] args) throws Exception {
		Dictionary dictionary = new Dictionary(RESOURCES_FOLDER + "dictionary.txt");
		dictionary.load();
		
		Threads.repeat(() -> {
			String content = new WikipediaContentGenerator().generate();
			System.out.println(content);
			
			dictionary.add(Texts.getWords(content));
		}, 10000, 80);
		
		dictionary.save();
	}
	
}
