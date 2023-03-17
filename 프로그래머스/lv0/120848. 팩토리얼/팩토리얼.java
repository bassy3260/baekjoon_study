class Solution {
    public int solution(int n) {
        int answer = 1, i = 1, avg = 1;

        while(avg <= n) {
            avg = avg * (i+1);
            i++;
            answer++;
        }
        
        answer--;
        return answer;
    }
}