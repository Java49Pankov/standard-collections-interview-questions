package telran.interviews;

import java.util.HashMap;

public class MyArray<T> {
	private T allValues;
	private int size;
	private HashMap<Integer, T> mapOfSets;

	public MyArray(int size) {
		this.size = size;
		mapOfSets = new HashMap<>();
	}

	public void setAll(T value) {
		mapOfSets = new HashMap<>();
		allValues = value;
	}

	public T get(int index) {
		T res = null;
		if (index > -1 && index < size) {
			res = mapOfSets.getOrDefault(index, allValues);
		}
		return res;
	}

	public void set(int index, T value) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index);
		}
		mapOfSets.put(index, value);
	}
}