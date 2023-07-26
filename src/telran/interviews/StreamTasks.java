package telran.interviews;

import java.util.*;

import java.util.stream.Collectors;

record Person(int id, String name) {}

public class StreamTasks {

	static public void displayOccurrences(String strings[]) {
		Arrays.stream(strings)
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
				.entrySet().stream()
				.sorted((e1, e2) -> {
							int res = Long.compare(e2.getValue(), e1.getValue());
							return res != 0 ? res : e1.getKey().compareTo(e2.getKey());
						})
				.forEach(e -> System.out.printf("%s -> %s\n", e.getKey(), e.getValue()));
	}

	static public long sumGroups(int[][] groups) {
		return Arrays.stream(groups)
				.flatMapToInt(g -> Arrays.stream(g))
				.asLongStream().sum();
	}

	static public void displayOddEvenGroup(int nNumbers) {
		new Random().ints(nNumbers)
				.boxed()
				.collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd", Collectors.averagingInt(x -> x)))
				.forEach((k, v) -> System.out.printf("%s -> %.0f\n", k, v));
	}

	static public void printDigitStatistics() {
		int nNumbers = 1_000_000;
		new Random().ints(nNumbers, 0, Integer.MAX_VALUE)
				.flatMap(num -> Integer.toString(num).chars())
				.boxed()
				.collect(Collectors.groupingBy(d -> d, Collectors.counting()))
				.entrySet().stream()
				.sorted((e1, e2) -> {
							int res = Long.compare(e2.getValue(), e1.getValue());
							return res != 0 ? res : e1.getKey().compareTo(e2.getKey());
						})
				.forEach(e -> System.out.printf("%c: %d\n", e.getKey(), e.getValue()));
	}

	static public void printDigitStatistics_1() {
		int nNumbers = 1_000_000;
		new Random().ints(nNumbers, 0, Integer.MAX_VALUE)
				.mapToObj(Integer::toString)
				.flatMap(s -> Arrays.stream(s.split("")))
				.collect(Collectors.groupingBy(d -> d, Collectors.counting()))
				.entrySet().stream()
				.sorted((e1, e2) -> {
							int res = Long.compare(e2.getValue(), e1.getValue());
							return res != 0 ? res : e1.getKey().compareTo(e2.getKey());
						})
				.forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));
	}
	
	public static Map<Integer, Person> getRandomPersonsMap(int nPersons) {
		return new Random().ints(1000, 2001)
				.distinct()
				.limit(nPersons)
				.mapToObj(id -> new Person(id, "name" + id))
				.collect(Collectors.toMap(p -> p.id(), p -> p, (p, u) -> p, TreeMap:: new));
	}
}	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

