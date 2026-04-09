import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();
		LinkedList<Character> list = new LinkedList<>();
		for (char ch : input.toCharArray()) {
			list.add(ch);
		}

		ListIterator<Character> iter = list.listIterator();
		while (iter.hasNext()) iter.next(); // 커서를 맨 뒤로 이동

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			String[] cmd = br.readLine().split(" ");
			switch (cmd[0]) {
				case "L":
					if (iter.hasPrevious()) iter.previous();
					break;
				case "D":
					if (iter.hasNext()) iter.next();
					break;
				case "B":
					if (iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
				case "P":
					iter.add(cmd[1].charAt(0));
					break;
			}
		}

		for (char ch : list) {
			sb.append(ch);
		}
		System.out.print(sb);
	}
}
