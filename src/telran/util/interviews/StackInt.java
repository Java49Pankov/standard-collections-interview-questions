package telran.util.interviews;

import java.util.*;

public class StackInt {
	private LinkedList<Integer> number = new LinkedList<>();
	private LinkedList<Integer> maxStack = new LinkedList<>();

	public void push(int num) {
		number.add(num);
		if (maxStack.isEmpty() || num >= maxStack.getLast()) {
			maxStack.add(num);
		}
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

	public int max() {
		if (maxStack.isEmpty()) {
			throw new NoSuchElementException();
		}
		return maxStack.getLast();
	}

}
