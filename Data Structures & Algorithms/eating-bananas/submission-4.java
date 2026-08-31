class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = piles[0];

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int res = max;

        while (min <= max) {
            int m = (min + max) / 2;
            int hours = calcHours(piles, m);
            if (hours <= h) {
                if (m < res) {
                    res = m;
                }
                max = m - 1;
            } else {
                min = m + 1;
            }
        }

        return res;
        
    }

    private int calcHours(int[] piles, int speed) {
        int res = 0;
        for (int pile : piles) {
            res += Math.ceil((double) pile / speed);
        }
        return res;
    }
}
