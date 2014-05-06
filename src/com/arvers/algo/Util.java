package com.arvers.algo;

public class Util {
	public static long time(String string, long t) {
		long dif = (System.nanoTime() - t);
		System.out.println(string + ": " + dif / 1e6 + "ms");
		return dif;
	}
}
