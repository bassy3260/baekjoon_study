import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	private static void mergeSort(int[] arr) {
		int[] tmp = new int[arr.length];
		mergeSort(arr, tmp, 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, tmp, start, mid);
			mergeSort(arr, tmp, mid + 1, end);
			merge(arr, tmp, start, mid, end);
		}
	}

	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		for (int i = start; i <= end; i++) {
			tmp[i] = arr[i];
		}
		int part1 = start;
		int part2 = mid + 1;
		int index = start;

		while (part1 <= mid && part2 <= end) {
			if (tmp[part1] <= tmp[part2]) {
				arr[index] = tmp[part1];
				part1++;
			} else {
				arr[index] = tmp[part2];
				part2++;
			}
			index++;
		}
		for (int i = 0; i <= mid - part1; i++) {
			arr[index + i] = tmp[part1 + i];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		mergeSort(arr);
		int mode = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		double am = Math.round(((double) sum / (double) n * 10) / 10);
		int median = arr[n / 2];
		int[] plus = new int[4002];
		int[] minus = new int[4001];

		for (int i = 0; i < n; i++) {
			if (arr[i] < 0) {
				minus[Math.abs(arr[i])]++;
			} else {
				plus[arr[i]]++;
			}
		}
		ArrayList<Integer> list = new ArrayList<>();

		// 가장 높은 빈도수 체크
		int max = 0;
		for (int i = 0; i < plus.length; i++) {
			max = Math.max(max, plus[i]);

		}
		for (int i = 0; i < minus.length; i++) {
			max = Math.max(max, minus[i]);
		}
		// 가장 빈도 높은 숫자들 따로 ArrayList에 담기
		for (int i : arr) {
			if (i < 0) {
				if (minus[Math.abs(i)] == max && !(list.contains(i))) {
					list.add(i);
				}
			} else {
				if (plus[i] == max && !(list.contains(i))) {
					list.add(i);
				}
			}
		}

		// 2개 이상이면 2번째로 작은 것 출력
		if (list.size() >= 2) {
			mode = list.get(1);
		}
		// 1개면 그대로
		else {
			mode = list.get(0);
		}
		
		int max1 = arr[0], min = arr[0];
		for (int i = 0; i < n; i++) {
			if (max1 < arr[i]) {
				max1 = arr[i];
			} else if (min > arr[i]) {
				min = arr[i];
			}
		}
		int range = max1 - min;
		System.out.println((int) am);
		System.out.println(median);
		System.out.println(mode);
		System.out.println(range);

	}
}
