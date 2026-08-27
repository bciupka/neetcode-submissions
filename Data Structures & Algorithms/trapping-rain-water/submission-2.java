class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxL = height[l], maxR = height[r];
        int vol = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                maxL = Math.max(maxL, height[++l]);
                vol += maxL - height[l];
            } else {
                maxR = Math.max(maxR, height[--r]);
                vol += maxR - height[r];
            }
        }

        return vol;
    }
}
