import java.util.*;
import java.io.*;

public class Main {
	static class block {
		int dur; // 내구도
		boolean ischecked; // 내구도 0인거 체크했는지?

		public block(int dur, boolean ischecked) {
			this.dur = dur;
			this.ischecked = ischecked;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		block[] belt = new block[2 * n]; // 벨트
		boolean[] robot = new boolean[n]; // 로봇이 있는지?
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 2 * n; i++) {
			int num = Integer.parseInt(st.nextToken());
			belt[i] = new block(num, false);
		}

		int sum = 0; // sum이 k개가 되면 종료
		int cnt = 0; // 단계

		// 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다.
		while (sum < k) {
			cnt++;
			
			// 1. 벨트/로봇 함께 이동, 내구도 이동이 없다.
			// 1. 벨트 회전
			block lastBlock = belt[2 * n - 1]; // 마지막 칸 임시 저장
			for (int i = 2 * n - 1; i > 0; i--) {
			    belt[i] = belt[i - 1]; // (i-1)번 칸의 값을 i번 칸으로 이동
			}
			belt[0] = lastBlock; // 임시 저장한 마지막 칸을 0번 위치에 삽입

			// 2. 로봇 회전 (벨트 위에서만)
			for (int i = n - 1; i > 0; i--) {
			    robot[i] = robot[i - 1]; // (i-1)번 로봇을 i번 위치로 이동
			}
			robot[0] = false; // 0번 위치는 항상 비게 됨

			// 3. 회전 직후 로봇 내리기
			// 회전 결과 n-1 위치(내리는 곳)에 도달한 로봇은 즉시 내립니다.
			robot[n - 1] = false;
			
			// 2. 로봇 이동 0~n-1까지만 하죠..
			for (int i = n-2; i >=0; i--) {
				// 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다
				if (belt[i+1].dur >= 1 && robot[i] == true && robot[i+1]==false) {
					robot[i+1] = true;
					robot[i] =false;
					belt[i+1].dur--;
					// 내구도가 0이 되면 0인 벨트 카운트
					if (belt[i+1].dur == 0 && belt[i+1].ischecked == false) {
						sum++;
						belt[i+1].ischecked = true;
					}

				}
			}
			robot[n-1] =  false;
			
			
			// 3. 로봇 올리기
			// 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if (belt[0].dur > 0) {
				robot[0] = true;
				belt[0].dur--;
				if(belt[0].dur == 0 && belt[0].ischecked==false) {
					sum++;
					belt[0].ischecked= true;
				}
			}
		}
		System.out.println(cnt);
	}
}
