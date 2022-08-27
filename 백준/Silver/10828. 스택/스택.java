import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int size = 0;
	static int[] stack;
	public static void push(int item) {
		stack[size] = item;
		size++;
	}

	public static int pop() {
		if (size == 0) {
			return -1;
		} else {
			int data = stack[size - 1];
			stack[size - 1] = 0;
			size--;
			return data;
		}
	}

	public static int size() {
		return size;
	}

	public static int empty() {
		if (size == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int top() {
		if (size == 0) {
			return -1;
		} else {
			return stack[size - 1];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		stack=new int[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int output=0;
			switch (str) {
			case "push":
				int item = Integer.parseInt(st.nextToken());
				push(item);
				break;
			case "pop":
				output=pop();
				
				bw.write(output+"\n");
				break;
			case "top":
				output=top();
				bw.write(output+"\n");
				break;
			case "empty":
				output=empty();
				bw.write(output+"\n");
				break;
			case "size":
				output=size();
				bw.write(output+"\n");
				break;
			}
		}
		bw.flush();
		bw.close();
	}

}
