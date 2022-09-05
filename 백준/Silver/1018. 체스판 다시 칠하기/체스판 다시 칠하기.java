import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static char[][] standardBoard1 = new char[][] { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };

	static char[][] standardBoard2 = new char[][] { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] chess = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				chess[i][j] = str.charAt(j);
			}
		}


		int min_count = Integer.MAX_VALUE;

		int countOfPrinting1 = 0, countOfPrinting2 = 0;
		 for (int i = 0; i < n - 7; i++) {
	            for (int j = 0; j < m - 7; j++) {

	                for (int k = i, a = 0; k < 8 + i; k++, a++) {
	                    for (int l = j, b = 0; l < 8 + j; l++, b++) {
	                        if (chess[k][l] != standardBoard1[a][b]) {
	                            countOfPrinting1++;
	                        }
	                        if (chess[k][l] != standardBoard2[a][b]) {
	                            countOfPrinting2++;
	                        }
	                    }
	                }

	                min_count = Math.min(min_count, Math.min(countOfPrinting1, countOfPrinting2));
	                countOfPrinting1 = 0;
	                countOfPrinting2 = 0;
	            }
	        }
		System.out.print(min_count);
		bw.flush();
		bw.close();
		br.close();
	}

}
