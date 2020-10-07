public class DataParser {
	private String[] data_parts;

	public Data GetData(String data_str) {
		data_parts = data_str.split("-");
		if (data_parts.length != 3) {
			throw new IllegalArgumentException("Incorrect date " + data_str);
		}
		Data data = new Data(	Integer.parseInt(data_parts[0]), 
								Integer.parseInt(data_parts[1]),
								Integer.parseInt(data_parts[2]));
		return data;
	}
}
