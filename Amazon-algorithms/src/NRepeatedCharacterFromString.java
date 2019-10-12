import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Set;

public class NRepeatedCharacterFromString {

	public static void main(String[] args) {
		String line = "this is a pen. this is my pen.";
		char c = findNRepeatedCharacterFromString(1, line);
		System.out.println(c);
		c = findFirstRepeatedCharacterFromString(line);
		System.out.println(c);
	}

	private static char findFirstRepeatedCharacterFromString(String line) {
		if (Objects.isNull(line) || line.isEmpty())
			throw new IllegalArgumentException("Line cannot be null or empty string");
		LinkedHashMap<Character, Integer> cal = getCalculatedList(line);
		return cal.entrySet()
				  .stream()
				  .filter(x -> x.getValue() > 1)
				  .findFirst()
				  .get()
				  .getKey();
	}

	private static char findNRepeatedCharacterFromString(int i, String line) {
		if (i == 0)
			throw new IllegalArgumentException("N limit cannot be zero");
		if (Objects.isNull(line) || line.isEmpty())
			throw new IllegalArgumentException("Line cannot be null or empty string");
		LinkedHashMap<Character, Integer> cal = getCalculatedList(line);
		Set<Character> keys = cal.keySet();
		Character result = null;
		for (Character key : keys) {
			if (cal.get(key) > 1) {
				if (i == 0)
					break;
				result = key;
				--i;
			}
		}
		return result;
	}

	private static LinkedHashMap<Character, Integer> getCalculatedList(String line) {
		LinkedHashMap<Character, Integer> cal = new LinkedHashMap<>();
		char[] data = line.toCharArray();
		for (char c : data) {
			if (cal.containsKey(c)) {
				cal.put(c, cal.get(c) + 1);
			} else {
				cal.put(c, 1);
			}
		}
		return cal;
	}

}
