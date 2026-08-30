class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 0;
        int max = piles[0];

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int res = max;

        while (min <= max) {
            int m = (min + max) / 2;
            System.out.println(min);
            System.out.println(max);
            System.out.println(m);
            int hours = calcHours(piles, m);
            System.out.println(hours);
            if (hours <= h) {
                if (m < res) {
                    res = m;
                }
                max = m - 1;
            } else {
                min = m + 1;
            }
            System.out.println(res);
            System.out.println("----------------");
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
