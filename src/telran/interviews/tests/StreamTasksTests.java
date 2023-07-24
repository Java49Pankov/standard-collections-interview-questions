package telran.interviews.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static telran.interviews.StreamTasks.*;

class StreamTasksTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void displayOccurrencestest() {
		String[] strings = { "lmn", "ab", "lmn", "c", "ab", "a", "lmn", "aaa" };
		displayOccurrences(strings);
	}

	@Test
	void displayOddEvenGroupingTest() {
		displayOddEvenGroup(20);
	}

}
