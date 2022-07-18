import java.util.Arrays;
import java.util.PriorityQueue;

public class P973_kClosestPointsToOrigin {

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] point: points) {
            minHeap.add(point);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (i < k) {
            res[i] = minHeap.poll();
            i++;
        }

        return res;
    }
    public static void main(String[] args) {
        int[][][] points = {
            {{1,3},{-2,2}},
            {{3,3},{5,-1},{-2,4}}
        };
        int[] k = {
            1,
            2
        };
        for (int i = 0; i < points.length; i++) {
            System.out.println(Arrays.deepToString(kClosest(points[i], k[i])));
        }
    }
}
