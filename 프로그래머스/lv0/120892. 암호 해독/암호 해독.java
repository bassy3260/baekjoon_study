class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        int key = 0;
        
        for (int i = 1; i < (cipher.length()/code)+1; i++) {
            answer += cipher.charAt(i*code-1);
        }
        
        return answer;
    }
}