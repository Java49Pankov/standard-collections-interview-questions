package telran.interviews;

import java.util.*;

public class ConnectionsPoolImpl implements ConnectionsPool {
	LinkedHashMap<Integer, Connection> map;
	int limit;

	public ConnectionsPoolImpl(int limit) {
		if (limit <= 0) {
			throw new IllegalArgumentException("limit must be gratter 0");
		}
		this.limit = limit;
		map = new LinkedHashMap<>(16, .75f, true) {
			protected boolean removeEldestEntry(Map.Entry<Integer, Connection> eldest) {
				return size() > limit;
			}
		};
	}

	@Override
	public boolean addConnection(Connection connection) {
		if (connection == null) {
			throw new NoSuchElementException();
		}
		return map.putIfAbsent(connection.getId(), connection) == null;
	}

	@Override
	public Connection getConnection(int id) {
		return map.get(id);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Connection connection : map.values()) {
			sb.append(connection.toString()).append("\n");
		}
		return sb.toString();
	}

}
