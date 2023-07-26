package telran.interviews.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
	public void sumGroupTest() {
		int[][] groups = { { 1, 2 }, { 3, 4, 5 } };
		int expected = 15;
		assertEquals(expected, sumGroups(groups));
		int[][] groups1 = { { -1, -2, -3 }, { 4, 5 } };
		int expected2 = 3;
		assertEquals(expected2, sumGroups(groups1));
	}

	@Test
	void displayOddEvenGroupingTest() {
		displayOddEvenGroup(20);
	}

	@Test
	void printDigitStatisticsTest() {
		printDigitStatistics();
	}

	@Disabled
	@Test
	void printDigitStatisticsTest_1() {
		printDigitStatistics_1();
	}
}
