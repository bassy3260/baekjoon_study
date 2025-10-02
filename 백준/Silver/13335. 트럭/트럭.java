import java.io.*;
import java.util.*;


/**
 * 다리를 n 개의 트럭이 건너가려고 한다 트럭의 무게는 서로 같지 않을 수 있다. 다리 위에는 단지 w 대의 트럭만 동시에 올라갈 수있다.
 * 다리의 길이는 w , 각 트럭들은 하나의 단위시간(unit time)에 하나의 단위길이만큼만 이동할 수 있다고 가정한다. 다리 위에 올라가
 * 있는 트럭들의 무게의 합은 다리의 최대하중인 L보다 작거나 같아야 한다.
 */
public class Main {
	static class Truck {
		int num;
		int weight; // 무게
		int go; // 지금 다리 얼마나 건넜는지
		int success; // 0: 오르지도 않음 1: 올랐음 2:끝났음

		public Truck(int num, int weight, int go, int success) {
			super();
			this.num = num;
			this.weight = weight;
			this.go = go;
			this.success = success;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭의 수
		int w = Integer.parseInt(st.nextToken()); // 다리의 길이
		int l = Integer.parseInt(st.nextToken()); // 최대 하중
		Truck[] trucks = new Truck[n];
		st = new StringTokenizer(br.readLine());
		Queue<Truck> wait = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			trucks[i] = new Truck(i,Integer.parseInt(st.nextToken()), 0, 0);
			wait.offer(trucks[i]);
		}

		int successCnt = 0;
		int cnt = 0;
		int nowWeight = 0;
		Queue<Truck> q = new LinkedList<>();
		while (successCnt < n) {
			cnt+=1;
			if (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Truck t = q.poll();
					t.go += 1;
					if (t.go == w) {
						trucks[t.num].success = 2;
						successCnt +=1;
						nowWeight -= t.weight;
					} else {
						q.offer(t);
					}
				}
			}

			// 어떻게 할까..
			int size = wait.size();
			for (int i = 0; i < size; i++) {
				if (nowWeight < l) {
					Truck t = wait.peek();
					if(q.size()<w && nowWeight + t.weight <=l){
						t = wait.poll();
						t.success = 1;
						q.offer(t);
						nowWeight += t.weight;
						break;
					}
				} else {
					break;
				}
			}

		}
		System.out.println(cnt);
	}
}
