package com.gmai.ivnajermakov1.dictionary.util;

public class Strings {
	
	public static String readable(String input) {
		return input.replaceAll("[^a-zA-Z0-9\\s]", " ");
	}
	
}
