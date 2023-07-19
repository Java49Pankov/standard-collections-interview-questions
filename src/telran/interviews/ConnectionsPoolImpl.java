package telran.interviews;

import java.util.*;

public class ConnectionsPoolImpl implements ConnectionsPool {
	LinkedHashMap<Integer, Connection> map = new LinkedHashMap<>(16, .75f, true) {
		protected boolean removeEldestEntry(Map.Entry<Integer, Connection> eldest) {
			return size() > limit;
		}
	};

	int limit;

	public ConnectionsPoolImpl(int limit) {
		this.limit = limit;
	}

	@Override
	public boolean addConnection(Connection connection) {
		boolean res = true;
		if (map.containsKey(connection.getId())) {
			res = false;
		}
		map.put(connection.getId(), connection);
		return res;
	}

	@Override
	public Connection getConnection(int id) {
		return map.get(id);
	}
}
