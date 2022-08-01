import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int people = scan.nextInt();

		int count = 0;
		int time[] = new int[people];
		int wait[] = new int[people];
		for (int i = 0; i < people; i++) {
			wait[i] = scan.nextInt();
		}
		int min = 0;
		int index=0;
		for (int i = 0; i < people; i++) {
			min=9999;
			for (int j = i; j < people; j++) {
				if (min > wait[j]) {
					min = wait[j];
					index=j;
				}

			}
			int tmp = wait[i];
			wait[i] = wait[index];
			wait[index] = tmp;
		}
		for (int i = 0; i < people; i++) {
			if (i == 0) {
				time[i] = wait[i];
				count += wait[i];
			} else {
				time[i] = time[i - 1] + wait[i];
				count += time[i];
			}
			
		}
		System.out.print(count);
	}
}
