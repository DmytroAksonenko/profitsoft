package com.aksonenko.exercise1;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TaskThree {

	/*
	 * Реализовать метод, сортирующий геометрические 3d фигуры по объему. Метод
	 * принимает параметром коллекцию произвольных геометрических фигур (куб, шар,
	 * цилиндр). Написать unit-тесты для метода.
	 */

	public List<Shape> sortShapes(Collection<Shape> collection) {

		List<Shape> list = new LinkedList<Shape>(collection);
		list.removeIf(Objects::isNull);

		Collections.sort(list, new Comparator<Shape>() {

			@Override
			public int compare(Shape o1, Shape o2) {
				return Double.compare(o1.getShapeVolume(), o2.getShapeVolume());
			}

		});

		return list;
	}

}
