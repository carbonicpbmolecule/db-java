import java.util.*;

public class Database {
	private HashMap<Data, Set<String>> storage;

	public Database() {
		storage = new HashMap<Data, Set<String>>();
	}

	public void AddEvent(Data data, String event) {
		Data key = GetKey(data);
		if (storage.keySet().contains(key)) {
			storage.get(key).add(event);
		} else {
			HashSet<String> events = new HashSet<String>();
			events.add(event);
			storage.put(data, events);
		}
	}

	public boolean DeleteEvent(Data data, String event) {
		if (storage.get(data).size() > 0
			&& storage.get(data).contains(event)) {
			storage.get(data).remove(event);
			return true;
		}
		return false;
	}

	public int DeleteDate(Data data) {
		Data key = GetKey(data);
		if (storage.get(key).size() == 0) {
			return 0;
		} else {
			int event_count = storage.get(key).size();
			storage.get(key).clear();
			return event_count;
		}
	}

	private Data GetKey(Data data) {
		Set<Data> keys = storage.keySet();
		for (Data key : keys) {
			if (key.GetYear() == data.GetYear()
				&& key.GetMonth() == data.GetMonth()
				&& key.GetDay() == data.GetDay()) {
				return key;
			}
		}
		return null;
	}

	public Set<String> Find(Data data) {
		Data key = GetKey(data);
		return storage.get(key);
	}

	public void Print() {
		for (Data data : storage.keySet()) {
			System.out.printf("%04d-%02d-%02d ",
								data.GetYear(),
								data.GetMonth(),
								data.GetDay());
			for (String event : storage.get(data)) {
				System.out.printf("%s ", event);
			}
			System.out.print("\n");
		}
	}
}
