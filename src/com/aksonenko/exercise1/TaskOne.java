package com.aksonenko.exercise1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskOne {
	/*
	 * Сделать метод, который принимает на вход массив целых чисел, и возвращает
	 * только те из них, которые положительные (>=0), отсортировав их по убыванию.
	 * Сделать unit-тесты для этого метода.
	 */

	public static List getSortedList(int array[]) throws NullPointerException {
		List<Integer> intList = new ArrayList<>();
		Comparator<Integer> comparator = (o1, o2) -> o2.compareTo(o1);

		if (array != null) {
			for (int i : array) {
				if (i >= 0) {
					intList.add(i);
				}
			}
		}

		intList.sort(comparator);

		return intList;
	}
}
