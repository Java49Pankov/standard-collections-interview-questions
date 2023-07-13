package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.interviews.StackInt;

import java.util.*;
import java.util.stream.IntStream;

class StackIntTest {
	StackInt stack = new StackInt();
	Integer[] numbers = { 10, -22, 13, 50, 40 };

	@BeforeEach
	void setUp() throws Exception {
		for (int num : numbers) {
			stack.push(num);
		}
	}

	@Test
	void pushTest() {
		stack.push(100);
		assertFalse(stack.isEmpty());
	}

	@Test
	void popTest() {
		assertEquals(40, stack.pop());
		assertEquals(50, stack.pop());
		assertEquals(13, stack.pop());
		assertEquals(-22, stack.pop());
		assertEquals(10, stack.pop());
		assertThrowsExactly(EmptyStackException.class, ()-> stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	void isEmptyTest() {
		assertFalse(stack.isEmpty());
		IntStream.range(0, numbers.length).forEach(nPop -> stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	void maxTest() {
		assertEquals(50, stack.max());
		
	}

}
