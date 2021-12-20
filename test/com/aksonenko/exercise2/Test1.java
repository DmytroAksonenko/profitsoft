package com.aksonenko.exercise2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.aksonenko.exercise1.TaskOne;

public class Test1 {

	@Test
	public void getSortedArray() {
		TaskOne taskOne = new TaskOne();
		int array[] = { 3, 4, -1, 0 };

		assertEquals(4, taskOne.getSortedList(array).get(0));
	}

	@Test
	public void getNoNullSortedArray() {
		TaskOne taskOne = new TaskOne();
		int array[] = null;

		Assert.assertNotNull(taskOne.getSortedList(array));
	}

}
