
import java.io.*;
import java.util.*;

public class Solution {

	public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
		// 시작위치는 pos
		StringTokenizer st = new StringTokenizer(video_len, ":");

		// 일단 쉽게 접근. 모든 걸 풀어서 보자/
		int totalLength = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
		st = new StringTokenizer(pos, ":");
		int posLength = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
		st = new StringTokenizer(op_start, ":");
		int startLength = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
		st = new StringTokenizer(op_end, ":");
		int endLength = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

		// 커맨드의 길이 만큼 반복한다.
		for (int i = 0; i < commands.length; i++) {

            if(posLength >= startLength && posLength<= endLength) {
				posLength = endLength;
			}
			String com = commands[i];
			switch (com) {
			case "prev":
				if (posLength < 10) {
					posLength = 0;
				} else {
					posLength -= 10;
				}
			break;
			case "next":
				posLength+=10;
				if(posLength>totalLength) {
					posLength= totalLength;
				}
				break;
			}
			
			if(posLength >= startLength && posLength<= endLength) {
				posLength = endLength;
			}
		}
		
		
		String minute = (posLength/60 < 10? "0"+posLength/60 : String.valueOf(posLength/60) );
		String second = (posLength%60 < 10? "0"+posLength%60 : String.valueOf(posLength%60) );
		
		String answer = minute+":"+second;
		return answer;
	}



}
