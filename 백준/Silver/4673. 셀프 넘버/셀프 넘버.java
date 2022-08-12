public class Main {
	
	public static int self_number(int n) {
		int sum=n;
		while(true) {
			if(n==0) break;
			sum+=n%10;
			n=n/10;
		}
		return sum;
	}
	public static void main(String[] args) {
		boolean[] arr=new boolean[10001];
		for(int i=1;i<10001;i++) {
			int a=self_number(i);
			if (a<10001) {
				arr[a]=true;
			}
		}
		for(int i=1;i<10001;i++) {
			if(!arr[i]) {
				System.out.println
				(i);
			}
		}
	}
}
