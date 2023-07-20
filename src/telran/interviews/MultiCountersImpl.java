package telran.interviews;

import java.util.*;

public class MultiCountersImpl implements MultiCounters {
	HashMap<Object, Integer> items = new HashMap<>();
	TreeMap<Integer, HashSet<Object>> map = new TreeMap<>();

	@Override
	public Integer addItem(Object item) {
		HashSet<Object> countSet = new HashSet<>();
		Integer count = items.merge(item, 1, (a, b) -> a + b);
		map.computeIfAbsent(count, k -> countSet).add(item);
		int setKey = count - 1;
		Set<Object> set = map.get(setKey);
		if (set != null) {
			set.remove(item);
			if (set.isEmpty()) {
				map.remove(setKey);
			}
		}
//		System.out.println(items);
//		System.out.println(map);
		return count;
	}

	@Override
	public Integer getValue(Object item) {
		return items.get(item);
	}

	@Override
	public boolean remove(Object item) {
		boolean res = false;
		Integer count = items.remove(item);
		if (count != null) {
			HashSet<Object> countSet = map.get(count);
			countSet.remove(item);
			if (countSet.isEmpty()) {
				map.remove(count);
			}
//			System.out.println(map.lastKey());
			res = true;
		}
		return res;
	}

	@Override
	public Set<Object> getMaxItems() {
//		System.out.println(items);
		System.out.println(map);
		return map.isEmpty() ? new HashSet<>() : map.get(map.lastKey());
	}

}
