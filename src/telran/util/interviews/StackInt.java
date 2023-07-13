package telran.util.interviews;

import java.util.*;

public class StackInt {
	private LinkedList<Integer> number = new LinkedList<>();

	public void push(int num) {
		number.add(num);
	}

	public int pop() {
		if (number.isEmpty()) {
			throw new EmptyStackException();
		}
		int removeElement = number.removeLast();
		return removeElement;
	}

	public boolean isEmpty() {
		return number.isEmpty();
	}

//I cannot understand how to make complexity O[1].
	public int max() {
		int max = number.getFirst();
		for (int num : number) {
			if (num > max) {
				max = num;
			}
		}
		return max;
	}

}
