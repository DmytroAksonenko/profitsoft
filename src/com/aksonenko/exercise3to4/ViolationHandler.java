package com.aksonenko.exercise3to4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ViolationHandler {

	final static String FOLDER = "./files_for_exercises/traffic_violations/";

	@JsonProperty("formed")
	public String formed;

	@JsonProperty("traffic_violations")
	public List<Violator> violations;

	ViolationHandler() {

	}

	private ViolationHandler(String formed, List<Violator> violations) {
		this.formed = formed;
		this.violations = violations;
	}

	private ViolationHandler(List<Violator> violations) {
		this.violations = violations;
	}

	public static void printOutFinesByAmount() throws IOException {

		List<List<ViolationHandler>> newViolations = getViolators();
		Map<Fine, Type> map = new HashMap<>();
		String fileName = "out_fines_by_amount.txt";

		try (PrintWriter out = new PrintWriter(new FileWriter(FOLDER + "result/" + fileName))) {
			for (List<ViolationHandler> list : newViolations) {
				for (ViolationHandler vHandler : list) {
					for (Violator violator : vHandler.violations) {
						if (map.containsValue(violator.type)) {
							for (Entry<Fine, Type> entry : map.entrySet()) {
								if (entry.getKey().type.equals(violator.type)) {
									entry.getKey().setFineAmount(entry.getKey().fineAmount + violator.fineAmount);
								}
							}
						} else {
							map.put(new Fine(violator.type, violator.fineAmount), violator.type);
						}
					}
				}
			}

			Map<String, Integer> resultMap = new HashMap<>();
			for (Entry<Fine, Type> entry : map.entrySet()) {
				resultMap.put(entry.getKey().type.toString(), entry.getKey().fineAmount);
			}

			Map<String, Integer> sortedResultMap = resultMap.entrySet().stream()
					.sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(5).collect(Collectors
							.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o2, LinkedHashMap::new));

			String s = "";
			for (Entry<String, Integer> entry : sortedResultMap.entrySet()) {
				s += entry.getValue() + " : " + entry.getKey() + "\n";
			}

			out.println(s);
			System.out.println(Thread.currentThread().getName() + ": " + fileName + " created");

		}
	}

	public static void printViolators() throws IOException {

		List<List<ViolationHandler>> newViolations = getViolators();
		Map<Violator, String> map = new HashMap<>();
		String fileName = "out_violators.txt";

		try (PrintWriter out = new PrintWriter(new FileWriter(FOLDER + "result/" + fileName))) {
			for (List<ViolationHandler> list : newViolations) {
				for (ViolationHandler vHandler : list) {
					for (Violator violator : vHandler.violations) {
						if (map.containsValue(violator.firstName + "_" + violator.lastName)) {
							for (Entry<Violator, String> entry : map.entrySet()) {
								if (entry.getKey().firstName.equals(violator.firstName)
										& entry.getKey().lastName.equals(violator.lastName)) {
									entry.getKey().setFineAmount(entry.getKey().fineAmount + violator.fineAmount);
									entry.getKey().counter++;
								}
							}
						} else {
							violator.setCounter(1);
							;
							map.put(violator, violator.firstName + "_" + violator.lastName);
						}

					}
				}
			}

			String s = "";
			for (Entry<Violator, String> entry : map.entrySet()) {
				s += entry.getKey().toString();
			}

			out.println(s);
			System.out.println(Thread.currentThread().getName() + ": " + fileName + " created");

		}
	}

	public static List getViolators() {

		ObjectMapper objectMapper = new ObjectMapper();

		File folder = new File(FOLDER);
		File[] listOfFiles = folder.listFiles();
		List<ViolationHandler> list = new LinkedList<>();
		List<List<ViolationHandler>> newViolations = new LinkedList<>();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				System.out.println(Thread.currentThread().getName() + ": " + file.getName() + " processed");
				try {
					list = objectMapper.readValue(file, new TypeReference<List<ViolationHandler>>() {
					});

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			newViolations.add(list);
		}

		return newViolations;
	}
}
