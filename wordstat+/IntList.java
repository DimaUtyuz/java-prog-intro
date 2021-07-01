import java.util.*;

public class IntList {
    private int[] list;
    private int ln;
	
    public IntList() {
        list = new int[1];
        ln = 0;
    }

    private void resize() {
        if (ln + 1 >= list.length) {
            list = Arrays.copyOf(list, list.length * 2);
        }
    }

    public IntList add(int x) {
        resize();
		list[ln] = x;
		ln++;
        return this;
    }

    public int getLength(){
        return ln;
    }

    public int intAt(int index){
        return list[index];
    }

    public String out() {
        StringBuilder sb = new StringBuilder();
        sb.append(list[0]);
        for (int i = 1; i < ln; i++)
            sb.append(" ").append(list[i]);
        return new String(sb);
    }
}