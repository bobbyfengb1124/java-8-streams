/**
 * author: Feng Bo
 *
 * date: Dec 25, 2017
 */
package studio.bobbyfeng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> someBingoNumbers = Arrays.asList("N40", "N36", "B12", "B6", "G53", "G49", "G60", "G50", "g64",
				"I26", "I17", "I29", "O71");

		List<String> gNumbers = new ArrayList<>();

		// someBingoNumbers.forEach(number -> {
		// if(number.toUpperCase().startsWith("G")) {
		//// System.out.println(number);
		// gNumbers.add(number);
		// }
		// });
		//
		// gNumbers.sort((s1, s2) -> s1.compareTo(s2));
		// gNumbers.forEach(s -> System.out.println(s));
		someBingoNumbers.stream().map(String::toUpperCase).filter(s -> s.startsWith("G")).sorted()
				.forEach(System.out::println);

		Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "071");
		Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "071");
		Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
		System.out.println("------------------------------");
		System.out.println(concatStream.distinct().peek(System.out::println).count());

		Employee john = new Employee("John Doe", 30);
		Employee jane = new Employee("Jane Deer", 25);
		Employee jack = new Employee("Jack Hill", 40);
		Employee snow = new Employee("Snow White", 22);

		Department hr = new Department("Human Resources");
		hr.addEmployee(jane);
		hr.addEmployee(jack);
		hr.addEmployee(snow);
		Department accounting = new Department("Accounting");
		accounting.addEmployee(john);

		List<Department> departments = new ArrayList<>();
		departments.add(hr);
		departments.add(accounting);

		departments.stream().flatMap(department -> department.getEmployees().stream()).forEach(System.out::println);

		// List<String> sortedGNumbers = someBingoNumbers
		// .stream()
		// .map(String::toUpperCase)
		// .filter(s -> s.startsWith("G"))
		// .sorted()
		// .collect(Collectors.toList());
		List<String> sortedGNumbers = someBingoNumbers.stream().map(String::toUpperCase).filter(s -> s.startsWith("G"))
				.sorted().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

		for (String s : sortedGNumbers) {
			System.out.println(s);
		}

		Map<Integer, List<Employee>> groupedByAge = departments.stream()
				.flatMap(department -> department.getEmployees().stream())
				.collect(Collectors.groupingBy(employee -> employee.getAge()));

		departments.stream().flatMap(department -> department.getEmployees().stream())
				.reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2).ifPresent(System.out::println);

		Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST").filter(s -> {
			System.out.println(s);
			return s.length() == 3;
		}).count();

		// Lambda Challenge No. 1
		Runnable runnable = () -> {
			String myString = "Let's split this up into an array";

			String[] parts = myString.split(" ");
			for (String part : parts) {
				System.out.println(part);
			}
		};

		// Lambda Challenge No. 2
		Function<String, String> lambdaFunction = source -> {
			StringBuilder returnVal = new StringBuilder();
			for (int i = 0; i < source.length(); i++) {
				if (i % 2 == 1) {
					returnVal.append(source.charAt(i));
				}
			}

			return returnVal.toString();
		};

		// Lambda Challenge No. 3
		System.out.println(lambdaFunction.apply("0123456789"));

		// Lambda Challenge No. 5
		System.out.println(everySecondCharacter(lambdaFunction, "1234567890"));

		// Lambda Challenge No. 6
		Supplier<String> iLoveJava = () -> {
			return "I Love Java";
		};

		// Lambda Challenge No. 7
		String supplierResult = iLoveJava.get();
		System.out.println(supplierResult);
	}

	// Lambda Challenge No. 4
	public final static String everySecondCharacter(Function<String, String> lambdaFunction, String s1) {

		return lambdaFunction.apply(s1);
	}

	public static String everySecondChar(String source) {
		StringBuilder returnVal = new StringBuilder();
		for (int i = 0; i < source.length(); i++) {
			if (i % 2 == 1) {
				returnVal.append(source.charAt(i));
			}
		}

		return returnVal.toString();
	}

}
