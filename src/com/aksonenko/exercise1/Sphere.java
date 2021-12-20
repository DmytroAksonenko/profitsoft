package com.aksonenko.exercise1;

public class Sphere extends Shape {

	private final String name = "Sphere";
	private int circumference;
	private int shapeVolume;

	public Sphere(int circumference) {
		this.circumference = circumference;
	}

	@Override
	public int calculateShapeVolume() {
		shapeVolume = (int) (Math.pow(circumference, 3) / (6 * Math.pow(Math.PI, 2)));

		return shapeVolume;
	}

	@Override
	public int getShapeVolume() {

		return shapeVolume;
	}

	@Override
	public String getName() {

		return name;
	}

}
