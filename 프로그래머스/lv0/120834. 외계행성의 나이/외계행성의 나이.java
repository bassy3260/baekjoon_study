class Solution {
    public String solution(int age) {
        String answer = "";
        int cnt = 0;
        // a~z 아스키 값은 97 ~ 122이다.
        
        while (age/10 != 0 || age%10 != 0) {
            answer = (char)(age%10 + 97) + answer;
            age /= 10;
            cnt++;
        }  
        
        return answer;
    }
}