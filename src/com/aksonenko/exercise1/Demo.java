package com.aksonenko.exercise1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Demo {
	public static void main(String[] args) {

//Task 1
		TaskOne taskOne = new TaskOne();
		int array[] = { 2, -4, 0, 1, 3, -5 };

		System.out.println("Task1:");
		System.out.println(taskOne.getSortedList(array));

//Task 2
		TaskTwo taskTwo = new TaskTwo();
		List<String> list = new ArrayList();
		list.add("some text #Java, some text #Java");
		list.add("Some text #Auto some text. #Auto");
		list.add("#Book some text");
		list.add("some text #Auto some text #Book");
		list.add("#House some text #Auto");
		list.add(" some text, #Book");
		list.add("#House, some text #Dog");
		list.add("#Java some text #Book");
		list.add("Some text. #Java");
		list.add("#Cat some text #Dog. Some text #Window.");

		System.out.println("\n" + "Task2:");
		System.out.println(taskTwo.getTopFiveList(list));

//Task 3
		TaskThree taskThree = new TaskThree();
		System.out.println("\n" + "Task3:");

		int cubeSide = 5;
		Shape cube = new Cube(cubeSide);
		cube.calculateShapeVolume();

		int circumference = 20;
		Shape sphere = new Sphere(circumference);
		sphere.calculateShapeVolume();

		int radius = 3;
		int height = 6;
		Shape cylinder = new Cylinder(radius, height);
		cylinder.calculateShapeVolume();

		Collection<Shape> shapeCollection = new ArrayList<>();
		shapeCollection.add(cylinder);
		shapeCollection.add(cube);
		shapeCollection.add(sphere);

		for (Shape shape : taskThree.sortShapes(shapeCollection)) {
			System.out.println(shape.getName() + ": " + shape.getShapeVolume());
		}

		System.out.println("\n" + "Done");

	}

}