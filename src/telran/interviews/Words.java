package telran.interviews;

import java.util.*;

public class Words {
	TreeSet<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

	public boolean addWord(String word) {
		return set.add(word);
	}

	public List<String> getWordsByPrefix(String prefix) {
		List<String> words = new ArrayList<>();
		char prefixLastElem = prefix.charAt(prefix.toLowerCase().length() - 1);
		char prefixUpperBound = (char) (prefixLastElem + 1);
		String toElement = prefix.substring(0, prefix.length() - 1) + prefixUpperBound;
		SortedSet<String> prefixSubset = set.subSet(prefix, toElement);
		for (String word : prefixSubset) {
			words.add(word);
		}
		return words;
	}
}
