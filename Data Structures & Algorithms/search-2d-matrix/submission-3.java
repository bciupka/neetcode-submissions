class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length;
        int j = matrix[0].length;
        int totalLength = i * j;

        int l = 0;
        int r = totalLength - 1;

        while (l <= r) {
            // int m = l + (r - l) / 2;
            int m = (r + l) / 2;
            int matrixM1 = m / j;
            int matrixM2 = m % j;
            int mVal = matrix[matrixM1][matrixM2];

            if (mVal == target) return true;
            if (mVal > target) r = m - 1;
            if (mVal < target) l = m + 1;
        }

        return false;
    }
}
