package telran.interviews;

import java.util.HashMap;

public class Anagram {

	public static boolean isAnagram(String word, String anagram) {
		boolean res = false;
		if (word.length() == anagram.length()) {
			HashMap<Character, Integer> charCountsMap = getCharCounts(word);
			res = true;
			char[] anagramChars = anagram.toCharArray();
			int index = 0;
			while (index < anagramChars.length && res) {
				if (charCountsMap.compute(anagramChars[index], (k, v) -> v == null ? -1 : v - 1) < 0) {
					res = false;
				}
				index++;
			}
		}
		return res;
	}

	private static HashMap<Character, Integer> getCharCounts(String word) {
		HashMap<Character, Integer> res = new HashMap<>();
		for (char c : word.toCharArray()) {
			res.merge(c, 1, (a, b) -> a + b);
		}
		return res;
	}

}