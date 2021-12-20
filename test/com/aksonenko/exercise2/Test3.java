package com.aksonenko.exercise2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.aksonenko.exercise1.Cube;
import com.aksonenko.exercise1.Cylinder;
import com.aksonenko.exercise1.Shape;
import com.aksonenko.exercise1.Sphere;
import com.aksonenko.exercise1.TaskThree;

public class Test3 {

	private TaskThree taskThree;
	private Shape shape;
	private Collection<Shape> shapeCollection;

	@Before
	public void init() {
		taskThree = new TaskThree();
		shapeCollection = new ArrayList<>();

		int cubeSide = 2;
		shape = new Cube(cubeSide);

		int nextCubeSide = 3;
		shapeCollection.add(new Cube(nextCubeSide));

		int radius = 3;
		int height = 6;
		shapeCollection.add(new Cylinder(radius, height));

		int circumference = 20;
		shapeCollection.add(new Sphere(circumference));
	}

	@Test
	public void calculateShapeVolume() {

		assertEquals(8, shape.calculateShapeVolume());
	}

	@Test
	public void noNullShapeInCollection() {
		shapeCollection.add(null);
		shapeCollection.add(shape);

		Assert.assertNotNull(taskThree.sortShapes(shapeCollection));
	}

	@Test
	public void sortShapes() {
		for (Shape shape : shapeCollection) {
			shape.calculateShapeVolume();
		}

		assertEquals(169, taskThree.sortShapes(shapeCollection).get(2).getShapeVolume());
	}

}
