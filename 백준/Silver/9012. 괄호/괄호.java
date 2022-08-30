import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		Stack<Character> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String result="";
		for (int i = 0; i < n; i++) {
			String str= br.readLine();
			char[] arr = str.toCharArray();

			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == '(') {
					stack.push(arr[j]);
					
				} else if(arr[j]==')'){
					if(stack.empty()) {
						stack.push(arr[j]);
						break;
					}else {
						stack.pop();
					}
				}
			}
			if(stack.empty()) {
				result+="YES\n";
			}else {
				result+="NO\n";
			}
			stack.clear();
		}
		System.out.print(result);
		br.close();
	}
}
