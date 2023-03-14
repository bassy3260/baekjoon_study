class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int serve = 0;
        
        if (n >= 10) {
            serve = n / 10;
        }
        
        answer = n*12000 + k*2000 - serve*2000;
        
        return answer;
    }
}