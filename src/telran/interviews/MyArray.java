package telran.interviews;

import java.util.HashMap;

public class MyArray<T> {

	private T array;
	private int size;
	private HashMap<Integer, T> myArray;

	public MyArray(int size) {
		this.size = size;
		myArray = new HashMap<>();
	}

	public void setAll(T value) {
		array = value;
	}

	public T get(int index) {
		T res = null;
		if (index > 0 || index < size) {
			res = myArray.getOrDefault(index, array);
		}
		return res;
	}

	public void set(int index, T value) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		myArray.put(index, value);
	}
}
