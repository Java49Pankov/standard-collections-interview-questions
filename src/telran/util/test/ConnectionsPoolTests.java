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
		assertFalse(pool.addConnection(new Connection(33, "ccc", 3)));
		assertTrue(pool.addConnection(new Connection(66, "fff", 6)));
		assertTrue(pool.addConnection(new Connection(11, "aaa", 1)));

	}

	@Test
	void getConnection() {
		Connection con55 = pool.getConnection(55);
		Connection con44 = pool.getConnection(44);
		assertEquals(33, pool.getConnection(33).id);
		assertEquals("bbb", pool.getConnection(22).ipAddress);
		assertEquals(2, pool.getConnection(22).port);
		assertNull(pool.getConnection(99));
//		System.out.println(pool.toString());
	}

}
