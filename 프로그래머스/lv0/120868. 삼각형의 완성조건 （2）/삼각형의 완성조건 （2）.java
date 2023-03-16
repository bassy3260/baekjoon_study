class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int n = 0;
        
        // case1 : x + a >= b 인 경우 (b가 제일 클때)
         // x >= b - a (절댓값쓰기) 
        // case2 : a + b >= x 인 경우 (n이 제일 클때)
         // x <= a + b
        
        for (int i = 0; i < (sides[0] + sides[1]); i++) {
            if (i < sides[0] || i < sides[1]) {
                if (i > Math.abs(sides[0] - sides[1])) {
                    answer++;
                }     
            } else {
                if (i <= (sides[0] + sides[1])) {
                    answer++;
                }   
            }
        }
        return answer;
    }
}