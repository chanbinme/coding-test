class Solution {
    int bigSize;
    int smallSize;

    public int solution(int[][] sizes) {
        int width;
        int height;
        int bigSizeMax = 0;
        int smallSizeMax = 0;

        for (int i = 0; i < sizes.length; i++) {
            width = sizes[i][0];
            height = sizes[i][1];
            compareToSize(width, height);
            bigSizeMax = max(bigSizeMax, bigSize);
            smallSizeMax = max(smallSizeMax, smallSize);
        }

        return bigSizeMax * smallSizeMax;
    }

    private void compareToSize(int width, int height) {
        bigSize = Math.max(width, height);
        smallSize = Math.min(width, height);
    }

    private int max(int lengthMax, int longLength) {
        return Math.max(lengthMax, longLength);
    }
}