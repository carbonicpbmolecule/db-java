import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Database db = new Database();
		DataParser parser = new DataParser();
		try {
			String command_line = "";
		
			while (!command_line.equals("Exit")) {
				command_line = in.next();
	
				if (command_line.equals("Add")) {
					String date_str, event;
					date_str = in.next();
					event = in.next();
					Data data = parser.GetData(date_str);
					db.AddEvent(data, event);
				} else if (command_line.equals("Del")) {
					String data_str = in.next();
					Data data = parser.GetData(data_str);
					int event_count = db.DeleteDate(data);
					System.out.println("Deleted " + event_count + " events");
				} else if (command_line.equals("Find")) {
					String data_str = in.next();
					Data data = parser.GetData(data_str);
					Set<String> events = db.Find(data);
					for (String event : events) {
						System.out.println(event);
					}
				} else if (command_line.equals("Print")) {
					db.Print();
				} else if (!command_line.isEmpty() && !command_line.equals("Exit")) {
					throw new IllegalArgumentException("Unknown command " + command_line);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			in.close();
		}
	}
}
