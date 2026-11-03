class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Point> heap = new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));
        
        for (int[] point : points) {
            heap.offer(new Point(
                point[0],
                point[1],
                Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2))));
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
    public int x;
    public int y;
    public double dist;

    public Point(int a, int b, double c) {
        x = a;
        y = b;
        dist = c;
    }
}
