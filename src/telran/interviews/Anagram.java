package telran.interviews;

import java.util.HashMap;

public class Anagram {

	public static boolean isAnagram(String word, String anagram) {
		if (word.length() != anagram.length()) {
			return false;
		}
		boolean res = true;
		String[] arrWord = word.split("");
		String[] arrAnagram = anagram.split("");
		HashMap<String, Integer> wordMap = getMap(arrWord);
		for (String str : arrAnagram) {
			if (wordMap.containsKey(str)) {
				int count = wordMap.get(str);
				if (count == 0) {
					res = false;
				}
				wordMap.put(str, count - 1);
			} else {
				res = false;
			}
		}
		return res;
	}

	private static HashMap<String, Integer> getMap(String[] arrWord) {
		HashMap<String, Integer> map = new HashMap<>();
		for (String str : arrWord) {
			map.merge(str, 1, (a, b) -> a + b);
		}
		return map;
	}

}
