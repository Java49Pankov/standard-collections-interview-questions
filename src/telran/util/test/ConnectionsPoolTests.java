package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.interviews.Connection;
import telran.interviews.ConnectionsPool;
import telran.interviews.ConnectionsPoolImpl;

class ConnectionsPoolImplTest {

	private static int CONNECTIONS_POOL_LIMIT = 5;
	ConnectionsPool pool;

	@BeforeEach
	void setUp() {
		pool = new ConnectionsPoolImpl(CONNECTIONS_POOL_LIMIT);
		pool.addConnection(new Connection(11, "aaa", 1));
		pool.addConnection(new Connection(22, "bbb", 2));
		pool.addConnection(new Connection(33, "ccc", 3));
		pool.addConnection(new Connection(44, "ddd", 4));
		pool.addConnection(new Connection(55, "eee", 5));
	}

	@Test
	void addConnection() {
		// trying to add an existing element
		assertFalse(pool.addConnection(new Connection(33, "ccc", 3)));

		// added element to full pool
		assertTrue(pool.addConnection(new Connection(66, "fff", 6)));

		// checked that this element was removed from the pool and it can be added again
		assertTrue(pool.addConnection(new Connection(11, "aaa", 1)));
	}

	@Test
	void getConnection() {
		assertNotNull(pool.getConnection(33));
		assertEquals(22, pool.getConnection(22).id);
		assertEquals("aaa", pool.getConnection(11).ipAddress);

		assertTrue(pool.addConnection(new Connection(99, "12345", 9)));
		// check that connection 99 has been added
		assertNotNull(pool.getConnection(99));
		// check that connection 44 has been removed
		assertNull(pool.getConnection(44));
		// check that connection 44 has been added
		assertTrue(pool.addConnection(new Connection(44, "4444", 4)));
		// check that connection 55 has been removed
		assertNull(pool.getConnection(55));
		// check that connection 55 has been added
		assertTrue(pool.addConnection(new Connection(55, "5555", 5)));
		// check that connection 33 has been removed
		assertTrue(pool.addConnection(new Connection(33, "3333", 3)));

	}

}