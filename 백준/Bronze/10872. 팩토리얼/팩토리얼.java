import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.util.Scanner;

public class Main {
    public static int pact(int n){
    	if(n<=1) {
    		return 1;
    	}
        return n*pact(n-1);
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.print(pact(n));

		br.close();
	
	}
}
