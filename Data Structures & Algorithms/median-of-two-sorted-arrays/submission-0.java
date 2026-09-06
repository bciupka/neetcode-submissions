class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = total / 2;

        if (A.length > B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int l = 0, r = A.length - 1;
        while (true) {
            int m = Math.floorDiv(l + r, 2);
            int rest = half - m - 2;

            int Aleft = m >= 0 ? A[m] : Integer.MIN_VALUE;
            int Aright = m + 1 < A.length ? A[m + 1] : Integer.MAX_VALUE;
            int Bleft = rest >= 0 ? B[rest] : Integer.MIN_VALUE;
            int Bright = rest + 1 < B.length ? B[rest + 1] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 == 1) {
                    return Math.min(Aright, Bright);
                } else {
                    return (double) (Math.max(Aleft, Bleft)
                        + Math.min(Aright, Bright))
                        / 2;
                }
            } else if (Aleft > Bright) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
    }
}
