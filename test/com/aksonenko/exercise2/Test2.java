package com.aksonenko.exercise2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.aksonenko.exercise1.TaskTwo;

public class Test2 {

	@Test
	public void calculateTopFive() {
		TaskTwo taskTwo = new TaskTwo();

		List<String> list = new LinkedList<>();
		list.add("#Shop");
		list.add(null);
		for (int i = 0; i < 5; i++) {
			list.add("#Auto");
		}
		for (int i = 0; i < 6; i++) {
			list.add("#Home");
		}
		for (int i = 0; i < 4; i++) {
			list.add("#Candy");
		}
		for (int i = 0; i < 3; i++) {
			list.add("#Cat");
		}
		for (int i = 0; i < 2; i++) {
			list.add("#Dog");
		}

		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("#Home", 6);
		map.put("#Auto", 5);
		map.put("#Candy", 4);
		map.put("#Cat", 3);
		map.put("#Dog", 2);

		assertEquals(map, taskTwo.calculateTopFiveList(list));
	}

	@Test
	public void getTopFive() {
		TaskTwo taskTwo = new TaskTwo();
		
		List<String> list = new ArrayList<>();
//	1	Home 1, Auto 1, Cat 1, Candy 1, Sun 1
		list.add("#Home, #Auto, #Cat, #Candy, #Sun");
//	2	Home 2, Auto 1, Cat 1, Candy 2, Sun 1, Dog 1
		list.add("text #Home. Text #Dog.  #Candy");
//	3	Home 2, Auto 2, Cat 1, Candy 3, Sun 1, Dog 1, President 1
		list.add("text #Auto, #Auto, #Candy, #President");
		list.add(null);
//	4	Home 3, Auto 2, Cat 1, Candy 3, Sun 1, Dog 2, President 1
		list.add("#Dog, text #Home. ");
//	5	Home 4, Auto 3, Cat 2, Candy 3, Sun 1, Dog 2, President 1
		list.add("text #Cat. #Home text #Auto");
//	6	Home 5, Auto 4, Cat 2, Candy 4, Sun 1, Dog 2, President 1
		list.add("#Home; #Candy and #Auto");
//	7	Home 6, Auto 5, Cat 3, Candy 4, Sun 1, Dog 2, President 1
		list.add("#Auto #Cat, #Home");

		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("#Home", 6);
		map.put("#Auto", 5);
		map.put("#Candy", 4);
		map.put("#Cat", 3);
		map.put("#Dog", 2);

		assertEquals(map, taskTwo.getTopFiveList(list));
	}

}
