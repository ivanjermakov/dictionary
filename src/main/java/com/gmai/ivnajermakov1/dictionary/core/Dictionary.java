package com.gmai.ivnajermakov1.dictionary.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Dictionary {
	
	private String path;
	private boolean isLoaded;
	private final Set<String> content;
	
	public Dictionary(String path) {
		this.path = path;
		isLoaded = false;
		content = Collections.synchronizedSet(new TreeSet<>());
	}
	
	public void add(List<String> words) {
		content.addAll(words);
	}
	
	public void load() throws IOException {
		if (!new File(path).exists()) {
			isLoaded = true;
			save();
			return;
		}
		content.addAll(Files.lines(Paths.get(path)).collect(Collectors.toSet()));
		isLoaded = true;
	}
	
	public void save() throws IOException {
		if (!isLoaded) throw new IllegalStateException("dictionary must be load before saving.");
		synchronized (content) {
			FileWriter writer = new FileWriter(path);
			content.forEach(w -> {
				try {
					writer.append(w).append("\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			writer.close();
		}
	}
	
}
