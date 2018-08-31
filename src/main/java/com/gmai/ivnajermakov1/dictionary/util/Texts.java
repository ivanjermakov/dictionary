package com.gmai.ivnajermakov1.dictionary.util;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class Texts {
	
	public static List<String> getWords(String text) {
		text = text.replaceAll("[^a-zA-Zа-яА-Я\\s]", "");
		
		List<String> words = new ArrayList<>();
		BreakIterator breakIterator = BreakIterator.getWordInstance();
		breakIterator.setText(text);
		
		int lastIndex = breakIterator.first();
		while (BreakIterator.DONE != lastIndex) {
			int firstIndex = lastIndex;
			lastIndex = breakIterator.next();
			if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
				words.add(text.substring(firstIndex, lastIndex));
			}
		}
		
		return words;
	}
	
}
