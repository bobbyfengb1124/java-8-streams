/**
 * author: Feng Bo
 *
 * date: Dec 25, 2017
 */
package studio.bobbyfeng;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.midi.Soundbank;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> someBingoNumbers = Arrays.asList(
				"N40", "N36",
				"B12", "B6",
				"G53", "G49", "G60", "G50", "g64",
				"I26", "I17", "I29", "O71");
		
		List<String> gNumbers = new ArrayList<>();
		
//		someBingoNumbers.forEach(number -> {
//			if(number.toUpperCase().startsWith("G")) {
////				System.out.println(number);
//				gNumbers.add(number);
//			}
//		});
//		
//		gNumbers.sort((s1, s2) -> s1.compareTo(s2));
//		gNumbers.forEach(s -> System.out.println(s));
		someBingoNumbers.stream()
		.map(String::toUpperCase)
		.filter(s->s.startsWith("G"))
		.sorted()
		.forEach(System.out::println);
				
	}

}
