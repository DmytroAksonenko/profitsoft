package com.aksonenko.exercise1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskOne {

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
