package com.aksonenko.exercise1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskTwo {

	public static Map getTopFiveList(Collection<String> collection) {
		List<String> wordsList = new ArrayList<>();

		String splitContains = "\\p{P}?[ \\t\\n\\r]+";

		for (String tag : collection) {
			if (tag != null && tag.contains("#")) {

				String[] splitedList = tag.split(splitContains);
				Set<String> wordsSet = new HashSet();

				for (String word : splitedList) {
					if (word.startsWith("#")) {
						wordsSet.add(word);
					}
				}

				for (String word : wordsSet) {
					wordsList.add(word);
				}

			}

		}

		return calculateTopFiveList(wordsList);
	}

	public static Map calculateTopFiveList(Collection<String> collection) {
		Map<String, Integer> topFiveMap = new HashMap<>();
		Map<String, Integer> resultMap = new LinkedHashMap<>();

		for (String word : collection) {
			topFiveMap.put(word, topFiveMap.getOrDefault(word, 0) + 1);
		}

		resultMap = topFiveMap.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.limit(5)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
						(o1, o2) -> o2, LinkedHashMap::new));

		return resultMap;
	}
}
