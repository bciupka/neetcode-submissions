class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (numbers[l] + numbers[r] != target) {
            int cur = numbers[l] + numbers[r]; 
            if (cur > target) {
                r--;
            } else {
                l++;
            }
        }

        return new int[]{l+1, r+1};
        
    }
}
