import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

class Scanner implements AutoCloseable{
	private Reader input;
	private String object = null;
	private int next = 0;
	private int n = 0;

	Scanner() {
	}
	
	Scanner(File file) throws IOException {
		input = new InputStreamReader(
					new FileInputStream(file), StandardCharsets.UTF_8);
		next = input.read();
    }
    
    Scanner(InputStream stream) throws IOException {
        input = new InputStreamReader(stream);
		next = input.read();
    }
    
    Scanner(String s) throws IOException {
        input = new StringReader(s);
		next = input.read();
    }
	
	public StringBuilder change(String s) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) >= 'a') && (s.charAt(i) <= 'j')) {
				buf.append(s.charAt(i) - 'a');
			} else {
				buf.append(s.charAt(i));
			}
		}
		return buf;
	}
	
	private boolean isWord(char x) {
		return ((Character.isLetter(x)) || (Character.getType(x) == Character.DASH_PUNCTUATION) || (x == '\''));
	}
	
	private boolean isStop(int x) {
		return ((x == -1) || (x == '\n') || (x == '\r'));
	}
	
	private boolean toInt() {
		try {
			String buf = object.toLowerCase();
			if ((buf.length() > 2) && (buf.charAt(0) == '0') && (buf.charAt(1) == 'x')) {
				n = (int) Long.parseLong(buf.substring(2, buf.length()), 16);
			} else {
				buf = new String(change(buf));
				n = Integer.parseInt(buf);
			}
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public void nextObject() throws IOException {
		if (object != null) {
			return;
		}
		StringBuilder buf = new StringBuilder();
		while ((!isStop(next)) && (Character.isWhitespace(next))) {
			next = input.read();
		}
		while ((!isStop(next)) && (!Character.isWhitespace(next))) {
			buf.append((char) next);
			next = input.read();
		}
		if (buf.length() != 0) {
			object = new String(buf);
		}
	}
	
	public boolean hasNextStr() throws IOException { 
		if (object == null) {
			nextObject();
		}
		return object != null;
	}
	
	public String nextStr() throws IOException {
		if (!hasNextStr()) {
			throw new NoSuchElementException();
		} else {
			String s = object;
			object = null;
			return s;
		}
	}
	
	public String nextWord() throws IOException {
		if (!hasNextStr()) {
			throw new NoSuchElementException();
		} else {
			StringBuilder buf_str = new StringBuilder();
			int i = 0;
			while ((i < object.length()) && (!isWord(object.charAt(i)))) {
				i++;
			}
			while ((i < object.length()) && (isWord(object.charAt(i)))) {
				buf_str.append(Character.toLowerCase(object.charAt(i)));
				i++;
			}
			if (i < object.length()) {
				object = object.substring(i, object.length());
			} else {
				object = null;
			}
			if (buf_str.length() > 0) {
				return new String(buf_str);
			} else {
				return null;
			}
		}
	}
	
	public boolean hasNextInt() throws IOException { 
		if (object == null) {
			nextObject();
		}
		if (object == null) {
			return false;
		} else {
			return toInt();
		}
	}
	
	public int nextInt() throws IOException {
		if (!hasNextInt()) {
            throw new NoSuchElementException();
        }
		if (toInt()) {
			object = null;
			return n;
		} else {
			throw new NumberFormatException();
		}
	}
	
	public void toNextLine() throws IOException {
		object = null;
		while (!isStop(next)) {
			next = input.read();
		}
		if (next == '\r') {
			next = input.read();
			if (next == '\n')
				next = input.read();
		} else {
			next = input.read();
		}
	}
	
	public boolean fileEmpty() throws IOException {
		return next == -1;
	}
	
	public void close() throws IOException {
        input.close();
    }
}