package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListTest {
	Integer[] numbers = { 10, -30, 13, 48, 22, 17, 23 };
	List<Integer> immutableList = Arrays.asList(numbers);
	List<Integer> mutableList;

	@BeforeEach
	void setUp() throws Exception {
		mutableList = new ArrayList<>(immutableList);
	}

	@Test
	void toArrayTest() {
		assertIterableEquals(mutableList, immutableList);
		assertArrayEquals(numbers, mutableList.toArray(Integer[]::new));
		assertArrayEquals(numbers, immutableList.toArray(Integer[]::new));
	}

	@Test
	void updateListTest() {
		assertThrowsExactly(UnsupportedOperationException.class, () -> immutableList.remove(0));
		List<Integer> subList = mutableList.subList(2, 5);
		subList.clear();
		Integer[] expected = { 10, -30, 17, 23 };
		assertArrayEquals(expected, mutableList.toArray(Integer[]::new));
		subList = mutableList.subList(2, 4);
		subList.set(1, 500);
		Integer[] expected2 = { 10, -30, 17, 500 };
		assertArrayEquals(expected2, mutableList.toArray(Integer[]::new));
		subList.add(0, -50);
		Integer[] expected3 = { 10, -30, -50, 17, 500 };
		assertArrayEquals(expected3, mutableList.toArray(Integer[]::new));
		Integer[] expected4 = { -50, 17, 500 };
		assertArrayEquals(expected4, subList.toArray(Integer[]::new));
	}

	@Test
	void stackTest() {
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		assertFalse(stack.isEmpty());
		assertEquals(10, stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	void queueTest() {
		Queue<Integer> queue = new LinkedList<>();
		assertThrowsExactly(NoSuchElementException.class, () -> queue.remove());
	}

}
