import java.util.*;

public class FirstIntList implements Comparable<FirstIntList>{
    private IntList list = new IntList();
	private int last_line = -1;
	private int c = 0;
	
    public FirstIntList() {
    }

    public FirstIntList add(int x, int line) {
        if (line != last_line) {
			list.add(x);
			last_line = line;
		}
		c++;
        return this;
    }

    public int getLength(){
        return list.getLength();
    }
	
	public int getCount(){
        return c;
    }

    public int intAt(int index){
        return list.intAt(index);
    }

    public String out() {
        StringBuilder sb = new StringBuilder();
        sb.append(c).append(" ").append(list.out());
        return new String(sb);
    }
	
	@Override
	public int compareTo(FirstIntList l) {
        return Integer.compare(this.getCount(), l.getCount());
	}

}