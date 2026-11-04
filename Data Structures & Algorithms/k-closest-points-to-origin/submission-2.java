class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Point> heap = new PriorityQueue<>((a, b) -> b.dist - a.dist);
        
        for (int[] point : points) {
            Point p = new Point(
                point[0],
                point[1],
                (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2))
            );

            heap.offer(p);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point p = heap.poll();
            res[i] = new int[]{p.x, p.y};
        }

        return res;
    }
}

 class Point {
    int x;
    int y;
    int dist;

    Point(int x1, int y1, int dist1) {
        x = x1;
        y = y1;
        dist = dist1;
    }
}
