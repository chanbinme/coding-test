class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        answer[0] = (numer1 * denom2) + (numer2 * denom1);
        answer[1] = denom1 * denom2;
        
        int numer = answer[0];
        int denom = answer[1];
        int max = 0;
        if(numer <= denom) {
            max = numer;
        } {
            max = denom;
        }
        
        
        for (int i = max; i >= 1; i--) {
            if (numer % i == 0 && denom % i == 0) {
                answer[0] = numer / i;
                answer[1] = denom / i;
                break;
            }
        }

        return answer;
    }
}