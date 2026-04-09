import java.io.*;
import java.util.*;

public class Main {
    static int MX =10000005;
    static int dat[];
    static int pos = 0; //top이자 갯수
    
    static void push(int X){
        dat[pos] = X;
        pos++;
    }
    static int pop(){
        if(pos ==0){
            return -1;
        }else{
            pos--;
            return dat[pos];
        }
    }
    
    static int size(){
        return pos;
    }
    
    static int empty(){
        if (pos == 0) return 1;
        else return 0;
    }
    
    static int top(){
        if(pos == 0 ) return -1;
        else return dat[pos-1];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dat = new int[MX];
        int cnt = Integer.parseInt(br.readLine());
        for(int i = 0;i<cnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            
            switch(now){
                case 1:
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    System.out.println(pop());
                    break;
                case 3:
                    System.out.println(size());
                    break;
                case 4:
                    System.out.println(empty());
                    break;
                case 5:
                    System.out.println(top());
            }
        }
    }
}