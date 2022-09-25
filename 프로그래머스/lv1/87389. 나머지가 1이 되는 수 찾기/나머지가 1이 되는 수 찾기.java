class Solution {
    public int solution(int n) {
        int answer = 0;
        int a = 0;
        for(answer = 2; answer <= n; answer++) {
            a = n % answer;
            if(a == 1) break;
        }
        return answer;
    }
}