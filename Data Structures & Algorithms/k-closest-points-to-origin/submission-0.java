class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Point> distances = new PriorityQueue<>((a, b) -> Double.compare(a.dist, b.dist));
        int[][] res = new int[k][2];

        for (int[] point : points) {
                Point p = new Point(
                    point[0],
                    point[1],
                    Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2))
                );

                distances.offer(p);
        }
        
        for (int i = 0; i < k; i++) {
            Point cur = distances.poll(); 
            res[i] = new int[]{cur.x, cur.y};
        }

        return res;
    }
}

public class Point {
    public int x;
    public int y;
    public double dist;

    public Point(int x, int y, double dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
