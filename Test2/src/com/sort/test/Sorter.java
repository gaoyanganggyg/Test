package com.sort.test;

import java.util.Comparator;

public interface Sorter {
	public <T extends Comparable<T>> void sort(T[] list);
	public <T> void sort(Comparator<T> comparable, T[] list);
}
