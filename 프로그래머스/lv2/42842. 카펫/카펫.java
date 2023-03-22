class Solution {
    public int[] solution(int brown, int yellow) {
        /**
         * (col - 2) * (row - 2) = yellow
         * 가로의 길이는 세로의 길이보다 같거나 길다
         */
        int col;
        int row;
        int sum = brown + yellow;

        // sum의 약수를 구한다.
        for (int i = 1; i <= sum / 2; i++) {
            if (sum % i == 0) {
                col = sum / i;
                row = i;
                
                // yellow가 가운데 들어갈 수 있는지 확인
                if ((col - 2) * (row - 2) == yellow) {
                    return new int[]{col, row};
                }
            }
        }
        return new int[0];
    }
}