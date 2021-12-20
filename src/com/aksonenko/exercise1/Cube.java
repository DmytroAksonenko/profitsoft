package com.aksonenko.exercise1;

public class Cube extends Shape {

	private final String name = "Cube";
	private int cubeSide;
	private int shapeVolume;

	public Cube(int cubeSide) {
		this.cubeSide = cubeSide;
	}

	@Override
	public int calculateShapeVolume() {
		shapeVolume = (int) Math.pow(cubeSide, 3);

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
