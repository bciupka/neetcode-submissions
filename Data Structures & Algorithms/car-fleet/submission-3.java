class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] posSpd = new int[n][2];
        double[] times = new double[n];

        for (int i = 0; i < n; i++) {
            posSpd[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(posSpd, (a, b) -> b[0] - a[0]);
        // Arrays.stream(posSpd).forEach(a -> System.out.println(Arrays.toString(a)));
        
        for (int i = 0; i < n; i++) {
            times[i] = (target - posSpd[i][0]) / (double) posSpd[i][1];
        }

        // System.out.println(Arrays.toString(times));

        int fleets = 0;
        double min = -1;
        for (double i : times) {
            if (i > min) {
                fleets++;
                min = i;
            }
        }

        return fleets;
    }
}
