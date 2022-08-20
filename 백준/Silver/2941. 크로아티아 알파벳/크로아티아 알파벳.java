import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		char[] arr = str.toCharArray();

		int result = 0;

		for (int i = 0; i < arr.length; i++) {
			if ((i!=arr.length-1)&&arr[i] == 'c') {
				if (arr[i + 1] == '=') {
					result +=1;
					i++;
				} else if (arr[i + 1] == '-') {
					result += 1;
					i++;
				}else {
					result+=1;
				}
			}else if ((i<arr.length-1)&&arr[i] == 'd') {
				if (arr[i + 1] == 'z') {
					if ((i<arr.length-2)&&arr[i + 2] == '=') {
						result += 1;
						i+=2;
					}
					else {
						result+=2;
						i+=1;
					}
				}else if(arr[i + 1] == '-') {
					result +=1;
					i++;
				}else {
					result+=1;
				}
			}else if((i!=arr.length-1)&&arr[i]=='l') {
				if(arr[i+1]=='j') {
					result+=1;
					i++;
				}else {
					result+=1;
				}
			}else if((i!=arr.length-1)&&arr[i]=='n') {
				if(arr[i+1]=='j') {
					result+=1;
					i++;
				}else {
					result+=1;
				}
			}else if((i!=arr.length-1)&&arr[i]=='s') {
				if(arr[i+1]=='=') {
					result+=1;
					i++;
				}else {
					result+=1;
				}
			}else if((i!=arr.length-1)&&arr[i]=='z') {
				if(arr[i+1]=='=') {
					result+=1;
					i++;
				}else {
					result+=1;
				}
			}else {
				result+=1;
			}
		}
		System.out.print(result);
	}
}
