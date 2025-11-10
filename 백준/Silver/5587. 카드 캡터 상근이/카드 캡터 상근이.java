import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();

		for (int i = 1; i <= n * 2; i++) {
			b.add(i);
		}

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			a.add(num);
			b.remove(Integer.valueOf(num));
		}

		Collections.sort(a);
		Collections.sort(b);

		int scoreA = 0;
		int scoreB = 0;
		int nowCard = -1; // 지금 나와있는 카드, -1이면 없다
		int cnt = 0; // 짝수면 상근이, 홀수면 근상이다

		while (true) {
			
			boolean isPass = false;
			if (cnt % 2 == 0) {
				if (nowCard == -1) {
					nowCard = a.get(0);
					a.remove(0);
					if (a.size() == 0) {
						scoreA = b.size();
						break;
					}
				} else {
					for (int i = 0; i < a.size(); i++) {
						if (nowCard < a.get(i)) {
							nowCard = a.get(i);
							a.remove(i);
							isPass = true;
							break;
						}
					}
					if (isPass == false) {
						nowCard = -1;
					}
				}
			} else {
				if (nowCard == -1) {
					nowCard = b.get(0);
					b.remove(0);
					if (b.size() == 0) {
						scoreB = a.size();
						break;
					}
				} else {

					for (int i = 0; i < b.size(); i++) {
						if (nowCard < b.get(i)) {
							nowCard = b.get(i);
							b.remove(i);
							isPass = true;
							break;
						}
					}
					if (isPass == false) {
						nowCard = -1;
					}
				}
			}
			cnt++;
		}
		System.out.println(scoreA);
		System.out.println(scoreB);
	}
}
