class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int fullLen = rows * cols;

        int l, r;
        l = 0;
        r = fullLen - 1;
        while (l <= r) {
            int m = (r + l) / 2;
            int row = m / cols;
            int col = m % cols;
            int mVal = matrix[row][col];

            if (mVal == target) return true;
            if (mVal < target) {
                l = m + 1;
                continue;
            }
            r = m - 1;
        }

        return false;
    }
}
