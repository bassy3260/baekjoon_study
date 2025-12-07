import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, deleteNode;
	static int root;
	static ArrayList<Integer>[] tree;
	static int leafCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			tree[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			
			if (parent == -1) {
				root = i; // 루트노드
			} else {
				tree[parent].add(i); //자식 추가 
			}
		}

		
		deleteNode = Integer.parseInt(br.readLine());

		if (deleteNode == root) { //루트가 삭제노드면 모두 0
			System.out.println(0);
		} else {
			dfs(root); //dfs
			System.out.println(leafCount);
		}
	}

	static void dfs(int node) {
		int validChildCount = 0;

		for (int child : tree[node]) {
			// 삭제노드면 탐색 안함.
			if (child != deleteNode) { //삭제노드가 아니면 자식카운드 ++
				validChildCount++;
				dfs(child); //자식 dfs
			}
		}

		// 자식 카운트가 0이면 리프노드
		if (validChildCount == 0) {
			leafCount++;
		}
	}
}