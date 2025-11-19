import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {1,0};
	static int[] dc = {0,1};
	
	static class Pos{
		int r;
		int c;
		Pos(int r,int c){
			this.r=r;
			this.c=c;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		n =Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0;i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean can = bfs();
		
		if(can) { System.out.println("HaruHaru");}
		else { System.out.println("Hing");}
		
	}
	
	public static boolean bfs() {
		Queue<Pos> q= new LinkedList<>();
		q.offer(new Pos(0,0));
		visited[0][0] = true;
		while(!q.isEmpty()) {
			Pos node =q.poll();
			int dis = map[node.r][node.c];
			
			if(node.r == n-1 && node.c == n-1) {
				return true;
			}
			
			for(int i = 0; i<2; i++) {
				int nr = node.r + dr[i] * dis;
				int nc = node.c  +dc[i] * dis;
				
				if(nr >= n || nc>=n || nr< 0 || nc< 0) continue;
				if(visited[nr][nc]) continue;
				visited[nr][nc] = true;
				q.offer(new Pos(nr,nc));
			}
		}
		return false;
	};
}
