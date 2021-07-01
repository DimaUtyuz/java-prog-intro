import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class WordStatCountFirstIndex{
	public static void main(String[] args){
		Map<String, FirstIntList> map = new LinkedHashMap<>();
		try {
			String str;
			File file = new File(args[0]);
			try (Scanner sc = new Scanner(file)) {
				int count = 0;
				int line = 0;
				while (!sc.fileEmpty()) {
					while (sc.hasNextStr()) {
						str = sc.nextWord();
						if (str != null) {
							count++;
							map.computeIfAbsent(str, k -> new FirstIntList()).add(count, line);
						}
					}
					line++;
					count = 0;
					sc.toNextLine();
				}
			}
		} catch (IOException e) {
			System.out.println("Input error: " + e.getMessage());
			return;
		}
		List<Map.Entry<String, FirstIntList>> result = new ArrayList<>(map.entrySet());
		result.sort(Map.Entry.comparingByValue());
		try (BufferedWriter output = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(args[1]), StandardCharsets.UTF_8))) {
			for (Map.Entry<String, FirstIntList> entry : result) {
				output.write(entry.getKey());
				output.write(" ");
				output.write(entry.getValue().out());
				output.newLine();
			}
		} catch (IOException e) {
			System.out.println("Output error: " + e.getMessage());
		}
	}
}
