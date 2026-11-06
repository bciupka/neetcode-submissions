class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Point> heap = new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));
        
        for (int[] point : points) {
            Point p = new Point(
                point[0],
                point[1],
                Math.pow(point[0], 2) + Math.pow(point[1], 2)
            );

            heap.offer(p);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point cur = heap.poll();
            res[i] = new int[]{cur.x, cur.y};
        }

        return res; 

    }
}

class Point {
    int x;
    int y;
    double dist;

    Point(int a, int b, double c) {
        x = a;
        y = b;
        dist = c;
    }
}