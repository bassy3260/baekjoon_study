import java.io.*;
import java.util.*;

public class Main {
	static char[][] tree = new char[26][2];
	static StringBuilder sb =new  StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		
		for(int i = 0;i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char a= st.nextToken().charAt(0);
			char b= st.nextToken().charAt(0);
			char c= st.nextToken().charAt(0);
			
			int rootIndex = a-'A';
			tree[rootIndex][0] = b; 
			tree[rootIndex][1] = c; 
		}
		
		// --- 순회 시작 (루트 노드 'A'부터) ---
		preOrder('A');
        sb.append("\n");
        inorder('A');
        sb.append("\n");
        postorder('A');
        System.out.println(sb);
	}
	
	public static void preOrder(char node) {
		if(node == '.') {
			return;
		}
		sb.append(node);
		int index = node - 'A';
		preOrder (tree[index][0]);
		preOrder (tree[index][1]);
	}
	
	public static void postorder(char node) {
		if(node == '.') {
			return;
		}
		int index = node - 'A';
		postorder (tree[index][0]);
		postorder (tree[index][1]);
		sb.append(node);
	}
	
	public static void inorder(char node) {
		if(node == '.') {
			return;
		}
		int index = node - 'A';
		inorder (tree[index][0]);
		sb.append(node);
		inorder (tree[index][1]);
	}
}
