class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int first = 0;
        
        // 8 36     1 2 3 4 5 6 7 8 (짝수이면, 짝으로 더해줘야함, 9x4) -> [(36 / 4) / 2], +1
        // -> 36 / 8 = 4.xxx (4-5 짝)
        // 5 50     8 9 10 11 12    (홀수이면, 중간수 x2+로 더해줘야함, 10 + 20x2)             
        // -> 50 / 5 = 10 (10 이후 9-11 짝)
        
        if (num%2 == 0) { // 짝
            first = ((total/num) - (num/2 - 1));
        } else { // 홀
            first = ((total/num) - (num/2));
        }
        
        for (int i = 0; i < num; i++) {
            answer[i] = first;
            first++;
        }
        
        return answer;
    }
}