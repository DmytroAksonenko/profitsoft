package com.aksonenko.exercise1;

public class Cylinder extends Shape {

	private final String name = "Cylinder";
	private int radius;
	private int height;
	private int shapeVolume;

	public Cylinder(int radius, int height) {
		this.radius = radius;
		this.height = height;
	}

	@Override
	public int calculateShapeVolume() {
		shapeVolume = (int) (Math.PI * Math.pow(radius, 2) * height);

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
