class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        answer[0] = (numer1 * denom2) + (numer2 * denom1);
        answer[1] = denom1 * denom2;
        
        int max = 1;
        int numer = answer[0];
        int denom = answer[1];
        
        for (int i = 1; i <= numer && i <= denom; i++) {
            if (numer % i == 0 && denom % i == 0) {
                max = i;
            }
        }
        answer[0] = numer / max;
        answer[1] = denom / max;
        
        return answer;
    }
}