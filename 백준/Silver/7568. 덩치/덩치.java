import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] rank= new int[n];
		
		int[][] bulk= new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			bulk[i][0] = Integer.parseInt(st.nextToken());
			bulk[i][1] = Integer.parseInt(st.nextToken());
		}

		int max_h=bulk[0][0];
		int max_w=bulk[0][1];
		
		for(int i=0;i<n;i++) {
			rank[i]++;
				for(int j=0;j<n;j++) {
					if(i==j) {
						continue;
					}
					if(bulk[i][0]<bulk[j][0]&&bulk[i][1]<bulk[j][1]) {
						rank[i]++;
					}
				}
		}
		
		for(int i=0;i<n;i++) {
			bw.write(rank[i]+" ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
