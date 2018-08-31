package com.gmai.ivnajermakov1.dictionary.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class Threads {
	
	public static <T> void waitUntil(T object, Predicate<T> predicate) {
		while (!predicate.test(object)) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void repeat(Runnable target, Integer times) {
		AtomicInteger counter = new AtomicInteger(0);
		for (int i = 0; i < times; i++) {
			new Thread(target).start();
			counter.getAndIncrement();
		}
		waitUntil(counter, c -> c.get() >= times - 1);
	}
	
	public static void repeat(Runnable target, Integer times, Integer delay) {
		AtomicInteger counter = new AtomicInteger(0);
		for (int i = 0; i < times; i++) {
			new Thread(target).start();
			
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			counter.getAndIncrement();
		}
		waitUntil(counter, c -> c.get() >= times - 1);
	}
	
}
